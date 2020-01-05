package com.diet.main;

import javax.swing.*;
import java.awt.*;
// wszystkie obrazy wykorzystywane w grze
public class Images{

    public static Image[] GoodFoodIMG ;
    public static Image[] BadFoodIMG ;

    // zaladowanie wszystkich obrazkow do tablic
    public static void loadImages(){
        BadFoodIMG = new Image[11];
        BadFoodIMG[0]= loadImage("images/bread.png");
        BadFoodIMG[1]= loadImage("images/beer.png");
        BadFoodIMG[2]= loadImage("images/broadbean.png");
        BadFoodIMG[3]= loadImage("images/cherios.png");
        BadFoodIMG[4]= loadImage("images/croissant.png");
        BadFoodIMG[5]= loadImage("images/donut.png");
        BadFoodIMG[6]= loadImage("images/fries.png");
        BadFoodIMG[7]= loadImage("images/honey.png");
        BadFoodIMG[8]= loadImage("images/popcornpng.png");
        BadFoodIMG[9]= loadImage("images/waffels.png");
        BadFoodIMG[10]= loadImage("images/pineapple.png");

        GoodFoodIMG = new Image[8];
        GoodFoodIMG[0]= loadImage("images/avocado.png");
        GoodFoodIMG[1]= loadImage("images/apple.png");
        GoodFoodIMG[2]= loadImage("images/carrot.png");
        GoodFoodIMG[3]= loadImage("images/cherries.png");
        GoodFoodIMG[4]= loadImage("images/nut.png");
        GoodFoodIMG[5]= loadImage("images/peach.png");
        GoodFoodIMG[6]= loadImage("images/peas.png");
        GoodFoodIMG[7]= loadImage("images/soy.png");

    }

    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

}
