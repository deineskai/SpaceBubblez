/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai;

import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public class AITransition {
	
	private String nextState;
	private AICondition condition;
	
	public AITransition(String nextState, AICondition condition) {
		this.nextState = nextState;
		this.condition = condition;
	}
	
	public boolean shouldTransition(State state, Enemie currentEnemie) {
		return condition.isIdling(state, currentEnemie);
	}
	
	public String getNextState() {
		return nextState;
	}

}
