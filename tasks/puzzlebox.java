package hardclues.tasks;

import hardclues.task;



import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.IdQuery;
import org.powerbot.script.rt6.Widget;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class puzzlebox extends task {
    static List textureidshuffle = new ArrayList();
    static List textureidcorrect = new ArrayList();

    public puzzlebox(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {

        return !ctx.backpack.select().name("Puzzle box").isEmpty();
    }

    @Override
    public void execute()  {
        int cc00 = ctx.widgets.widget(1931).component(16).component(0).textureId();
        //shuffled
        int c0 = ctx.widgets.widget(1931).component(15).component(0).textureId() - cc00 +1;
        int c1 = ctx.widgets.widget(1931).component(15).component(1).textureId() - cc00 +1;
        int c2 = ctx.widgets.widget(1931).component(15).component(2).textureId() - cc00 +1;
        int c3 = ctx.widgets.widget(1931).component(15).component(3).textureId() - cc00 +1;
        int c4 = ctx.widgets.widget(1931).component(15).component(4).textureId() - cc00 +1;
        int c5 = ctx.widgets.widget(1931).component(15).component(5).textureId() - cc00 +1;
        int c6 = ctx.widgets.widget(1931).component(15).component(6).textureId() - cc00 +1;
        int c7 = ctx.widgets.widget(1931).component(15).component(7).textureId() - cc00 +1;
        int c8 = ctx.widgets.widget(1931).component(15).component(8).textureId() - cc00 +1;
        int c9 = ctx.widgets.widget(1931).component(15).component(9).textureId() - cc00 +1;
        int c10 = ctx.widgets.widget(1931).component(15).component(10).textureId() - cc00 +1;
        int c11 = ctx.widgets.widget(1931).component(15).component(11).textureId() - cc00 +1;
        int c12 = ctx.widgets.widget(1931).component(15).component(12).textureId() - cc00 +1;
        int c13 = ctx.widgets.widget(1931).component(15).component(13).textureId() - cc00 +1;
        int c14 = ctx.widgets.widget(1931).component(15).component(14).textureId() - cc00 +1;
        int c15 = ctx.widgets.widget(1931).component(15).component(15).textureId() - cc00 +1;
        int c16 = ctx.widgets.widget(1931).component(15).component(16).textureId() - cc00 +1;
        int c17 = ctx.widgets.widget(1931).component(15).component(17).textureId() - cc00 +1;
        int c18 = ctx.widgets.widget(1931).component(15).component(18).textureId() - cc00 +1;
        int c19 = ctx.widgets.widget(1931).component(15).component(19).textureId() - cc00 +1;
        int c20 = ctx.widgets.widget(1931).component(15).component(20).textureId() - cc00 +1;
        int c21 = ctx.widgets.widget(1931).component(15).component(21).textureId() - cc00 +1;
        int c22 = ctx.widgets.widget(1931).component(15).component(22).textureId() - cc00 +1;
        int c23 = ctx.widgets.widget(1931).component(15).component(23).textureId() - cc00 +1;
        int c24 = ctx.widgets.widget(1931).component(15).component(24).textureId() +1;

        textureidshuffle.add(c0);
        textureidshuffle.add(c1);
        textureidshuffle.add(c2);
        textureidshuffle.add(c3);
        textureidshuffle.add(c4);
        textureidshuffle.add(c5);
        textureidshuffle.add(c6);
        textureidshuffle.add(c7);
        textureidshuffle.add(c8);
        textureidshuffle.add(c9);
        textureidshuffle.add(c10);
        textureidshuffle.add(c11);
        textureidshuffle.add(c12);
        textureidshuffle.add(c13);
        textureidshuffle.add(c14);
        textureidshuffle.add(c15);
        textureidshuffle.add(c16);
        textureidshuffle.add(c17);
        textureidshuffle.add(c18);
        textureidshuffle.add(c19);
        textureidshuffle.add(c20);
        textureidshuffle.add(c21);
        textureidshuffle.add(c22);
        textureidshuffle.add(c23);
        textureidshuffle.add(c24);
        System.out.println("Shuffled = " + textureidshuffle );

        //correct

        int cc0 = cc00 - cc00 +1;
        int cc1 = ctx.widgets.widget(1931).component(16).component(1).textureId() - cc00 +1;
        int cc2 = ctx.widgets.widget(1931).component(16).component(2).textureId() - cc00 +1;
        int cc3 = ctx.widgets.widget(1931).component(16).component(3).textureId() - cc00 +1;
        int cc4 = ctx.widgets.widget(1931).component(16).component(4).textureId() - cc00 +1;
        int cc5 = ctx.widgets.widget(1931).component(16).component(5).textureId() - cc00 +1;
        int cc6 = ctx.widgets.widget(1931).component(16).component(6).textureId() - cc00 +1;
        int cc7 = ctx.widgets.widget(1931).component(16).component(7).textureId() - cc00 +1;
        int cc8 = ctx.widgets.widget(1931).component(16).component(8).textureId() - cc00 +1;
        int cc9 = ctx.widgets.widget(1931).component(16).component(9).textureId() - cc00 +1;
        int cc10 = ctx.widgets.widget(1931).component(16).component(10).textureId() - cc00 +1;
        int cc11 = ctx.widgets.widget(1931).component(16).component(11).textureId() - cc00 +1;
        int cc12 = ctx.widgets.widget(1931).component(16).component(12).textureId() - cc00 +1;
        int cc13 = ctx.widgets.widget(1931).component(16).component(13).textureId() - cc00 +1;
        int cc14 = ctx.widgets.widget(1931).component(16).component(14).textureId() - cc00 +1;
        int cc15 = ctx.widgets.widget(1931).component(16).component(15).textureId() - cc00 +1;
        int cc16 = ctx.widgets.widget(1931).component(16).component(16).textureId() - cc00 +1;
        int cc17 = ctx.widgets.widget(1931).component(16).component(17).textureId() - cc00 +1;
        int cc18 = ctx.widgets.widget(1931).component(16).component(18).textureId() - cc00 +1;
        int cc19 = ctx.widgets.widget(1931).component(16).component(19).textureId() - cc00 +1;
        int cc20 = ctx.widgets.widget(1931).component(16).component(20).textureId() - cc00 +1;
        int cc21 = ctx.widgets.widget(1931).component(16).component(21).textureId() - cc00 +1;
        int cc22 = ctx.widgets.widget(1931).component(16).component(22).textureId() - cc00 +1;
        int cc23 = ctx.widgets.widget(1931).component(16).component(23).textureId() - cc00 +1;
        int cc24 = ctx.widgets.widget(1931).component(16).component(24).textureId() +1;


        textureidcorrect.add(cc0);
        textureidcorrect.add(cc1);
        textureidcorrect.add(cc2);
        textureidcorrect.add(cc3);
        textureidcorrect.add(cc4);
        textureidcorrect.add(cc5);
        textureidcorrect.add(cc6);
        textureidcorrect.add(cc7);
        textureidcorrect.add(cc8);
        textureidcorrect.add(cc9);
        textureidcorrect.add(cc10);
        textureidcorrect.add(cc11);
        textureidcorrect.add(cc12);
        textureidcorrect.add(cc13);
        textureidcorrect.add(cc14);
        textureidcorrect.add(cc15);
        textureidcorrect.add(cc16);
        textureidcorrect.add(cc17);
        textureidcorrect.add(cc18);
        textureidcorrect.add(cc19);
        textureidcorrect.add(cc20);
        textureidcorrect.add(cc21);
        textureidcorrect.add(cc22);
        textureidcorrect.add(cc23);
        textureidcorrect.add(cc24);
        System.out.println("correct = " + textureidcorrect );

        Condition.wait(() -> ctx.players.local().inCombat(),500,20);



        textureidshuffle.clear();
        textureidcorrect.clear();


    }
}
