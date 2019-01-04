package hardclues;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

import java.io.IOException;

public abstract class task extends ClientAccessor {
    public task(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();

}
