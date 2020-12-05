/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import spacebubblez.Config;

public class SpriteLibrary {
	
	private static Map<String, Image> tiles;
	
	public SpriteLibrary() {
		tiles = new HashMap<>();
		loadSprites();
	}

	private void loadSprites() {
		loadTiles();
		
	}

	private void loadTiles() {
		BufferedImage image = new BufferedImage(Config.SPRITE_SIZE, Config.SPRITE_SIZE, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		
		g2d.setColor(new Color(0,0,0,31));
		g2d.fillRect(Config.TILE_SPACING/2, Config.TILE_SPACING/2, Config.SPRITE_SIZE-Config.TILE_SPACING, Config.SPRITE_SIZE-Config.TILE_SPACING);
		
		g2d.dispose();
		tiles.put("default", image);
		
	}
	
	public static Image getTile(String name) {
		return tiles.get(name);
	}

}
