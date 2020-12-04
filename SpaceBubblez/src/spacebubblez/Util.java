/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;

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

}
