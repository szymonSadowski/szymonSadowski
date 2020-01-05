package com.diet.main;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

public class Game extends Canvas  implements  Runnable
{
    public static final int WIDTH = 1024 , HEIGHT = 768;
    private Thread thread;
    private boolean running = false ;
    private Random r;
    private  Handler handler;
    private  Menu menu;
    private HUD hud;
    private Images images;
    private GamePlay gamePlay;
    private GameOver gameOver;
    private Pause pause;
    public boolean ba;
    // kazdy stan gry ma swoje przedstawienie w tym enumie jako STATE, dzieki temu latwo mozna je zmieniac
    public enum STATE {
        Game,
        Menu,
        Help,
        GameOver,
        Pause,
        GameFinished
    };
    // zaczynamy od Stanu Menu
    public STATE gameState = STATE.Menu;

        public Game() {

            menu = new Menu(this);
            hud = new HUD();
            handler = new Handler();
            images = new Images();
            gameOver = new GameOver(this, handler , hud);
            gamePlay = new GamePlay(hud, handler, this);
            pause = new Pause(this,handler,hud);
            new Window(WIDTH, HEIGHT, "Die-a-betes", this);
            r = new Random();

            Images.loadImages();

            // mouselistnery sa w 4 klasach, jedna z nich Game nie musimy jej dodawac bo w niej jestesmy i jest ona klasa glowna, a pozostale sa tu dodane
             this.addMouseListener(menu);
             this.addMouseListener(gameOver);
             this.addMouseListener(pause);
             // spawn pierwszego przeciwnika, aby nie pojawial sie dopiero po kolejnym kliknieciu
             // startGame();

            // BadFood.loadImages();
           addMouseListener(new MouseAdapter() {

               public void mousePressed(MouseEvent e) {
                   // pobieramy klik, wspolrzedne
                 int  mx = e.getX();
                 int  my = e.getY();

                    if (gameState == STATE.Game) {

                    // sprawdzamy gdzie jest klik jezeli dobry to
                        // sprawdzamy czy nasza ilosc punktow zasluguje na lvl up, dodajemy troszke zycia , usuwamy elementy , spawnujemy nastepne obiekty
                    if (mouseOver(mx, my, gamePlay.positionx, gamePlay.positiony, 100, 100)) {

                     hud.score++;
                     hud.levelUp();
                     hud.HEALTH=hud.HEALTH +5;
                     handler.clearObjects();
                     handler.clearObjects();

                     gamePlay.tick();

                }   // g.drawRect((int)15,(int)100,60,32); <- pozycja gdzie jest przycisk z pause
                    // jezeli jest klik w miejsce pauzy przechodzimy do stanu pauza
                    else if(mouseOver(mx, my,15 , 100, 60,32)) {
                        gameState= STATE.Pause;

                    }
            }
        }
              });

        }
        public void startGame() {
            gamePlay.tick();
        }


     // sprawdzanie czy miejsce w ktorym kliknelismy zawiera sie w danym prostokacie, sprawdzamy lewy dolny rog i gorny prawy
    private boolean mouseOver (int mx, int  my, int x , int y , int width, int height) {
        System.out.println("From Function Position x " + gamePlay.positionx+" Positionn y " + gamePlay.positiony + " Where You Cliked X " + mx + " Where You Clicked Y " + my);
        if ( mx >= x && mx <= x +width) {
            if(my >= y&& my <= y +height) {
                return  true;
            } else return false;
        }else return false;
    }


        public synchronized  void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized  void stop() {
        try {
            thread.join();
            running = false;

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // tutaj decydujemy co pokazujemy na ekranie w zaleznosci od stanu gry
    private  void render () {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs ==null) {
            this.createBufferStrategy(3);
            return;
        }


        Graphics g= bs.getDrawGraphics();
        g.setColor(Color.black);

        g.fillRect(0,0,WIDTH,HEIGHT);

        // w zależnosci od stanu gry wyświetalmy rendery z różnych klas tak aby odpowiadały temu co dzieje się na ekranie
        if(gameState == STATE.Game ) {
            handler.render(g);
            hud.render(g);
        }
        else if (gameState == STATE.Menu || gameState ==STATE.Help)  {
            menu.render(g);
        }
        else if(gameState == STATE.GameOver || gameState == STATE.GameFinished) {
            gameOver.render(g);
        }
        else if(gameState==STATE.Pause) {
            pause.render(g);
        }
        g.dispose();;
        bs.show();
    }
    // funkcja dzieki ktorej nasza gra moze dzialac, polega na odswiezaniu klatek
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks ;
        double delta = 0 ;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer +=1000;
                //        System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    // kazde odswiezenie klatki to jest nowy tick, w nim znajduja sie elementy ktore nalezy sprawdzac co klatke
    private  void tick () {

        handler.tick();

        // jezeli stan gry to gra aktywujemy huda ( informacje dotyczace zycia itp) oraz sprawdzamy czy gra nie jest skonczona
        if(gameState == STATE.Game)
        {
        hud.tick();
        gameOver.tick();

        }
        // tutaj sprawdzamy czy zycie wynosci 0 punktow
        else if(gameState == STATE.GameOver) {
            gameOver.tick();
        }

    }

    public void mouseReleased(MouseEvent e){
}

    public static void main(String[] args) {
        new Game();
    }

    }

