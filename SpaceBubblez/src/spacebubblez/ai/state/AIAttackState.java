/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai.state;

import java.util.ArrayList;
import java.util.List;

import spacebubblez.Util;
import spacebubblez.ai.AITransition;
import spacebubblez.controller.EnemieController;
import spacebubblez.core.Position;
import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public class AIAttackState extends AIState {
	private List<Position> targets;
	private int age;
	
	public AIAttackState() {
		super();
		targets = new ArrayList<>();
		age = 0;
	}

	@Override
	protected AITransition initializeTransiton() {
		return new AITransition("idle", ((state, currentEnemie) -> targetReached(currentEnemie)));
	}

	@Override
	public void update(State state, Enemie currentEnemie) {
		age++;
		
		if (targets.isEmpty()) {
			state.getGameObjects().stream().filter(
					gameObject -> currentEnemie.getPos().getDistance(gameObject.getPos()) < 500
					&& gameObject.getMass() < currentEnemie.getMass())
					.forEach(player -> targets.add(player.getPos()));
			if (targets.isEmpty()) {
				targets.add(state.getGameMap().getRandomPos()); //if no actual victim is in range
			}
			
		}
		
		EnemieController controller = (EnemieController) currentEnemie.getController();
		controller.moveToTarget(targets.get(0), currentEnemie.getPos());
		
		if (targetReached(currentEnemie)) {
			controller.stop();
		}
		
		
	}

	private boolean targetReached(Enemie currentEnemie) {
		//return currentEnemie.getPos().isNearby(targets.get(0).getPos(), currentEnemie.getSpeed() / (1 + currentEnemie.getMass() / 100 * currentEnemie.getSlowdown()));
		
		if (currentEnemie.getPos().isNearby(targets.get(0)) || age >= 360) {
			return true;
		} else return false;
	}
	
	
}
