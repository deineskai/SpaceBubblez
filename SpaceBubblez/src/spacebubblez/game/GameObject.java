/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;
import java.awt.Image;

public abstract class GameObject {
	
	//init
	protected double posX, posY, mass, size;
	protected String name;
	protected Color color;
	
	
	//constructor
	public GameObject(double posX, double posY, double mass, double size, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.mass = mass;
		this.size = size;
		this.color = color;
	}
	
	
	//methods
	public abstract void update();
	
	public abstract Image getSprite();
	
	
	//getters & setters
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
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
