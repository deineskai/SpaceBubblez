/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai;

import spacebubblez.ai.state.AIAttackState;
import spacebubblez.ai.state.AIState;
import spacebubblez.ai.state.AIIdleState;
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
		case "attack":
			currentAIState = new AIAttackState();
			return;
		case "idle":
		default:
			currentAIState = new AIIdleState();
		}
	} 

}
