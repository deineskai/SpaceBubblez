/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import spacebubblez.Config;
import spacebubblez.core.Size;
import spacebubblez.display.Display;
import spacebubblez.input.Input;
import spacebubblez.states.GameState;
import spacebubblez.states.State;

public class Game {
	
	//init
	private Input input;
	private Display display;
	private State state;
	
	
	
	
	//constructor
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		input = new Input();
		display = new Display(width, height, fullscreen, windowed, Config.gridVisible, input);
		state = new GameState(input, new Size(display.getWidth(), display.getHeight()));
		
	}
	
	
	public void update() {
		state.update();
	}
	
	public void render(int fps) {
		display.render(state, fps);
	}
	
	
	//getters
	public Display getDisplay() { return display; }
	
}
