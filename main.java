package hardclues;

import hardclues.tasks.*;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import java.util.ArrayList;
import java.util.List;



@Script.Manifest(name="hardclues", description = "kill the hounds, get the clues, kill the hounds get the clues", properties ="client=6; auther=saintjex; topic=999;")
public class main extends PollingScript<ClientContext> {
    List<task> tasklist = new ArrayList<task>();

    @Override
    public void start(){
        tasklist.add(new puzzlebox(ctx));
        tasklist.add(new getagro(ctx));
        tasklist.add(new lootscroll(ctx));
        tasklist.add(new prayer(ctx));
        tasklist.add(new antiban(ctx));
        System.out.println(tasklist);
    }

    @Override
    public void poll() {

    for (task task : tasklist){
        if (task.activate()) {
            task.execute();
            break;
        }

    }

    }
}
