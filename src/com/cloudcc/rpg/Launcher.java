package com.cloudcc.rpg;

import com.cloudcc.rpg.display.Display;

/**
 * Created by hi112 on 09.10.2016.
 */
public class Launcher {

    public static void main(String[] args){

        Game game = new Game("Game!", 400, 400);
        game.start();

    }
}
