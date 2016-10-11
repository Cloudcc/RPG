package com.cloudcc.rpg.entities;

import java.awt.*;

/**
 * Created by hi112 on 10.10.2016.
 */
public abstract class Entity {

    protected float x, y;

    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
