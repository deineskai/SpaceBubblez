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
	
	gridVisible = false,
	entityIsTransparent = true,
	outlineVisible = true,
	glowVisible = true,
	
	fullscreen= false,
	windowed = true;
	
	
	int 
	entityTransparency = 216,
	SPRITE_SIZE = 64,
	TILE_SPACING = 4,
	AI_RANGE = 20;
	
	Size MAP_SIZE = new Size(180, 96); //tiles
	
	
	
	
	
	
	
	
	
	
	
	//debug
	boolean
	entityAxesVisible=false;

}
