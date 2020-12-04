/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.event.KeyEvent;

public class PlayerTwoController implements Controller {

	private Input input;
	
	public PlayerTwoController(Input input) {
		this.input = input;
	}
	
	@Override
	public boolean isRequestingUp() {
		if (input.keyPressed(KeyEvent.VK_UP)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingDown() {
		if (input.keyPressed(KeyEvent.VK_DOWN)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingLeft() {
		if ( input.keyPressed(KeyEvent.VK_LEFT)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingRight() {
		if (input.keyPressed(KeyEvent.VK_RIGHT)) {
			return true;
		} else return false;
	}
	
	

}
