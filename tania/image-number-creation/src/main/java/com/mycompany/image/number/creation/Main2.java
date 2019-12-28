/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.image.number.creation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DProkopiuk
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        /*for (int i = 1; i < 51; i++) {
            int width = 250;
            int height = 250;
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();

            Font f = new Font("Sanserif", Font.BOLD, 50);
            g2d.setFont(f);
            g2d.setColor(Color.BLACK);
            g2d.drawString(60+"", 50, 120);
            g2d.dispose();
            File file = new File("img/"+"c"+(50)+".jpg");
            ImageIO.write(bufferedImage, "jpg", file);
        }*/
        //draw(50, 60);
        int t=51;
        draw(t++, 70);
        draw(t++, 80);
        draw(t++, 90);
        draw(t++, 100);
        draw(t++, 110);
        draw(t++, 200);
        draw(t++, 300);
        draw(t++, 400);
        draw(t++, 500);
        draw(t++, 600);
        draw(t++, 700);
        draw(t++, 800);
        draw(t++, 900);
        draw(t++, 1000);
        
        draw(t++, 1001);
        draw(t++, 1010);
        draw(t++, 1100);
        draw(t++, 10000);
        draw(t++, 50000);
        draw(t++, 100000);
        draw(t++, 1000000);
        draw(t++, 100000000);
        draw(t++, 1000000000);
    }
    
    /*private static void c50(){
        draw(50, 60);
    }*/
    
    private static void draw(int fileNumber, int numberValue) throws IOException {
            int width = 250;
            int height = 250;
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();

            Font f = new Font("Sanserif", Font.BOLD, 50);
            g2d.setFont(f);
            g2d.setColor(Color.BLACK);
            g2d.drawString(numberValue+"", 50, 120);
            g2d.dispose();
            File file = new File("img/"+"c"+(fileNumber)+".jpg");
            ImageIO.write(bufferedImage, "jpg", file);
    }

}
