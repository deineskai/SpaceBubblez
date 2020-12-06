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
import spacebubblez.state.GameState;
import spacebubblez.state.State;

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
	
	
	//methods
	public void update(Display display) {
		state.update(display);
		//add new enemies & food
		//state.getGameObjects().get(0).getPos().setX(state.getGameObjects().get(0).getPos().getIntX() + 10);
	}
	
	public void render(int fps) {
		display.render(state, fps);
	}
	
	
	//getters
	public Display getDisplay() { return display; }
	
}
