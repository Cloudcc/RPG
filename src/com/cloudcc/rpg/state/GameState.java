package com.cloudcc.rpg.state;

import com.cloudcc.rpg.Game;
import com.cloudcc.rpg.entities.creature.Player;
import com.cloudcc.rpg.gfx.Assets;
import com.cloudcc.rpg.tiles.Tile;
import com.cloudcc.rpg.worlds.World;

import java.awt.*;

/**
 * Created by hi112 on 10.10.2016.
 */
public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Game game){
        super(game);
        player = new Player(game, 0, 0);
        world = new World(game, "res/worlds/world1.txt");

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
 ;
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();


    }
}
