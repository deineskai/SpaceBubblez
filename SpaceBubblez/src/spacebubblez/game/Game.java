/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Rectangle;

public class Game {
	
	private Display display;
	private Rectangle rectangle;
	
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		display = new Display(width, height, fullscreen, windowed);
		rectangle = new Rectangle(0, 0, 50, 50);
	}
	
	public void update() {
		rectangle.setLocation((int) rectangle.getX() + 1, (int) rectangle.getY());
	}
	
	public void render() {
		display.render(this);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

}
