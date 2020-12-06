/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai.state;

import spacebubblez.ai.AITransition;
import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public abstract class AIState {
	
	private AITransition transition;
	
	public AIState() {
		this.transition = initializeTransiton();
	}

	protected abstract AITransition initializeTransiton();
	
	public abstract void update(State state, Enemie enemie);

	public boolean shouldTransition(State state, Enemie currentEnemie) {
		return transition.shouldTransition(state, currentEnemie);
	}
	
	public String getNextState() {
		return transition.getNextState();
	}
	
	public AITransition getAITransition() {
		return transition;
	}
	
}
