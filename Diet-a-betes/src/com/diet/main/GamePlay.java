package com.diet.main;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
// klasa w ktorej rozgrywa sie cala zabawa
public class GamePlay  extends MouseAdapter{

    // pozycje gdzie pojawiaja sie nasze obiekty
    public int positiony = 0;
    public int positionx = 0;
    public int positiony2 = 0;
    public int positionx2 = 0;
    public int positiony3 = 0;
    public int positionx3 = 0;
    private  HUD hud;
    private  Handler handler;
    private Game game;
    private Random r  = new Random();;
    public int objectAppered =0;

    public GamePlay(HUD hud, Handler handler,Game game){
    this.handler=handler;
    this.hud = hud;
    this.game=game;
    }

    // HUD x 0 to 120 y 0 to 140 , losujemy pozycje w ktorej ma sie pojawic nasz obiekt, ogranicznenia wynikaja z huda aby nie pojawial sie na nim
    // oraz z tego ze rozmiar obiektu to 100x100 aby nie wyjezdzal poza ekran gry
    public  int randomizerX () {
        Random r = new Random();
        int position = 0;
        position=(ThreadLocalRandom.current().nextInt(240,900));
        return position;
    }

// to samo co w funkcji randomizerX tylko losujemy tutaj pozycje Y
    public  int randomizerY () {
        Random r = new Random();
        int position = 0;
        position = r.nextInt(Game.HEIGHT - 150);
        return position;
    }
public void tick() {tickGame();}

    public void tickGame() {

            // losujemy wszystkie pozycje

             positiony = randomizerY();
             positionx = randomizerX();
             positiony2 = randomizerY();
             positionx2 = randomizerX();
             positiony3 = randomizerY();
             positionx3 = randomizerX();
             // sprawdzamy czy ktores z pozycji sie pokrywaja z 20 pikselowym zapasem, jezeli tak to losujemy pozycje ponownie
        while((positionx > positionx2 - 120 &&  positionx < positionx2 + 120) || (positionx > positionx3 - 120 &&  positionx < positionx3 + 120) ||(positionx2 > positionx3 - 120 &&  positionx2 < positionx3 + 120) ){
            positionx = randomizerX();
            positionx2 = randomizerX();
            positionx3 = randomizerX();
        }

            // mamy 7 good food czyli nextint 8 badfood z =11
            if(hud.level == 1) {
                objectAppered = r.nextInt(4);
                handler.addObject(new BadFood(positionx2, positiony2, ID.BadFood, handler, objectAppered));
                handler.addObject(new GoodFood(positionx, positiony, ID.GoodFood, handler,r.nextInt(3)));
                //hud.scoreKeep(score++);
            }
            else if (hud.level == 2) {
                // check i objectAppered sa zmiennymi dzieki ktorym nie pojawia sie ten sam obiekt
                int check =0;
                objectAppered = r.nextInt(7);
                check = objectAppered;
                handler.addObject(new BadFood(positionx2, positiony2, ID.BadFood, handler, objectAppered));
                objectAppered = r.nextInt(7);
                while(objectAppered == check) {
                    objectAppered = r.nextInt(7);
                }
                handler.addObject(new BadFood(positionx3, positiony3, ID.BadFood, handler, objectAppered));
                handler.addObject(new GoodFood(positionx, positiony, ID.GoodFood, handler,r.nextInt(5)));

            }
            else if (hud.level == 3 ) {
                // check i objectAppered sa zmiennymi dzieki ktorym nie pojawia sie ten sam obiekt (BadFood)
                int check =0;
                objectAppered = r.nextInt(11);
                check = objectAppered;
                handler.addObject(new BadFood(positionx2, positiony2, ID.BadFood, handler, objectAppered));
                while(objectAppered == check) {
                    objectAppered = r.nextInt(11);
                }
                handler.addObject(new BadFood(positionx3, positiony3, ID.BadFood, handler, objectAppered));
                handler.addObject(new GoodFood(positionx, positiony, ID.GoodFood, handler,r.nextInt(7)));
            }
            else if (hud.level == 4 ) {
                // check i objectAppered sa zmiennymi dzieki ktorym nie pojawia sie ten sam obiekt (BadFood)
                int check =0;
                objectAppered = r.nextInt(11);
                check = objectAppered;
                handler.addObject(new BadFood(positionx2, positiony2, ID.BadFood, handler, objectAppered));
                while(objectAppered == check) {
                    objectAppered = r.nextInt(11);
                }
                handler.addObject(new BadFood(positionx3, positiony3, ID.BadFood, handler, objectAppered));
                handler.addObject(new GoodFood(positionx, positiony, ID.GoodFood, handler,r.nextInt(7)));
            }

        }
}
