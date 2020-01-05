package com.diet.main;

import java.awt.*;
import java.awt.event.*;
// menu
public class Menu  extends MouseAdapter {
    private  Game game;

    public Menu(Game game) {

        this.game = game;

}
 // nawigacja w menu
    public void mousePressed(MouseEvent e) {
    int    mx = e.getX();
    int   my = e.getY();

        if (game.gameState == Game.STATE.Menu) {

            if (mouseOver(mx, my, 380, 150, 200, 64)) {
                game.startGame();
                game.gameState = Game.STATE.Game;


            }
            if (mouseOver(mx, my, 380, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
                System.out.println("HELP");
            }
            if (mouseOver(mx, my, 380, 350, 200, 64)) {
                System.exit(0);
            }
        }
        if(game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 380, 600, 200, 64)) {
                game.gameState = Game.STATE.Menu;
            }
        }
    }

    public void tick() {

    }
    // wyswietlanie menu , help
    public void render(Graphics g) {
        if(game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 420, 70);
            g.setFont(fnt2);
            g.drawString("Play", 450, 190);
            g.setColor(Color.white);
            g.drawRect(380, 150, 200, 64);
            g.drawString("Help", 450, 290);
            g.setColor(Color.white);
            g.drawRect(380, 250, 200, 64);

            g.setColor(Color.white);
            g.drawRect(380, 350, 200, 64);
            g.drawString("Quit", 450, 390);
        }

        else if(game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 420, 70);
            g.setFont(fnt2);

            g.drawString("In XXI century more and more people have diabetes, ", 40 ,130);
            g.drawString("and it's a serious problem. ", 40 ,160);
            g.drawString("This game was made to fight our habits of eating bad food. ", 40 ,190);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("How to play?", 350, 260);
            g.setFont(fnt2);
            g.drawString("LMB on the better food ( lower glycemic index ) to score a point. ", 40 ,320);
            g.drawString("Score as much points as possible ! And use gained knowladge in real life ", 40 ,350);
            g.drawString(" Have FUN ! ", 420 ,400);
            g.drawRect(380, 600, 200, 64);
            g.drawString("Back", 445, 640);
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