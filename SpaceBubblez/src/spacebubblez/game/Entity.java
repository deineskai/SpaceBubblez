/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Entity extends GameObject {

	private double speed, slowdown;
	private String name;
	
	public Entity(double posX, double posY, double mass, double size, double speed, double slowdown, String name, Color color) {
		super(posX, posY, mass, size, color);
		this.speed = speed;
		this.slowdown = slowdown;
		this.name = name;
	}

	@Override
	public void update() {
		
		//this.posX += 1;
		//this.mass +=20;
	}

	@Override
	public Image getSprite() {
		int rds = (int) (Math.sqrt(this.mass / Math.PI));
		int dmtr = 2 * rds;
		double strk = 0.04;
		BufferedImage image = new BufferedImage((int) (dmtr * this.size), (int) (dmtr * this.size), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setFont(new Font("Consolas", 0, 15));
		
		g2d.setColor(Util.getColorShade(this.color, 0.87f));
		g2d.fillOval(0, 0, (int) (dmtr * this.size), (int) (dmtr * this.size));
		g2d.setColor(this.color);
		g2d.fillOval((int) (dmtr * this.size * strk/2), (int) (dmtr * this.size * strk/2), 
				(int) (dmtr * this.size * (1 - strk)), (int) (dmtr * this.size * (1 - strk)));
		
		g2d.setColor(Util.getContrastingBlackWhite(this.color));
		if (g2d.getFontMetrics().stringWidth(this.name) / 2 + 5 < rds * this.size && g2d.getFontMetrics().stringWidth("mass: " + this.mass) / 2 + 5 < rds * this.size) {
			g2d.drawString(
					this.name, 
					(int) (rds * this.size - g2d.getFontMetrics().stringWidth(this.name)/2), 
					(int) (rds * this.size - 10));
			g2d.drawString(
					"mass: " + this.mass, 
					(int) (rds * this.size - g2d.getFontMetrics().stringWidth("mass: " + this.mass)/2), 
					(int) (rds * this.size + 10));
		} else {
			for (int i = this.name.length(); i > 0; i--) {
				if (rds * this.size >= g2d.getFontMetrics().stringWidth(this.name.substring(0, i)) / 2 + 5) {
					g2d.drawString(this.name.substring(0, i), (int) (rds * this.size - g2d.getFontMetrics().stringWidth(this.name.substring(0, i)) / 2), (int) (rds * this.size + 5));
					i=0;
				}
			}
			
		}
		g2d.dispose();
		return image;
	}

}
