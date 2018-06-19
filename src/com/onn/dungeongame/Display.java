/*
 * Copyright (c) OllieAndNano 2018.
 */

package com.onn.dungeongame;

import javax.swing.*;
import java.awt.*;

public class Display {

	private String title;
	private int width;
	private int height;
	private JFrame frame;
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		init();
	}
	
	private void init() {
		// Initialize the JFrame and canvas
		// Also show the window :3
		
		frame = new JFrame(title);
		frame.setSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null); // Just center the jframe
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Simply tells the computer to exit the app once the frame is closed, if not done this, the game will still run tho the window is closed, and it's not good :3
		
		canvas = new Canvas();
		canvas.setSize(new Dimension(width, height));
		canvas.setFocusable(false);
		/*
		 * setFocusable(false); tells the canvas not to get focus
		 * If we don't do this, the focus will go to the canvas
		 * instead of the JFrame, and since the mouse and key
		 * input listeners will be added to the JFrame, that
		 * wouldn't work
		 */
		
		frame.add(canvas);
		frame.pack(); // Fit the canvas size, taking away all the white space
		frame.setVisible(true); // Self-explanatory :3
	}
	
	// Some getters here
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
