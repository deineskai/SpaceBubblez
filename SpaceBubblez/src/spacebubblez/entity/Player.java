/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.entity;

import java.awt.Color;

import spacebubblez.controller.Controller;
import spacebubblez.core.Position;
import spacebubblez.core.Size;

public class Player extends Entity {
	
	public Player(Position pos, double mass, double size, double speed, double slowdown, String name, Color color, Controller controller) {
		super(pos, mass, size, speed, slowdown, name, color, controller);
	}

}
