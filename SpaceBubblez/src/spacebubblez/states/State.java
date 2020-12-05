/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.states;

import java.util.ArrayList;
import java.util.List;

import spacebubblez.Config;
import spacebubblez.core.Size;
import spacebubblez.display.Camera;
import spacebubblez.display.Display;
import spacebubblez.entity.GameObject;
import spacebubblez.gfx.SpriteLibrary;
import spacebubblez.input.Input;
import spacebubblez.map.GameMap;

public abstract class State {
	
	protected GameMap gameMap;
	protected List<GameObject> gameObjects;
	protected SpriteLibrary spriteLibrary;
	protected Input input;
	protected Camera camera;
	protected Size size;
	
	public State(Input input, Size size) {
		this.input = input;
		this.size = size;
		gameObjects = new ArrayList<>();
		spriteLibrary = new SpriteLibrary();
		gameMap = new GameMap(Config.MAP_SIZE, spriteLibrary);
		camera = new Camera(size);
	}
	
	public void update(Display display) {
		gameObjects.forEach(GameObject -> GameObject.update());
		camera.update(this, display);
		sortGameObjects(gameObjects);
	}
	
	private void sortGameObjects(List<GameObject> gameObjects) {
		List<GameObject> sorted=gameObjects;
		for (int i = sorted.size(); i > 1; i--) {
			for (int j = 0; j < i-1; j++) {
				if (sorted.get(j).getMass() > sorted.get(j+1).getMass()) {
					GameObject current = sorted.get(j);
					sorted.set(j, sorted.get(j+1));
					sorted.set(j+1, current);
				}
			}
		}
		gameObjects = sorted;
	}
	
	
	public List<GameObject> getGameObjects() { return gameObjects; }
	
	public GameMap getGameMap() { return gameMap; }
	
	public Camera getCamera() { return camera; }
	
}
