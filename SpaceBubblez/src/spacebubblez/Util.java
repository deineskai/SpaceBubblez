/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez;

import java.awt.Color;

import spacebubblez.entity.GameObject;

public class Util {
	
	//methods
	public static Color getContrastingBlackWhite(Color color) {
		  double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
		  return y >= 128 ? Color.black : Color.white;
	}
	
	public static Color getColorShade(Color color, float brightness) {
		float[] hsb = {0, 0, 0};
		hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
		hsb[2] = hsb[2] * brightness;
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
	
	public static Color getRandomEnemieColor() {
		int seed = (int) (Math.random() * 5);
		switch (seed) {
		case 4:
			return Color.cyan;
		case 3:
			return Color.yellow;
		case 2:
			return Color.orange;
		case 1:
			return Color.pink;
		default:
			return Color.red;
		}
	}
	
	public static Color getRandomFoodColor() {
		float[] hsb = new float[3];
		hsb[0] = (float) (0 + Math.random());
		hsb[1] = 1;
		hsb[2] = (float) (0.5 + Math.random()*0.5);
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
	
	public static boolean bInsideA(GameObject a, GameObject b) {
		if (getDistance(a.getPos().getX(), a.getPos().getY(), b.getPos().getX(), b.getPos().getY()) + getRadius(b.getMass(), b.getSize()) <= getRadius(a.getMass(), a.getSize())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double getDistance(double posX1, double posY1, double posX2, double posY2) {
		return Math.sqrt(Math.pow(posX2-posX1, 2) + Math.pow(posY2-posY1, 2));
	}

	public static double getRadius(double A, double size) {
		return Math.sqrt(A/Math.PI)*size;
	}
}
