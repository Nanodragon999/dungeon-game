package com.onn.dungeongame.world;

import com.onn.dungeongame.tiles.Tile;
import java.awt.*;
import java.io.*;

public class World {
	
	private int width;
	private int height;
	private int playerX = 0;
	private int playerY = 0;
	private Tile[] tiles;
	
	public World() {
		width = 0;
		height = 0;
	}
	
	public void loadWorld(String path) {
		/*
		 * The world format will be as following:
		 *
		 * width height playerx playery tiles...
		 *
		 * where width is the world width, height the world height,
		 * playerx the x spawn position for the player and playery
		 * the y spawn position for the player. There must be
		 * width * height tiles.
		 *
		 * Tiles are represented by a number, which is their ID
		 */
		
		File f = new File(path);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line, content = "";
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			
			content = sb.toString();
			
			String[] tokens = content.split("\\s+"); // Split tokens by every white space
			
			width = Integer.parseInt(tokens[0]);
			height = Integer.parseInt(tokens[1]);
			playerX = Integer.parseInt(tokens[2]);
			playerY = Integer.parseInt(tokens[3]);
			
			tiles = new Tile[width * height];
			
			for(int i = 4; i < tokens.length; i++) {
				tiles[i - 4] = Tile.tiles[Integer.parseInt(tokens[i])];
			}
			
		} catch(IOException ex) {
			System.out.println("Failed to load world \'" + path + "\': " + ex.getMessage());
			System.exit(1);
		} catch(ArrayIndexOutOfBoundsException|NumberFormatException ex) {
			System.out.println("Invalid world format");
			System.exit(1);
		}
	}
	
	public void render(Graphics g) {
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < tiles.length; i++) {
			g.drawImage(tiles[i].getTexture(), x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
			x++;
			
			if(x == width) {
				y++;
				x = 0;
			}
		}
	}
	
	public void tick() {
		for(int i = 0; i < tiles.length; i++) {
			tiles[i].tick();
		}
	}
	
}
