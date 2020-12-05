/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai;

import spacebubblez.ai.state.AIState;
import spacebubblez.ai.state.Idle;
import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public class AIManager {
	
	private AIState currentAIState;
	
	public AIManager() {
		transitionTo("idle");
	}
	
	public void update(State state, Enemie currentEnemie) {
		currentAIState.update(state, currentEnemie);
		
		if (currentAIState.shouldTransition(state, currentEnemie)) {
			transitionTo(currentAIState.getNextState());
		}
	}

	private void transitionTo(String nextState) {
		switch (nextState) {
		case "idle":
			
			
		default:
			currentAIState = new Idle();
		}
	}

}
