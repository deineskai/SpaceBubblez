/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import spacebubblez.entity.Entity;
import spacebubblez.game.Game;

public class Renderer {
	
	public void render(Game game, Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		game.getGameObjects().forEach(Entitiy -> g2d.drawImage(
				Entitiy.getSprite(),
				(int) (Entitiy.getPosX() - Entity.getImageSize() / 2),
				(int) (Entitiy.getPosY() - Entity.getImageSize() / 2),
				null));
	}

}
