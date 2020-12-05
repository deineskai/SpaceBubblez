/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import spacebubblez.Config;
import spacebubblez.controller.PlayerOneController;
import spacebubblez.controller.PlayerTwoController;
import spacebubblez.display.Display;
import spacebubblez.entity.GameObject;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class Game {
	
	//init
	private Display display;
	private Input input;
	
	protected List<GameObject> gameObjects;
	
	
	//constructor
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		input = new Input();
		display = new Display(width, height, fullscreen, windowed, Config.gridVisible, input);
		
		gameObjects = new ArrayList<>();
		if (Config.multiplayer) {
			gameObjects.add(new Player(display.getWidth()*0.25, display.getHeight()/2, 20, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
			gameObjects.add(new Player(display.getWidth()*0.75, display.getHeight()/2, 20, 10, 4, 0.15f, "Huehue", Color.blue, new PlayerTwoController(input)));
			gameObjects.add(new Player(display.getWidth()*0.75, display.getHeight()/8, 20, 10, 4, 0.15f, "Aeae", Color.red, new PlayerTwoController(input)));
		} else {
			gameObjects.add(new Player(display.getWidth()/2, display.getHeight()/2, 20, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
		}
	}
	
	
	public void update() {
		gameObjects.forEach(GameObject -> GameObject.update());
	}
	
	public void render(int fps) {
		display.render(this, fps);
	}
	
	
	//getters & setters	
	public List<GameObject> getGameObjects() { return gameObjects; }
	
	public Display getDisplay() {
		return display;
	}
	
}
