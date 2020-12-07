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
import spacebubblez.display.Camera;
import spacebubblez.gfx.SpriteLibrary;

public class GameMap {
	
	private Tile[][] tiles;
	
	private static final int spaceFiller = 2;
	
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

	public Position getViewableStartingGridPos(Camera camera) {
		return new Position(
				camera.getPos().getX() / Config.SPRITE_SIZE, 
				camera.getPos().getY() / Config.SPRITE_SIZE);
	}

	public Position getViewableEndingGridPos(Camera camera) {
		return new Position(
				Math.min(tiles.length, camera.getPos().getX() / Config.SPRITE_SIZE + camera.getCurrentViewSize().getWidth() / Config.SPRITE_SIZE + spaceFiller), 
				Math.min(tiles[0].length, camera.getPos().getY() / Config.SPRITE_SIZE + camera.getCurrentViewSize().getHeight() / Config.SPRITE_SIZE + spaceFiller));
	}
	
	
}
