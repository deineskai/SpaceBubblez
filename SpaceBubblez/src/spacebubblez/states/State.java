/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.states;

import java.util.ArrayList;
import java.util.List;

import spacebubblez.display.Display;
import spacebubblez.entity.GameObject;
import spacebubblez.input.Input;

public abstract class State {
	
	protected List<GameObject> gameObjects;
	protected Input input;
	
	public State(Input input, Display display) {
		this.input = input;
		gameObjects = new ArrayList<>();
	}
	
	public void update() {
		gameObjects.forEach(GameObject -> GameObject.update());
	}
	
	public List<GameObject> getGameObjects() { return gameObjects; }

}
