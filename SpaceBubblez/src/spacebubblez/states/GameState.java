/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.states;

import java.awt.Color;

import spacebubblez.Config;
import spacebubblez.controller.PlayerOneController;
import spacebubblez.controller.PlayerTwoController;
import spacebubblez.display.Display;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class GameState extends State {

	public GameState(Input input, Display display) {
		super(input, display);
		
		if (Config.multiplayer) {
			gameObjects.add(new Player(display.getWidth()*0.25, display.getHeight()/2, 20, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
			gameObjects.add(new Player(display.getWidth()*0.75, display.getHeight()/2, 20, 10, 4, 0.15f, "Huehue", Color.blue, new PlayerTwoController(input)));
			gameObjects.add(new Player(display.getWidth()*0.75, display.getHeight()/8, 20, 10, 4, 0.15f, "Aeae", Color.red, new PlayerTwoController(input)));
		} else {
			gameObjects.add(new Player(display.getWidth()/2, display.getHeight()/2, 20, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
		}
	}
	
	

}
