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
	
	public void update(State state) {
		if (focusedObject.isPresent()) {
			Position objectPosition = focusedObject.get().getPos();
			
			this.pos.setX(objectPosition.getX() - size.getWidth()/2);
			this.pos.setY(objectPosition.getY() - size.getHeight()/2);
		}
	}
	
	public Position getPos() {
		return pos;
	}
	
}
