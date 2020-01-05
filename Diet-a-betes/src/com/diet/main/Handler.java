package com.diet.main;

import java.awt.*;
import java.util.*;
// klasa zawierajaca akcje na obiektach
public class Handler {

    LinkedList<GameObject> object = new LinkedList<>();

    public void tick() {
        for (int i=0; i< object.size(); i ++){
            GameObject tempObject = object.get(i);
            tempObject.tick();

        }

    }
    // wyswietlamy obrazy
    public void render(Graphics g) {
        for(int i=0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
     // usuwamy obrazy z ekranu
    public void clearObjects(){
        for(int i=0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            removeObject(tempObject);
        }
    }
    //dodawanie obiektów
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public  void removeObject(GameObject object){
        this.object.remove(object);
    }

}
