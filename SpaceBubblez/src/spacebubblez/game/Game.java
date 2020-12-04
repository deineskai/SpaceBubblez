/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import spacebubblez.controller.PlayerOneController;
import spacebubblez.controller.PlayerTwoController;
import spacebubblez.display.Display;
import spacebubblez.entity.GameObject;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class Game {
	
	//init
	private Display display;
	
	private List<GameObject> gameObjects;
	
	private Input input;
	Player player;
	
	private static int 
	entityTransparency = 196;
	
	private static boolean 
	drawGrid = false,
	entityIsTransparent = true,
	outline = true,
	glow = false;
	
	//constructor
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		input = new Input();
		display = new Display(width, height, fullscreen, windowed, drawGrid, input);
		gameObjects = new ArrayList<>();
		gameObjects.add(new Player(100, 100, 200, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
		gameObjects.add(new Player(100, 300, 200, 10, 4, 0.15f, "Huehue", Color.blue, new PlayerTwoController(input)));
		
	}
	
	
	//methods
	public void update() {
		gameObjects.forEach(GameObject -> GameObject.update());
	}
	
	public void render(int fps) {
		display.render(this, fps);
	}
	
	
	//getters & setters	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public int getEntityTransparency() {
		return entityTransparency;
	}
	
	public boolean entityIsTransparent() {
		return entityIsTransparent;
	}
	
	public boolean getOutline() {
		return outline;
	}
	
	public boolean getGlow() {
		return glow;
	}
	
	public Display getDisplay() {
		return display;
	}
	
}
