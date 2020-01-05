package com.diet.main;

import java.awt.*;
// klasa abstrakcyjna która zawiera współzedne oraz ID każdego obiektu (goodfood, badfood) oraz renderowanie i mechanikę całej gry
public abstract class GameObject {
    protected float x;
    protected float y;
    protected ID id;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id =id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
