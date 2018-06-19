package com.onn.dungeongame.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile {
	
	public static Tile[] tiles = new Tile[64];
	public static Tile floor_1 = new FloorTile1(0);
	public static Tile wall_1 = new WallTile1(1);
	
	public static final int LOADTILEWIDTH = 32; // This will be used when loading tiles
	public static final int LOADTILEHEIGHT = 32;
	public static final int TILEWIDTH = 64; // This will be used when rendering tiles
	public static final int TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	
	private int id;
	
	public Tile(int id) {
		tiles[id] = this;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public abstract void tick();
	
}
