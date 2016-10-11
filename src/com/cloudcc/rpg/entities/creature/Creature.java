package com.cloudcc.rpg.entities.creature;

import com.cloudcc.rpg.entities.Entity;

/**
 * Created by hi112 on 10.10.2016.
 */
public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y){
        super(x,y);
        health = 10;
    }


}
