/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.entity;

import java.awt.Color;
import java.awt.Image;

import spacebubblez.core.Position;
import spacebubblez.state.State;

public abstract class GameObject {
	
	//init
	protected Position pos;
	protected double mass, size;
	protected String name;
	protected Color color;
	
	
	//constructor
	public GameObject(Position pos, double mass, double size, Color color) {
		this.pos = pos;
		this.mass = mass;
		this.size = size;
		this.color = color;
	}
	
	
	//methods
	public abstract void update(State state);
	
	public abstract Image getSprite();
	
	
	//getters & setters
	public Position getPos() {
		return pos;
	}

	public void setPosX(Position pos) {
		this.pos = pos;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getSize() {
		return size;
	}

}
