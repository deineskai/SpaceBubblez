/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.controller;

import java.awt.event.KeyEvent;

import spacebubblez.input.Input;

public class PlayerOneController implements Controller {

	private Input input;
	
	public PlayerOneController(Input input) {
		this.input = input;
	}
	
	@Override
	public boolean isRequestingUp() {
		if (input.keyPressed(KeyEvent.VK_W)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingDown() {
		if (input.keyPressed(KeyEvent.VK_S)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingLeft() {
		if (input.keyPressed(KeyEvent.VK_A)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingRight() {
		if (input.keyPressed(KeyEvent.VK_D)) {
			return true;
		} else return false;
	}

	@Override
	public boolean isRequestingShoot() {
		if (input.keyPressed(KeyEvent.VK_SPACE)) {
			return true;
		} else return false;
	}
	
	

}
