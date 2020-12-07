/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.state;

import java.awt.Color;

import spacebubblez.Config;
import spacebubblez.Util;
import spacebubblez.controller.EnemieController;
import spacebubblez.controller.FoodController;
import spacebubblez.controller.PlayerOneController;
import spacebubblez.controller.PlayerTwoController;
import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.entity.Enemie;
import spacebubblez.entity.Food;
import spacebubblez.entity.Player;
import spacebubblez.input.Input;

public class GameState extends State {

	public GameState(Input input, Size size) {
		super(input, size);
		
		
		
		initializeEntities();
		
		
		
	}

	private void initializeEntities() {
		Player p1 = new Player(new Position(
				Config.MAP_SIZE.getWidth() * Config.SPRITE_SIZE / 2, 
				Config.MAP_SIZE.getHeight() * Config.SPRITE_SIZE / 2), 
				200, 
				10, 
				4, 
				0.15f, 
				"Huffleclud", 
				Color.green, 
				new PlayerOneController(input));
		
		Player p2 = new Player(new Position(
				Config.MAP_SIZE.getWidth() * Config.SPRITE_SIZE / 2+200, 
				Config.MAP_SIZE.getHeight() * Config.SPRITE_SIZE / 2), 
				20, 
				10, 
				4, 
				0.15f, 
				"Huehue",
				Color.blue, 
				new PlayerTwoController(input));
		
		if (Config.multiplayer) {
			gameObjects.add(p1);
			gameObjects.add(p2);
		} else {
			gameObjects.add(p1);
		}
		camera.focusOn(gameObjects.get(0));
		
		initializeEnemies(100);
		
		initializeFood(500);
		
		//camera.focusOn(gameObjects.get(6));
	}
	
	

	private void initializeEnemies(int num) {
		for (int i = 0; i < num; i++) {
			gameObjects.add(new Enemie(gameMap.getRandomPos(), 20 + Math.random() * 100, 10, 4, 0.15f, "enemie"+i, Util.getRandomEnemieColor(), new EnemieController()));
		}
	}
	private void initializeFood(int num) {
		for (int i = 0; i < num; i++) {
			gameObjects.add(new Food(gameMap.getRandomPos(), 1 + Math.random() * 2, 10, 0, 0.15, "", Util.getRandomFoodColor(), new FoodController()));
		}
	}
}
