/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.controller;

import spacebubblez.core.Position;

public class EnemieController implements Controller {
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	@Override
	public boolean isRequestingUp() {
		// TODO Auto-generated method stub
		return up;
	}

	@Override
	public boolean isRequestingDown() {
		// TODO Auto-generated method stub
		return down;
	}

	@Override
	public boolean isRequestingLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public boolean isRequestingRight() {
		// TODO Auto-generated method stub
		return right;
	}

	public void moveToTarget(Position target, Position current) {
        double deltaX = target.getX() - current.getX();
        double deltaY = target.getY() - current.getY();

        up = deltaY < 0 && Math.abs(deltaY) > Position.PROXIMITY_RANGE;
        right = deltaX > 0 && Math.abs(deltaX) > Position.PROXIMITY_RANGE;
        down = deltaY > 0 && Math.abs(deltaY) > Position.PROXIMITY_RANGE;
        left = deltaX < 0 && Math.abs(deltaX) > Position.PROXIMITY_RANGE;
    }

	public void stop() {
		up = false;
		left = false;
		down = false;
		right = false;
	}

}
