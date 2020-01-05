package com.diet.main;

import java.awt.*;

public class BadFood extends  GameObject {
    private Handler handler;
    private final int z;
    private Images images;

    public BadFood(float x , float y, ID id, Handler handler , int z ) {
        super(x,y,id);
        this.handler=handler;
        this.z = z;
        this.images=images;
    }
    public void tick() {
    }
    public void render(Graphics g) {

// wylosowane z przypisane jest do każdego z obrazków, w zależności od liczby załaduje się inny obrazek
        if(z==0){
            g.drawImage(images.BadFoodIMG[0]= images.loadImage("images/bread.png"),(int)x,(int)y,100,100,null);
        }
        if(z==1){
            g.drawImage(images.BadFoodIMG[1]= images.loadImage("images/beer.png"),(int)x,(int)y,100,100,null);
        }
        if(z==2){
            g.drawImage(images.BadFoodIMG[2]= images.loadImage("images/broadbean.png"),(int)x,(int)y,100,100,null);
        }
        if(z==3){
            g.drawImage(images.BadFoodIMG[3]= images.loadImage("images/cherios.png"),(int)x,(int)y,100,100,null);
        }
        if(z==4){
            g.drawImage(images.BadFoodIMG[4]= images.loadImage("images/croissant.png"),(int)x,(int)y,100,100,null);
        }
        if(z==5){
            g.drawImage(images.BadFoodIMG[5]= images.loadImage("images/donut.png"),(int)x,(int)y,100,100,null);
        }
        if(z==6){
            g.drawImage(images.BadFoodIMG[6]= images.loadImage("images/fries.png"),(int)x,(int)y,100,100,null);
        }
        if(z==7){
            g.drawImage(images.BadFoodIMG[7]= images.loadImage("images/honey.png"),(int)x,(int)y,100,100,null);
        }
        if(z==8){
            g.drawImage(images.BadFoodIMG[8]= images.loadImage("images/popcornpng.png"),(int)x,(int)y,100,100,null);
        }
        if(z==9){
            g.drawImage(images.BadFoodIMG[8]= images.loadImage("images/waffels.png"),(int)x,(int)y,100,100,null);
        }
        if(z==10){
            g.drawImage(images.BadFoodIMG[10]= images.loadImage("images/pineapple.png"),(int)x,(int)y,100,100,null);
        }
    }
}
