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
	
	private Input input;
	Player player;
	
	private static int 
	entityTransparency = 196;
	
	private static boolean 
	transparent = true,
	outline = true,
	glow = true;
	
	//constructor
	public Game(int width, int height, boolean fullscreen, boolean windowed) {
		input = new Input();
		display = new Display(width, height, fullscreen, windowed, input);
		gameObjects = new ArrayList<>();
		gameObjects.add(new Player(display.getWidth()/2, display.getHeight()/2, 200, 20, 5, 0.6, "Haffeclad", Color.green, new PlayerOneController(input)));
		gameObjects.add(new Player(display.getWidth()/4, display.getHeight()/4, 100, 20, 5, 0.6, "Huehue", Color.green, new PlayerTwoController(input)));
		
	}
	
	
	//methods
	public void update() {
		
		gameObjects.forEach(Player -> Player.update());
		Entity entity = (Entity) gameObjects.get(0);
		entity.update();
	}
	
	public void render() {
		display.render(this);
		
	}
	
	
	//getters & setters	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public int getEntityTransparency() {
		return entityTransparency;
	}
	
	public boolean getTransparent() {
		return transparent;
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
