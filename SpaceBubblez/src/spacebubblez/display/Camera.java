/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.awt.Rectangle;
import java.util.Optional;

import spacebubblez.Config;
import spacebubblez.core.Position;
import spacebubblez.core.Size;
import spacebubblez.entity.GameObject;
import spacebubblez.state.State;

public class Camera {
	
	private Position pos;
	private Size size;
	private Rectangle viewBounds;
	
	private Optional<GameObject> focusedObject;
	
	
	public Camera(Size size) {
		this.pos = new Position(0, 0);
		this.size = size;
	}
	
	private void calculateViewBounds(Display display) {
		viewBounds = new Rectangle(pos.getIntX(), pos.getIntY(), display.getWidth(), display.getHeight());
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
			calculateViewBounds(display);
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
	
	public Size getSize() {
		return size;
	}

	public boolean isInView(GameObject gameObject) {
		return viewBounds.intersects(
				gameObject.getPos().getX()-gameObject.getRadius(), 
				gameObject.getPos().getY()-gameObject.getRadius(), 
				gameObject.getRadius()*2, 
				gameObject.getRadius()*2);
	}
	
}
