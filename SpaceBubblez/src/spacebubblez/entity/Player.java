/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.entity;

import java.awt.Color;

import spacebubblez.controller.Controller;

public class Player extends Entity {
	
	public Player(
			double posX, 
			double posY, 
			double mass, 
			double size, 
			double speed,
			double slowdown, 
			String name,
			Color color, 
			Controller controller) {
		super(
				posX, 
				posY, 
				mass, 
				size, 
				speed, 
				slowdown, 
				name, 
				color, 
				controller);
	}
	
	public void update() {
		super.update();
	}

}
