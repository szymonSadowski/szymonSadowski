package com.diet.main;


import java.awt.*;
// klasa dotyczaca wyswietalnia statystyk podczas gry
public class HUD {
    public  int score=0;
    public  int level=1;
    public int miliseconds = 0;
    public int seconds = 0;
    public int  minutes = 0;
    private float greenValue = 255;
    public static float HEALTH = 100;


    public void tick(){
        // pasek zycia ze zmieniajacymi sie kolorami oraz uruchomianie odpowiadajcej metody za czas
        HEALTH = clamp(HEALTH, 0 ,100);
        greenValue = clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2 ;
        timeTick();


    }
    // pozwala na zmiane koloru w zaleznosci od zycia
    public static float clamp(float var , float min, float max) {
        if( var >= max )
            return var = max;
        else if (var<=min)
            return var=min;
        else return var;
    }

    // wyswietlanie grafiki HUD
    public void render (Graphics g) {
        System.out.println(score);

        g.setColor(Color.gray);
        g.fillRect((int)15, (int)15 , 200 , 32 );
        g.setColor(new Color(75,(int) greenValue , 0));

        g.fillRect((int)15, (int)15 , (int) (HEALTH * 2), 32 );
        g.drawRect((int)15,(int)15,200,32);

        g.setColor(Color.gray);
        g.drawString(HEALTH+"%", 15, 30 );
        g.drawString("Score " + score, 15, 64 );

        g.drawString("Time: " +minutes +":"+seconds+":"+miliseconds,  15,95  );
        g.drawString("Level " + level, 15, 80 );

        g.drawRect((int)15,(int)100,60,32);
        g.drawString("PAUSE" , 25, 120 );

    }

    //getters and setters
    public int getScore() {
        return score ;
    }
    public int getLevel() {
        return level;
    }
    public int getMinutes() { return minutes;}
    public int getMiliseconds(){ return miliseconds;}
    public int getSeconds(){return seconds;}
    public void setlevel(int level){
        this.level = level;
    }

    // funkcja odpowiadająca za czas również w niej zaimplementowane jest spadek zycia w zaleznosci od lvl co sekunde
    public void timeTick() {

            miliseconds++;
            while (miliseconds >= 60) {
                seconds++;
                if(level ==1) {
                    HEALTH = HEALTH - 5;
                }
                if(level ==2) {
                    HEALTH = HEALTH - 6;
                }
                if(level ==3) {
                    HEALTH = HEALTH - 10;
                }
                if(level == 4) {
                    HEALTH = HEALTH - 12;
                }

                miliseconds = 0;
            }
            if (seconds >= 60) {
                minutes++;
                seconds = 0;
            }
        }

// uruchamiana w game sprawdza ilosc punktow czy wystarcza do przejscia na wyzszy poziom

    public void levelUp() {
        if (score > 5) {
            level = 2;
        }
            if(score > 10) {
                level =3;
            }
        if(score > 20) {
            level =4;
        }
    }
}
