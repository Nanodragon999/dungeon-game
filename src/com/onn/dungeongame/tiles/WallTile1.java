package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.Assets;

public class WallTile1 extends Tile {
	
	public WallTile1(int id) {
		super(id);
		texture = Assets.wall_1;
	}
	
	@Override
	public void tick() {
	
	}
	
}
