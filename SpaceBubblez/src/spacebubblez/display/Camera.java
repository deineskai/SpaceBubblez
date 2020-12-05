/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.util.Optional;

import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.entity.GameObject;
import spacebubblez.states.State;

public class Camera {
	
	private Position pos;
	private Size size;
	
	private Optional<GameObject> focusedObject;
	
	
	public Camera(Size size) {
		this.pos = new Position(0, 0);
		this.size = size;
	}
	
	public void focusOn(GameObject object) {
		this.focusedObject = Optional.of(object);
	}
	
	public void update(State state, Display display) {
		if (focusedObject.isPresent()) {
			Position objectPosition = focusedObject.get().getPos();
			
			this.pos.setX(objectPosition.getIntX() - display.getWidth()/2);
			this.pos.setY(objectPosition.getIntY() - display.getHeight()/2);
			limitBounds(state, display);
		}
	}
	
	private void limitBounds(State state, Display display) {
		if (pos.getIntX() < 0) {
			pos.setX(0);
		}
		if (pos.getIntY() < 0) {
			pos.setY(0);
		}
		
		if (pos.getX() > state.getGameMap().getWidth() - display.getCanvas().getWidth()) {
			pos.setX(state.getGameMap().getWidth() - display.getCanvas().getWidth());
		}
		if (pos.getY() > state.getGameMap().getHeight() - display.getCanvas().getHeight()) {
			pos.setY(state.getGameMap().getHeight() - display.getCanvas().getHeight());
		}
		
	}
	
	public Position getPos() {
		return pos;
	}
	
}
