package com.cloudcc.rpg.entities.creature;

import com.cloudcc.rpg.Game;
import com.cloudcc.rpg.gfx.Assets;

import java.awt.*;

/**
 * Created by hi112 on 10.10.2016.
 */
public class Player extends Creature {

    private Game game;
    public Player(Game game, float x, float y){
        super(x,y);
        this.game = game;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().up)
            y -= 1;
        if(game.getKeyManager().down)
            y += 1;
        if(game.getKeyManager().left)
            x -= 1;
        if(game.getKeyManager().right)
            x += 1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player1, (int) x, (int) y, null);
    }


}
