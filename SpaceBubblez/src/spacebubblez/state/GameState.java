/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.state;

import java.awt.Color;

import spacebubblez.Config;
import spacebubblez.controller.EnemieController;
import spacebubblez.controller.PlayerOneController;
import spacebubblez.controller.PlayerTwoController;
import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.display.Display;
import spacebubblez.entity.Enemie;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class GameState extends State {

	public GameState(Input input, Size size) {
		super(input, size);
		
		
		
		initializeEntities();
		
		
		
	}

	private void initializeEntities() {
		Player p2 = new Player(new Position(size.getWidth()/2, size.getHeight()/2), 20, 10, 4, 0.15f, "Huehue", Color.blue, new PlayerTwoController(input));
		if (Config.multiplayer) {
			gameObjects.add(p2);
			gameObjects.add(p2);
		} else {
			gameObjects.add(new Player(new Position(Config.MAP_SIZE.getWidth() * Config.SPRITE_SIZE / 2, Config.MAP_SIZE.getHeight() * Config.SPRITE_SIZE / 2), 200, 10, 4, 0.15f, "Huffleclud", Color.green, new PlayerOneController(input)));
			camera.focusOn(gameObjects.get(0));
		}
		
		//create 
		for (int i = 0; i < 50; i++) {
			gameObjects.add(new Enemie(new Position(Config.MAP_SIZE.getWidth() * Config.SPRITE_SIZE * Math.random(), Config.MAP_SIZE.getHeight() * Config.SPRITE_SIZE * Math.random()), 5 + Math.random() * 20, 10, 4, 0.15f, "enemie"+i, Color.red, new EnemieController()));
		}
		//camera.focusOn(gameObjects.get(6));
	}
}
