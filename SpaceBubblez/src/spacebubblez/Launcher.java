/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez;

import spacebubblez.game.Game;
import spacebubblez.game.GameLoop;

public class Launcher {
	
	private static Game game = new Game(800, 600, Config.fullscreen, Config.windowed);
	
	public static void main(String [] args) {
		new Thread(new GameLoop(game)).start();
	}
	
	public static Game getGame() {
		return game;
	}
	
}
