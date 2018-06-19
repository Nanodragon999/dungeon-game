/*
 * Copyright (c) OllieAndNano 2018.
 */

/*
 * This is the game core
 */

package com.onn.dungeongame;

public class Game implements Runnable {
	
	private String title;
	private int width;
	private int height;
	private Thread thread; // Game thread
	private boolean running = false; // Defines if game is running or not
	
	private Display display; // The game's display
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	public synchronized void start() {
		// Initialize the game if it is not running
		
		if(thread == null && !running) {
			// Check if game is not running, trying to start a running game is not good :3
			
			thread = new Thread(this, title + "-Thread-1");
			running = true; // If we don't set this the game won't run :3
			thread.start();
		}
	}
	
	public void init() {
		// Initialize stuff
		display = new Display(title, width, height);
	}
	
	public synchronized void stop() {
		// Stops the game
		if(running) {
			// Check if the game is running. Trying to stop a stopped thread will cause errors
			
			try {
				running = false;
				thread.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
				// No need to write System.exit() since it will exit anyway
			}
		}
	}
	
	@Override
	public void run() {
		init();
		
		// Game loop
		long initTime = System.nanoTime(); // Defines the start time in nanoseconds
		double delta = 0;
		final int FPS = 30; // This is going to define how many frames should there be in a second
		double time = 1000000000 / FPS; // Defines how many nanoseconds should there be before each tick
		long now = 0; // Will be used later on in the while loop
		int frames = 0; // Will hold the frames that have been drawn into the screen
		
		long timer = System.currentTimeMillis(); // Simply to output the fps every second
		
		while(running) {
			now = System.nanoTime();
			delta += (now - initTime) / time; // Check if the amount of time passed is the same as the amount of time required before ticking
			initTime = now; // Self-explanatory
			
			if(delta >= 1) {
				tick();
				render();
				
				frames++;
				delta--;
			}
			
			// Output the fps every second
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				// Reset frames and timer
				frames = 0;
				timer = System.currentTimeMillis();
			}
		}
	}
	
	private void tick() {
	
	}
	
	private void render() {
	
	}
}