package com.cloudcc.rpg.worlds;

import com.cloudcc.rpg.Game;
import com.cloudcc.rpg.tiles.Tile;
import com.cloudcc.rpg.utils.Utils;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

/**
 * Created by hi112 on 11.10.2016.
 */
public class World {

    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Game game,String path){
        this.game = game;
        loadWorld(path);


    }

    public void tick(){

    }

    public void render(Graphics g){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x,y).render(g,(int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));

            }
        }

    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if( t == null){
            return  Tile.dirtTile;
        }
        return t;

    }

    private void loadWorld(String path){

        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); //splits every number seperatly
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[0]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
}
