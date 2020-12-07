/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.controller;

public class FoodController implements Controller {

	@Override
	public boolean isRequestingUp() {
		return false;
	}

	@Override
	public boolean isRequestingDown() {
		return false;
	}

	@Override
	public boolean isRequestingLeft() {
		return false;
	}

	@Override
	public boolean isRequestingRight() {
		return false;
	}

}
