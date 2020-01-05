package com.diet.main;

import javax.swing.*;
import java.awt.*;
// okno gry
public class Window  extends Canvas {

    public Window (int width, int hight, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width , hight));
        frame.setMaximumSize(new Dimension(width , hight));
        frame.setMinimumSize(new Dimension(width , hight));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
