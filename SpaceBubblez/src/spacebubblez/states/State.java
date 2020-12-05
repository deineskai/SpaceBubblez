/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.states;

import java.util.ArrayList;
import java.util.List;

import spacebubblez.core.Size;
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
	
	public State(Input input, Display display) {
		this.input = input;
		gameObjects = new ArrayList<>();
		spriteLibrary = new SpriteLibrary();
		gameMap = new GameMap(new Size(20, 20), spriteLibrary);
	}
	
	public void update() {
		gameObjects.forEach(GameObject -> GameObject.update());
	}
	
	public List<GameObject> getGameObjects() { return gameObjects; }
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
}
