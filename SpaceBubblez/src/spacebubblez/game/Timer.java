/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

public class Timer {
	
	private int gameAge;
	
	public Timer() {
		this.gameAge = 0;
	}
	
	public int getUpdatesFromSeconds(int secs) {
		return secs * GameLoop.UPS;
	}

}
