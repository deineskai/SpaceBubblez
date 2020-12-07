/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import spacebubblez.Config;
import spacebubblez.entity.Entity;
import spacebubblez.map.Tile;
import spacebubblez.state.State;


public class Renderer {
	
	public void render(State state, Graphics2D g2d) {
		renderMap(state, g2d);
		Camera camera = state.getCamera();
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		state.getGameObjects().stream()
			.filter(gameObject -> camera.isInView(gameObject))
			.forEach(Entitiy -> g2d.drawImage(
				Entitiy.getSprite(),
				Entitiy.getPos().getIntX() - Entity.getImageSize() / 2 - camera.getPos().getIntX(),
				Entitiy.getPos().getIntY() - Entity.getImageSize() / 2 - camera.getPos().getIntY(),
				null));
	}

	private void renderMap(State state, Graphics2D g2d) {
		Tile[][] tiles = state.getGameMap().getTiles();
		Camera camera = state.getCamera();
		for (int rows = 0; rows < tiles.length; rows++) {
			for (int cols = 0; cols < tiles[0].length; cols++) {
				g2d.drawImage(
						tiles[rows][cols].getSprite(),
						rows * Config.SPRITE_SIZE - camera.getPos().getIntX(),
						cols * Config.SPRITE_SIZE - camera.getPos().getIntY(),
						null);
			}
		}
 	}
}
