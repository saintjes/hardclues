package hardclues.tasks;

import hardclues.task;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.*;

import java.awt.*;

public class antiban extends task {

    public antiban(ClientContext ctx) {
        super(ctx);
    }
    final Tile HOUNDAREATILE = new Tile(1376,4578, 0);


    public boolean atHounds() {
      if (HOUNDAREATILE.distanceTo(ctx.players.local()) < 10 && ctx.players.local().inCombat()  ){
          return true;
      } else {return false;}

    }

    @Override
    public boolean activate() {
        Random r = new Random();
        int ra = r.nextInt(1,250);
        return atHounds() && (ra == 25 || ra == 50 || ra == 75);
    }

    @Override
    public void execute() {
        int r = Random.nextInt(0,10);
        switch (r){
            case 0:
                Condition.sleep(Random.nextInt(1500,4500));
                System.out.println("Antipattern-Case0:Sleeping");
                break;
            case 1:
                ctx.input.move(-100,Random.nextInt(100,350));
                Condition.sleep(Random.nextInt(2500,5500));
                System.out.println("Antipattern-Case1:Moving mouse offscreen");

                break;
            case 2:
                System.out.println("Antipattern-Case2:Hovering a other Player");

                Player pl = ctx.players.select().nearest().poll();
                pl.hover();
                Condition.sleep(Random.nextInt(500,2500));
                break;
            case 3:
                System.out.println("Antipattern-Case3:Moving mouse offscreen");

                int x = Random.nextInt(-500, -100);
                int y = Random.nextInt(-500, -100);
                ctx.input.move(x, y);
                ctx.input.defocus();
                Condition.sleep(Random.nextInt(5000, 13000));
                ctx.input.focus();
                x = Random.nextInt(16, 512);
                y = Random.nextInt(45, 334);
                ctx.input.move(x, y);
                break;
            case 4:
                System.out.println("Antipattern-Case4:Turning Camera to nearest player");
                ctx.camera.turnTo(ctx.players.select().nearest().poll());
                break;
            case 5:
                System.out.println("Antipattern-Case5:Random mouse moving");

                int maxDistance = 0;
                int minDistance = 0;
                double xvec = Math.random();
                if (Random.nextInt(0, 2) == 1) {
                    xvec = -xvec;
                }
                double yvec = Math.sqrt(1 - xvec * xvec);
                if (Random.nextInt(0, 2) == 1) {
                    yvec = -yvec;
                }
                double distance = maxDistance;
                Point p = ctx.input.getLocation();
                int maxX = (int) Math.round(xvec * distance + p.x);
                distance -= Math.abs((maxX - Math.max(0,
                        Math.min(ctx.game.getViewport().width, maxX)))
                        / xvec);
                int maxY = (int) Math.round(yvec * distance + p.y);
                distance -= Math.abs((maxY - Math.max(0,
                        Math.min(ctx.game.getViewport().height, maxY)))
                        / yvec);
                if (distance < minDistance) {
                    return;
                }
                distance = Random.nextInt(minDistance, (int) distance);
                ctx.input.move((int) (xvec * distance) + p.x, (int) (yvec * distance) + p.y);
                break;
            case 6:
                System.out.println("Antipattern-Case6:Hovering Prayer EXP");
                if (atHounds() && !ctx.players.local().inMotion()){
                    ctx.widgets.widget(548).component(49).click();
                    Condition.sleep(Random.nextInt(300, 500));
                    if (ctx.widgets.widget(320).component(5).valid()) {
                        ctx.widgets.widget(320).component(5 ).hover();
                        Condition.sleep(Random.nextInt(2500, 5000));
                        ctx.widgets.widget(548).component(51).click();
                    }
                }
                break;
            case 7:
                System.out.println("Antipattern-Case7:Activating quickprayer");
                if (ctx.widgets.widget(160).component(19).valid() && ctx.powers.prayerPoints() < 20){
                    ctx.widgets.widget(160).component(19).click();
                }
                break;

            case 8:
                System.out.println("Antipattern-Case8:Changing mouse speed");
                ctx.input.speed(Random.nextInt(65,100));
                break;
            case 9:
                System.out.println("Antipattern-Case9:Hovering Hound");
                final Npc nearesrnpc = ctx.npcs.select().nearest().poll();
                if (nearesrnpc.inViewport()){
                    nearesrnpc.hover();
                    Condition.sleep(Random.nextInt(500,2500));
                }
                break;
            case 10:
                System.out.println("Antipattern-Case10:Examine Hound");
                Npc npc = ctx.npcs.select().nearest().poll();
                npc.interact("Examine", npc.name());
                break;

            default:
                System.out.println("Antipattern-Case-default:Changing mouse speed");
                ctx.input.speed(Random.nextInt(65,100));



        }

    }
}
