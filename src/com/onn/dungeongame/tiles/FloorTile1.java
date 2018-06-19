package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.Assets;

public class FloorTile1 extends Tile {
	
	public FloorTile1(int id) {
		super(id);
		texture = Assets.floor_1;
	}
	
	@Override
	public void tick() {
	
	}
	
}
