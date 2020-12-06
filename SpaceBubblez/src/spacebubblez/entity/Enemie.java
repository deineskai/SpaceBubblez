/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.entity;

import java.awt.Color;

import spacebubblez.ai.AIManager;
import spacebubblez.controller.Controller;
import spacebubblez.core.Position;
import spacebubblez.state.State;

public class Enemie extends Entity {
	
	private AIManager aiManager;
	private Controller controller;

	public Enemie(Position pos, double mass, double size, double speed, double slowdown, String name, Color color,
			Controller controller) {
		super(pos, mass, size, speed, slowdown, name, color, controller);
		aiManager = new AIManager();
		this.controller = controller;
	}
	
	public void update(State state) {
		super.update(state);
		aiManager.update(state, this);
	}
	
	public AIManager getAIManager() {
		return aiManager;
	}

}
