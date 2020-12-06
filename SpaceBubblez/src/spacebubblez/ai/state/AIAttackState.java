/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai.state;

import java.util.ArrayList;
import java.util.List;

import spacebubblez.ai.AITransition;
import spacebubblez.controller.EnemieController;
import spacebubblez.core.Position;
import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public class AIAttackState extends AIState {
	private List<Position> targets;
	
	public AIAttackState() {
		super();
		targets = new ArrayList<>();
	}

	@Override
	protected AITransition initializeTransiton() {
		return new AITransition("idle", ((state, currentEnemie) -> targetReached(currentEnemie)));
	}

	@Override
	public void update(State state, Enemie currentEnemie) {
		
		if (targets.isEmpty()) {
			targets.add(state.getRandomPos());
		}
		
		EnemieController controller = (EnemieController) currentEnemie.getController();
		controller.moveToTarget(targets.get(0), currentEnemie.getPos());
		
		if (targetReached(currentEnemie)) {
			controller.stop();
		}
		
		
	}

	private boolean targetReached(Enemie currentEnemie) {
		//return currentEnemie.getPos().isNearby(targets.get(0).getPos(), currentEnemie.getSpeed() / (1 + currentEnemie.getMass() / 100 * currentEnemie.getSlowdown()));
		return currentEnemie.getPos().isNearby(targets.get(0));
	}
	
	
}
