/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
	
	private boolean[] pressed;
	
	public Input() {
		pressed = new boolean[255];
	}
	
	public boolean keyPressed(int keyCode) {
		return pressed[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		pressed[ke.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		pressed[ke.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}

}
