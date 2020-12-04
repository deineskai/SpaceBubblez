/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;

public class Player extends Entity {
	
	private Controller controller;
	

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
				color);
		this.controller = controller;
	}
	
	public void update() {
		move();
		adjustPos();
	}
	
	private void move() {
		double deltaX = 0, deltaY = 0;
		if (
				controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaY -= speed / (1 + mass / 100 * slowdown);
		} else if (
				controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= speed / (1 + mass / 100 * slowdown);
		} else if (
				!controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaY += speed / (1 + mass / 100 * slowdown);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += speed / (1 + mass / 100 * slowdown);
		} else if (
				controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		}
		
		this.posX += deltaX;
		this.posY += deltaY;
	}

}
