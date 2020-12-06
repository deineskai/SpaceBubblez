/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai.state;

import spacebubblez.ai.AITransition;
import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public class AIIdleState extends AIState {
	
	private int age;

	@Override
	protected AITransition initializeTransiton() {
		return new AITransition("attack", ((state, currentEnemie) -> age >= state.getTimer().getUpdatesFromSeconds(1)));
	}

	@Override
	public void update(State state, Enemie currentEnemie) {
		age++;
	}

}
