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
import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.display.Display;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class GameState extends State {

	public GameState(Input input, Size size) {
		super(input, size);
		
		Player p1 = new Player(new Position(Config.MAP_SIZE.getWidth() * Config.SPRITE_SIZE / 2, Config.MAP_SIZE.getHeight() * Config.SPRITE_SIZE / 2), 20, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input));
		Player p2 = new Player(new Position(size.getWidth()/2, size.getHeight()/2), 20, 10, 4, 0.15f, "Huehue", Color.blue, new PlayerTwoController(input));
		
		if (Config.multiplayer) {
			gameObjects.add(p1 );
			gameObjects.add(p2);
		} else {
			gameObjects.add(p1);
			camera.focusOn(p1);
		}
		
		
	}
	
	

}
