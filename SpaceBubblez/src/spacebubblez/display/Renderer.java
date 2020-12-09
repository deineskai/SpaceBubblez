/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import spacebubblez.Config;
import spacebubblez.core.Position;
import spacebubblez.entity.Entity;
import spacebubblez.map.GameMap;
import spacebubblez.state.State;


public class Renderer {
	
	public void render(State state, Graphics2D g2d) {
		if (Config.gridVisible) {
			renderMap(state, g2d);
		}
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
		GameMap map = state.getGameMap();
		Camera camera = state.getCamera();
		
		Position start = map.getViewableStartingGridPos(camera);
		Position end = map.getViewableEndingGridPos(camera);
		
		for (int rows = start.getIntX(); rows < end.getIntX(); rows++) {
			for (int cols = start.getIntY(); cols < end.getIntY(); cols++) {
				g2d.drawImage(
						map.getTiles()[rows][cols].getSprite(),
						rows * Config.SPRITE_SIZE - camera.getPos().getIntX(),
						cols * Config.SPRITE_SIZE - camera.getPos().getIntY(),
						null);
			}
		}
 	}
}
