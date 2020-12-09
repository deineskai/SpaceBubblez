/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez;

import spacebubblez.core.Size;

public interface Config {
	
	boolean 
	multiplayer=true,
	friendlyFire = false,
	
	gridVisible = true,
	entityIsTransparent = true,
	outlineVisible = true,
	glowVisible = true,
	
	fullscreen= false,
	windowed = true;
	
	
	int 
	entityTransparency = 216,
	SPRITE_SIZE = 64,
	TILE_SPACING = 4,
	AI_RANGE = 20,
	SHOOTING_MASS = 10,
	MIN_SHOOTING_THRESHOLD = 50,
	ENTITY_SPEED = 8,
	ENTITY_SIZE = 10;
	
	double
	ENTITY_SLOWDOWN = 0.15;
	
	Size MAP_SIZE = new Size(180, 96); //tiles
	
	
	
	
	
	
	
	
	
	
	
	//debug
	boolean
	entityAxesVisible=false;

}
