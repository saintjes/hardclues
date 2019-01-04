package hardclues.tasks;

import hardclues.task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;


public class prayer extends task {
    public prayer(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.powers.quickPrayersActive() && ctx.players.local().inCombat() && ctx.powers.prayerPoints() > 150;
    }

    @Override
    public void execute() {
     ctx.powers.quickPrayers(true);
     Condition.wait(()-> ctx.powers.quickPrayersActive(),200, 25);
     System.out.println("PRAYERDONE");

    }
}
