/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

public class Game {
	
	private Display display;
	
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		display = new Display(width, height, fullscreen, windowed);
	}
	
	public void update() {
		
	}
	
	public void render() {
		display.render(this);
	}

}
