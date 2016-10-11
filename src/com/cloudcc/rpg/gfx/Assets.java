package com.cloudcc.rpg.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by hi112 on 10.10.2016.
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player1, player2, grass, dirt, tree;

    public static void init(){

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player1 = sheet.crop(0,0, width, height);
        player2 = sheet.crop(width,0, width, height);
        grass = sheet.crop(width * 2,0, width, height);
        dirt = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
    }
}
