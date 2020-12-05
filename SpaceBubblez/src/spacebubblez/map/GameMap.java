/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.map;

import java.util.Arrays;

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
}
