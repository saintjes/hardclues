package hardclues.tasks;

import hardclues.task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.*;

public class lootscroll extends task {

    public lootscroll(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.groundItems.select().id(42008).within(10).isEmpty();
    }

    @Override
    public void execute() {
        GroundItem Clue = ctx.groundItems.select().id(42008).poll();
        Clue.interact("Take", "Sealed clue scroll (hard)");
        Condition.wait(() -> {
           final Player local = ctx.players.local();
           while (local.inMotion())Condition.sleep(200);

           return ctx.groundItems.select().id(42008).within(10).isEmpty();
        });
        final Npc Hound1 = ctx.npcs.select().id(92).select().nearest().poll();
        Hound1.interact("Attack");
        Condition.wait(() -> ctx.players.local().inCombat(),120,20);
        System.out.println("LOOTSCROLL");
    }
}
