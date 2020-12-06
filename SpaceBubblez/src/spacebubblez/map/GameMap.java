/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.map;

import java.util.Arrays;

import spacebubblez.Config;
import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.gfx.SpriteLibrary;

public class GameMap {
	
	private Tile[][] tiles;
	
	public GameMap(Size size, SpriteLibrary spriteLibrary) {
		tiles = new Tile[size.getWidth()][size.getHeight()];
		initializeTiles(spriteLibrary);
	}

	private void initializeTiles(SpriteLibrary spriteLibrary) {
		for (Tile[] row : tiles) {
			Arrays.fill(row, new Tile(spriteLibrary));
		}
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public int getWidth() {
		return (tiles.length) * Config.SPRITE_SIZE;
	}
	
	public int getHeight() {
		return tiles[0].length * Config.SPRITE_SIZE;
	}
	
	public Position getRandomPos() {
		double x = Math.random() * tiles.length * Config.SPRITE_SIZE;
		double y = Math.random() * tiles[0].length * Config.SPRITE_SIZE;
		
		return new Position(x, y);
	}
	
	
}
