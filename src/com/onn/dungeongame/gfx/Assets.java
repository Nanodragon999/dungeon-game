package com.onn.dungeongame.gfx;

import com.onn.dungeongame.tiles.Tile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
	
	public static BufferedImage floor_1;
	public static BufferedImage wall_1;
	public static BufferedImage player;
	public static BufferedImage worldBackground;
	
	private static BufferedImage sheet;
	
	public static void init() {
		// Load here all the images
		
		sheet = load("/drawable/sheet.png");
		player = load("/drawable/player.png");
		worldBackground = load("/drawable/world_background.png");
		
		floor_1 = tile(56, 4);
		wall_1 = tile(10, 4);
	}
	
	private static BufferedImage load(String path) {
		// Load a single image
		
		try {
			return ImageIO.read(Assets.class.getResource(path));
		} catch(IOException ex) {
			System.out.println("Failed to load \'" + path + "\': " + ex.getMessage());
			System.exit(1);
		}
		
		return null; // Just return null so Java is happy
	}
	
	private static BufferedImage tile(int x, int y) {
		return sheet.getSubimage(x * Tile.LOADTILEWIDTH, y * Tile.LOADTILEHEIGHT, Tile.LOADTILEWIDTH, Tile.LOADTILEHEIGHT);
	}
	
}
