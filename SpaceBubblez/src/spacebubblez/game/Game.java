/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	//init
	private Display display;
	
	private List<GameObject> gameObjects;
	
	
	//constructor
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		display = new Display(width, height, fullscreen, windowed);
		gameObjects = new ArrayList<>();
		gameObjects.add(new Entity(200, 200, 10, 20, 10, 0.15, "Harfecald", Color.green));
		
	}
	
	
	//methods
	public void update() {
		gameObjects.forEach(GameObject -> GameObject.update());
		
	}
	
	public void render() {
		display.render(this);
		
	}
	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}
	
}
