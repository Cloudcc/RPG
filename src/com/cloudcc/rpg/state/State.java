package com.cloudcc.rpg.state;

import com.cloudcc.rpg.Game;

import java.awt.*;

/**
 * Created by hi112 on 10.10.2016.
 */
public abstract class State{

    private static State currenState = null;

    public static void setState(State state){
        currenState = state;
    }

    public static State getState(){
        return currenState;
    }


    //CLASS
    protected Game game;

    public State(Game game){
        this.game = game;
    }
    public abstract void tick();
    public abstract void render (Graphics g);


}
