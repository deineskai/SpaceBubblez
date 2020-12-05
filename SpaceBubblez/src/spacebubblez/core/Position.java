/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.core;

public class Position {
	
	private double x, y;
	
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
	
	public Position getPosition() {
		return this;
	}	
	
	public int getIntX() {
		return (int) getX();
	}
	
	public int getIntY() {
		return (int) y;
	}


	

}
