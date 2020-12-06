/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

public class Timer {
	
	public Timer() {
	}
	
	public int getUpdatesFromSeconds(int secs) {
		return secs * GameLoop.UPS;
	}

}
