package com.diet.main;

import java.awt.*;

// klasa zawierajaca obiekty goodfood
public class GoodFood extends  GameObject {
    private Handler handler;
    private Images images;
    private final int z;

    public GoodFood(float x , float y, ID id, Handler handler, int z) {
        super(x,y,id);
        this.handler=handler;
        this.images=images;
        this.z =z;
    }

    public void tick() {

    }

    public void render(Graphics g) {

    //    po wylosowaniu liczby w GamePlay ladujemy wylosowany obraz

        if(z==0){
            g.drawImage(Images.GoodFoodIMG[0]= Images.loadImage("images/avocado.png"),(int)x,(int)y,100,100,null);
        }
        if(z==1){
            g.drawImage(Images.GoodFoodIMG[1]= Images.loadImage("images/apple.png"),(int)x,(int)y,100,100,null);
        }
        if(z==2){
            g.drawImage(Images.GoodFoodIMG[2]= Images.loadImage("images/carrot.png"),(int)x,(int)y,100,100,null);
        }
        if(z==3){
            g.drawImage(Images.GoodFoodIMG[3]= Images.loadImage("images/cherries.png"),(int)x,(int)y,100,100,null);
        }
        if(z==3){
            g.drawImage(Images.GoodFoodIMG[4]= Images.loadImage("images/nut.png"),(int)x,(int)y,100,100,null);
        }
        if(z==4){
            g.drawImage(Images.GoodFoodIMG[5]= Images.loadImage("images/peach.png"),(int)x,(int)y,100,100,null);
        }
        if(z==5){
            g.drawImage(Images.GoodFoodIMG[6]= Images.loadImage("images/peas.png"),(int)x,(int)y,100,100,null);
        }
        if(z==6){
            g.drawImage(Images.GoodFoodIMG[7]= Images.loadImage("images/soy.png"),(int)x,(int)y,100,100,null);
        }

    }

}