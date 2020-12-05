/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.map;

import java.awt.Image;

import spacebubblez.gfx.SpriteLibrary;

public class Tile {
	
	private Image sprite;
	
	public Tile(SpriteLibrary spriteLibrary) {
		this.sprite = spriteLibrary.getTile("default");
	}
	
	public Image getSprite() {
		 return sprite;
	}

}
