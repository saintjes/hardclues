package hardclues.tasks;

import hardclues.task;
import hardclues.tasks.puzzlebox;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.awt.List;
import java.io.IOException;
import java.util.*;

public class solver extends task {


    public solver(ClientContext ctx) {
        super(ctx);
    }
    java.util.List textureidshuffle = new ArrayList();
    java.util.List textureidcorrect = new ArrayList();


    @Override
    public boolean activate() {

        return false;
    }

    @Override
    public void execute() {




        int c0 = ctx.widgets.widget(1931).component(15).component(0).textureId();
        int c1 = ctx.widgets.widget(1931).component(15).component(1).textureId();
        int c2 = ctx.widgets.widget(1931).component(15).component(2).textureId();
        int c3 = ctx.widgets.widget(1931).component(15).component(3).textureId();
        int c4 = ctx.widgets.widget(1931).component(15).component(4).textureId();
        int c5 = ctx.widgets.widget(1931).component(15).component(5).textureId();
        int c6 = ctx.widgets.widget(1931).component(15).component(6).textureId();
        int c7 = ctx.widgets.widget(1931).component(15).component(7).textureId();
        int c8 = ctx.widgets.widget(1931).component(15).component(8).textureId();
        int c9 = ctx.widgets.widget(1931).component(15).component(9).textureId();
        int c10 = ctx.widgets.widget(1931).component(15).component(10).textureId();
        int c11 = ctx.widgets.widget(1931).component(15).component(11).textureId();
        int c12 = ctx.widgets.widget(1931).component(15).component(12).textureId();
        int c13 = ctx.widgets.widget(1931).component(15).component(13).textureId();
        int c14 = ctx.widgets.widget(1931).component(15).component(14).textureId();
        int c15 = ctx.widgets.widget(1931).component(15).component(15).textureId();
        int c16 = ctx.widgets.widget(1931).component(15).component(16).textureId();
        int c17 = ctx.widgets.widget(1931).component(15).component(17).textureId();
        int c18 = ctx.widgets.widget(1931).component(15).component(18).textureId();
        int c19 = ctx.widgets.widget(1931).component(15).component(19).textureId();
        int c20 = ctx.widgets.widget(1931).component(15).component(20).textureId();
        int c21 = ctx.widgets.widget(1931).component(15).component(21).textureId();
        int c22 = ctx.widgets.widget(1931).component(15).component(22).textureId();
        int c23 = ctx.widgets.widget(1931).component(15).component(23).textureId();
        int c24 = ctx.widgets.widget(1931).component(15).component(24).textureId();

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
        int cc0 = ctx.widgets.widget(1931).component(16).component(0).textureId();
        int cc1 = ctx.widgets.widget(1931).component(16).component(1).textureId();
        int cc2 = ctx.widgets.widget(1931).component(16).component(2).textureId();
        int cc3 = ctx.widgets.widget(1931).component(16).component(3).textureId();
        int cc4 = ctx.widgets.widget(1931).component(16).component(4).textureId();
        int cc5 = ctx.widgets.widget(1931).component(16).component(5).textureId();
        int cc6 = ctx.widgets.widget(1931).component(16).component(6).textureId();
        int cc7 = ctx.widgets.widget(1931).component(16).component(7).textureId();
        int cc8 = ctx.widgets.widget(1931).component(16).component(8).textureId();
        int cc9 = ctx.widgets.widget(1931).component(16).component(9).textureId();
        int cc10 = ctx.widgets.widget(1931).component(16).component(10).textureId();
        int cc11 = ctx.widgets.widget(1931).component(16).component(11).textureId();
        int cc12 = ctx.widgets.widget(1931).component(16).component(12).textureId();
        int cc13 = ctx.widgets.widget(1931).component(16).component(13).textureId();
        int cc14 = ctx.widgets.widget(1931).component(16).component(14).textureId();
        int cc15 = ctx.widgets.widget(1931).component(16).component(15).textureId();
        int cc16 = ctx.widgets.widget(1931).component(16).component(16).textureId();
        int cc17 = ctx.widgets.widget(1931).component(16).component(17).textureId();
        int cc18 = ctx.widgets.widget(1931).component(16).component(18).textureId();
        int cc19 = ctx.widgets.widget(1931).component(16).component(19).textureId();
        int cc20 = ctx.widgets.widget(1931).component(16).component(20).textureId();
        int cc21 = ctx.widgets.widget(1931).component(16).component(21).textureId();
        int cc22 = ctx.widgets.widget(1931).component(16).component(22).textureId();
        int cc23 = ctx.widgets.widget(1931).component(16).component(23).textureId();
        int cc24 = ctx.widgets.widget(1931).component(16).component(24).textureId();

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



    }
}
