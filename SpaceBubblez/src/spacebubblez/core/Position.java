/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.core;

public class Position {
	
	private double x, y;
	public static double PROXIMITY_RANGE = 5;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Position getPos() {
		return this;
	}	
	
	public int getIntX() {
		return (int) getX();
	}
	
	public int getIntY() {
		return (int) y;
	}

	public boolean isNearby(Position posTarget) {
		//return getDistance(posTarget) <= movingDist;
		//return Math.abs(x - posTarget.getX()) < movingDist && Math.abs(y - posTarget.getY()) < movingDist;
		return Math.abs(x - posTarget.getX()) < Position.PROXIMITY_RANGE &&  Math.abs(y - posTarget.getY()) < Position.PROXIMITY_RANGE;
	}
	
	public double getDistance(Position pos) {
		return Math.sqrt(Math.pow(pos.getX() - x, 2) + Math.pow(pos.getY() - y, 2));
	}


	

}
