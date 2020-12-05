/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez;

import spacebubblez.game.Game;
import spacebubblez.game.GameLoop;

public class Launcher {
	
	private static Game game = new Game(800, 600, true, true);
	
	public static void main(String [] args) {
		new Thread(new GameLoop(game)).start();
	}
	
	public static Game getGame() {
		return game;
	}
	
}
