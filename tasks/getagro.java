package hardclues.tasks;

import hardclues.task;
import org.powerbot.script.rt6.*;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;


public class getagro extends task {



    public getagro(ClientContext ctx) {
        super(ctx);
    }

    final static int EXITMYSTDOOR = 52870;
    final static int ENTERMYSTDOOR = 52851;
    final Tile HOUNDAREATILE = ctx.players.local().tile();

    @Override
    public boolean activate() {
        return ctx.npcs.select().select(npc->npc.interacting().equals(ctx.players.local())).isEmpty() && !ctx.players.local().inCombat() && HOUNDAREATILE.distanceTo(ctx.players.local()) < 10;
    }

    @Override
    public void execute() {
        final Tile outside = new Tile(2854, 9841, 0);
        final Tile insidemidstep = new Tile(1380,4580, 0);
        final Tile inside = new Tile(1394,4587, 0);
        final Tile SPOT = ctx.players.local().tile();
        ctx.movement.step(insidemidstep);
        ctx.camera.turnTo(insidemidstep);
        Condition.wait((() -> insidemidstep.distanceTo(ctx.players.local()) < 3),250,25);
        ctx.movement.step(inside);
        ctx.camera.turnTo(inside);
        Condition.wait(() -> inside.distanceTo(ctx.players.local()) < 7);
    GameObject exitDoor = ctx.objects.select().id(EXITMYSTDOOR).poll();
    exitDoor.interact("Exit", "Mysterious door");
    System.out.println("exit door");
    Condition.wait(() -> ctx.players.local().tile().equals(outside),550,10);
    GameObject enterDoor = ctx.objects.select().id(ENTERMYSTDOOR).poll();
    enterDoor.interact("Enter","Mysterious entrance");
    Condition.wait(() -> ctx.players.local().tile().equals(inside),550,10);
    ctx.movement.step(insidemidstep);
    ctx.camera.turnTo(insidemidstep);
    Condition.wait((() -> insidemidstep.distanceTo(ctx.players.local()) < 2),450,25);
    ctx.movement.step(SPOT);
    ctx.camera.turnTo(SPOT);
    System.out.println("inside again");
    Condition.wait(() -> SPOT.distanceTo(ctx.players.local()) < 3);
    System.out.println("attacking 1st target after reentry");
    final Npc Hound1 = ctx.npcs.select().id(92).select().nearest().poll();
    Hound1.interact("Attack");
    Condition.wait(() -> ctx.players.local().inCombat(),120,20);
    System.out.println("DONE WITH GETAGRO");
}
}
