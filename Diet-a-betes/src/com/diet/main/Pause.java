package com.diet.main;

import java.awt.*;
import java.awt.event.*;
// klasa dotyczaca ekranu pauzy
public class Pause extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;

    public Pause(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {

        if(game.gameState == Game.STATE.Pause) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Pause", 420, 70);
            g.setFont(fnt2);
            g.drawString("Resume", 425, 190);
            g.setColor(Color.white);
            g.drawRect(380, 150, 200, 64);
            g.drawString("Menu", 440, 290);
            g.setColor(Color.white);
            g.drawRect(380, 250, 200, 64);

            g.setColor(Color.white);
            g.drawRect(380, 350, 200, 64);
            g.drawString("Quit", 450, 390);
        }
    }
    public void mousePressed(MouseEvent e) {
        int   mx = e.getX();
        int   my = e.getY();

        if (game.gameState == Game.STATE.Pause) {
            //Resume  g.drawRect(380, 150, 200, 64);
            if (mouseOver(mx, my, 380, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
            }
            // Menu g.drawRect(380, 250, 200, 64);
            if (mouseOver(mx, my, 380, 250, 200, 64)) {

                hud.HEALTH =100;
                hud.score=0;
                hud.level=1;
                hud.minutes=0;
                hud.seconds=0;
                hud.miliseconds=0;
                handler.clearObjects();
                handler.clearObjects();

                game.gameState = Game.STATE.Menu;



            }
            // Quit g.drawRect(380, 350, 200, 64);
            if (mouseOver(mx, my, 380, 350, 200, 64)) {
                System.exit(0);
            }
        }
    }
    private boolean mouseOver (int mx, int my , int x ,int y , int width, int height) {
        if ( mx > x && mx < x +width) {
            if(my > y&& my < y +height) {
                return  true;
            } else return false;
        }else return false;
    }
}
