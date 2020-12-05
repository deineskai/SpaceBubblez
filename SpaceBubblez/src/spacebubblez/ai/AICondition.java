/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.ai;

import spacebubblez.entity.Enemie;
import spacebubblez.state.State;

public interface AICondition {
	
	boolean isIdling(State state, Enemie currentEnemie);

}
