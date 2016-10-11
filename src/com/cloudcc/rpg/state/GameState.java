package com.cloudcc.rpg.state;

import com.cloudcc.rpg.Game;
import com.cloudcc.rpg.entities.creature.Player;
import com.cloudcc.rpg.gfx.Assets;
import com.cloudcc.rpg.tiles.Tile;

import java.awt.*;

/**
 * Created by hi112 on 10.10.2016.
 */
public class GameState extends State{

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 100);

    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        Tile.tiles[0].render(g, 0, 0);
      ;
    }

    @Override
    public void tick() {

        player.tick();

    }
}
