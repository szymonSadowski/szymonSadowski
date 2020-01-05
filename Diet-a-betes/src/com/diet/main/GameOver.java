package com.diet.main;

import java.awt.*;
import java.awt.event.*;
// klasa ktora dotyczy dwoch ekranow , gdy przegramy lub gdy wygramy
public class GameOver extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private int score;
    private int level;
    private int minutes;
    private int seconds;
    private int miliseconds;
    public GameOver(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    public void mousePressed(MouseEvent e) {
        int   mx = e.getX();
        int   my = e.getY();

        // gdy stan gry to GameOver po kliknieciu przechodzimy do Menu oraz resetujemy  uzyskane punkty
        if (game.gameState == Game.STATE.GameOver || game.gameState == Game.STATE.GameFinished) {
            //g.drawRect(520, 380, 120, 64);
            // przechodzimy do menu , oraz resetujemy zdobyte podczas gry punkty, czas gry oraz zycie
            if (mouseOver(mx, my, 520, 380, 120, 64)) {
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
            // jezeli klikamy w exit to wychodzimy z gry
           else if (mouseOver(mx, my, 380, 380, 120, 64)) {
                System.exit(0);
            }
        }
    }

    public void tick(){
        int score = hud.getScore();
        // sprawdzanie czy zycie wynosi 0 jezeli tak przechodzimy do stanu gry GameOver
        if(hud.HEALTH == 0) {
            game.gameState= Game.STATE.GameOver;
        }
        // sprawdzanie czy gra sie nie skonczyla
        if(score==30) {
            game.gameState= Game.STATE.GameFinished;
        }
    }

    public void render(Graphics g) {
        // gdy stan gry GameOver wyswietlamy menu po porazce wraz z wynikiem ,czasem oraz poziomem ktory osiagnelismy
        if(game.gameState == Game.STATE.GameOver) {
            getScore();
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 380, 70);
            g.setFont(fnt2);
            g.drawString("Stats :" ,390, 190);

            g.drawString("Score :"+score,390,250);
            g.drawString("Level :"+level,390,290);
            g.drawString("Time : "+ minutes +":" +seconds + ":"+miliseconds,390,330);
            g.setColor(Color.white);
            g.drawRect(380, 150, 260, 200);


            g.setColor(Color.white);
            g.drawRect(380, 380, 120, 64);
            g.drawString("Quit", 410, 420);
            g.drawRect(520, 380, 120, 64);
            g.drawString("Menu", 540, 420);
        }
        else if(game.gameState == Game.STATE.GameFinished) {
            getScore();
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Congratulations !! ", 300, 70);

            g.setFont(fnt2);
            g.drawString("Stats :" ,390, 190);

            g.drawString("Score :"+score,390,250);
            g.drawString("Level :"+level,390,290);
            g.drawString("Time : "+ minutes +":" +seconds + ":"+miliseconds,390,330);
            g.setColor(Color.white);
            g.drawRect(380, 150, 260, 200);


            g.setColor(Color.white);
            g.drawRect(380, 380, 120, 64);
            g.drawString("Quit", 410, 420);
            g.drawRect(520, 380, 120, 64);
            g.drawString("Menu", 540, 420);
            g.drawString("You have beaten this game, now You are ready to eat healthy! ", 30, 500);
            g.drawString("Use gained knowledge to teach your peers to achive better future.", 30, 530);
            g.drawString("Thanks for playing !", 350, 600);
        }


    }


    public void getScore(){
        // pobieramy wszystkie informacje z huda aby wyswietlic je w ekranie podsumuwującym
        score = hud.getScore();
        level = hud.getLevel();
        minutes = hud.getMinutes();
        seconds =hud.getSeconds();
        miliseconds=hud.getMiliseconds();

    }

    // ta sama funkcja co w game i w menu, sprawdza i porownuje gdzie kliknelismy a gdzie jest nasz obiekt
    private boolean mouseOver (int mx, int my , int x ,int y , int width, int height) {
        if ( mx > x && mx < x +width) {
            if(my > y&& my < y +height) {
                return  true;
            } else return false;
        }else return false;
    }
}
