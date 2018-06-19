/*
 * Copyright (c) OllieAndNano 2018.
 */

package com.onn.dungeongame;

public class Launcher {
	
	public static final String TITLE = "Dungeon Game";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public static void main(String[] args) {
		Game game = new Game(TITLE, WIDTH, HEIGHT);
		game.start();
	}
	
}