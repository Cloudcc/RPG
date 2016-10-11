package com.cloudcc.rpg.tiles;

import com.cloudcc.rpg.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by hi112 on 11.10.2016.
 */
public class DirtTile extends Tile {


    public DirtTile(int id) {
        super(Assets.dirt, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
