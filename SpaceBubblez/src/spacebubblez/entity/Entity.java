/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import spacebubblez.Config;
import spacebubblez.Util;
import spacebubblez.controller.Controller;
import spacebubblez.controller.EnemieController;
import spacebubblez.core.Position;
import spacebubblez.state.State;

public class Entity extends GameObject {
	
	//init
	protected double speed, slowdown;
	private String name;
	private int edge = 50;
	private int lastDir = 0;
	private static int imageSize;
	protected Controller controller;
	private Position pos;
	
	
	//constructor
	public Entity(Position pos, double mass, double size, double speed, double slowdown, String name, Color color, Controller controller) {
		super(pos, mass, size, color);
		this.speed = speed;
		this.slowdown = slowdown;
		this.name = name;
		this.controller = controller;
		this.pos = pos;
	}
	
	
	//methods
	@Override
	public void update(State state) {
		updateLastDir();
		move();
		adjustPos(state);
		shoot(state);
		checkKills(state);
	}
	
	private void updateLastDir() {
			if (
					controller.isRequestingUp() && 
					!controller.isRequestingLeft() && 
					!controller.isRequestingDown() && 
					!controller.isRequestingRight()) {
				lastDir = 0;
			} else if (
					controller.isRequestingUp() && 
					controller.isRequestingLeft() && 
					!controller.isRequestingDown() && 
					!controller.isRequestingRight()) {
				lastDir = 1;
			} else if (
					!controller.isRequestingUp() && 
					controller.isRequestingLeft() && 
					!controller.isRequestingDown() && 
					!controller.isRequestingRight()) {
				lastDir = 2;
			} else if (
					!controller.isRequestingUp() && 
					controller.isRequestingLeft() && 
					controller.isRequestingDown() && 
					!controller.isRequestingRight()) {
				lastDir = 3;
			} else if (
					!controller.isRequestingUp() && 
					!controller.isRequestingLeft() && 
					controller.isRequestingDown() && 
					!controller.isRequestingRight()) {
				lastDir = 4;
			} else if (
					!controller.isRequestingUp() && 
					!controller.isRequestingLeft() && 
					controller.isRequestingDown() && 
					controller.isRequestingRight()) {
				lastDir = 5;
			} else if (
					!controller.isRequestingUp() && 
					!controller.isRequestingLeft() && 
					!controller.isRequestingDown() && 
					controller.isRequestingRight()) {
				lastDir = 6;
			} else if (
					controller.isRequestingUp() && 
					!controller.isRequestingLeft() && 
					!controller.isRequestingDown() && 
					controller.isRequestingRight()) {
				lastDir = 7;
			}
	}

	private void shoot(State state) {
		if (controller.isRequestingShoot() && this.mass >= Config.MIN_SHOOTING_THRESHOLD) {
			double x, y;
			if (lastDir == 0) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(90 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(90 * Math.PI / 180f);
			} else if (lastDir == 1) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(45 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(45 * Math.PI / 180f);
			} else if (lastDir == 2) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(0 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(0 * Math.PI / 180f);
			} else if (lastDir == 3) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(-45 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(-45 * Math.PI / 180f);
			} else if (lastDir == 4) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(-90 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(-90 * Math.PI / 180f);
			} else if (lastDir == 5) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(-135 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(-135 * Math.PI / 180f);
			} else if (lastDir == 6) {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(180 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(180 * Math.PI / 180f);
			} else /* dir==7 */ {
				x = pos.getX() - Util.getRadius(mass, size) * Math.cos(135 * Math.PI / 180f);
				y = pos.getY() - Util.getRadius(mass, size) * Math.sin(135 * Math.PI / 180f);
			}
			state.getGameObjects().add(new Enemie(new Position(x, y), 
					Config.SHOOTING_MASS, 
					Config.ENTITY_SIZE, 
					Config.ENTITY_SPEED, 
					Config.ENTITY_SLOWDOWN, 
					"Baby " + this.name, 
					color, 
					new EnemieController()));
			this.mass -= Config.SHOOTING_MASS;
		}
		
	}

	protected void move() {
		double deltaX = 0, deltaY = 0;
		if (
				controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaY -= speed / (1 + mass / 100 * slowdown);
		} else if (
				controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= speed / (1 + mass / 100 * slowdown);
		} else if (
				!controller.isRequestingUp() && 
				controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaX -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				!controller.isRequestingRight()) {
			deltaY += speed / (1 + mass / 100 * slowdown);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		} else if (
				!controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += speed / (1 + mass / 100 * slowdown);
		} else if (
				controller.isRequestingUp() && 
				!controller.isRequestingLeft() && 
				!controller.isRequestingDown() && 
				controller.isRequestingRight()) {
			deltaX += Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
			deltaY -= Math.sqrt(Math.pow(speed / (1 + mass / 100 * slowdown), 2)/2);
		}
		
		this.getPos().setX(this.getPos().getX() + deltaX);
		this.getPos().setY(this.getPos().getY() + deltaY);
	}
	
	protected void adjustPos(State state) {
		//left
		if (this.getPos().getIntX()+1 < Math.sqrt(this.getMass() / Math.PI) * this.getSize()) {
			this.getPos().setX(1+Math.sqrt(this.getMass() / Math.PI) * this.getSize());
		}
		//top
		if (this.getPos().getIntY()+1 < Math.sqrt(this.getMass() / Math.PI) * this.getSize()) {
			this.getPos().setY(1+Math.sqrt(this.getMass() / Math.PI) * this.getSize());
		}
		//right
		if (this.getPos().getX() > state.getGameMap().getWidth() - Math.sqrt(this.getMass() / Math.PI) * this.getSize()) {
			this.getPos().setX(state.getGameMap().getWidth() - Math.sqrt(this.getMass() / Math.PI) * this.getSize());
		}
		//bottom
		if (this.getPos().getY() > state.getGameMap().getHeight() - Math.sqrt(this.getMass() / Math.PI) * this.getSize()) {
			this.getPos().setY(state.getGameMap().getHeight() - Math.sqrt(this.getMass() / Math.PI) * this.getSize());
		}
	}

	private void checkKills(State state) {
		for (int i = 0; i < state.getGameObjects().size(); i++) {
			if (Util.bInsideA(this, state.getGameObjects().get(i)) && state.getGameObjects().get(i) != this) {
				this.mass += state.getGameObjects().get(i).getMass();
				state.getGameObjects().remove(i);
			}
		}
	}
	
	@Override
	public Image getSprite() {
		double rds = Math.sqrt(this.mass / Math.PI);
		double dmtr = 2 * rds;
		double strk = 0.04; //thickness of outline in opaque mode
		
		
		//create image with size of entity
		BufferedImage image = new BufferedImage(
				(int) (dmtr * this.size + 1 + edge*2), 
				(int) (dmtr * this.size + 1 + edge*2), 
				BufferedImage.TYPE_INT_ARGB); //ARGB for transparency
		Graphics2D g2d = image.createGraphics();
		
		imageSize = image.getWidth();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //smooth edges
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setFont(new Font("Consolas", 0, 16));
		
		
		//detect graphics settings and draw entity
		g2d.setStroke(new BasicStroke(2));
		if (Config.glowVisible) {
			drawGlow(g2d, dmtr);
		}
		if (Config.entityIsTransparent) {
			drawTransparent(g2d, rds, dmtr, strk, Config.entityTransparency);
			if (Config.outlineVisible) {
				drawOutline(g2d, dmtr);
			}
		} else drawRegular(g2d, rds, dmtr, strk);
		
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); //turn off for better text quality
		drawInfo(g2d, rds);
		
		//debug
		if (Config.entityAxesVisible) { drawAxes(g2d, image); }
		
		g2d.dispose();
		return image;
	}
	
	public Controller getController() {
		return controller;
	}
	
	
	
	
	//drawing methods
	private void drawRegular(Graphics2D g2d, double rds, double dmtr, double strk) {
		//outer circle
		g2d.setColor(Util.getColorShade(this.color, 0.7f));
		g2d.fillOval(
				edge, 
				edge, 
				(int) (dmtr * this.size), 
				(int) (dmtr * this.size)); 
		
		//inner circle
		g2d.setColor(this.color);
		g2d.fillOval(
				(int) (dmtr * this.size * strk/2) + edge, 
				(int) (dmtr * this.size * strk/2) + edge, 
				(int) (dmtr * this.size * (1 - strk)), 
				(int) (dmtr * this.size * (1 - strk))); 
		
	}
	
	private void drawTransparent(Graphics2D g2d, double rds, double dmtr, double strk, int transparency) {
		g2d.setColor(new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), 255-transparency));
		g2d.fillOval(
				edge, 
				edge, 
				(int) (dmtr * this.size), 
				(int) (dmtr * this.size));		
	}
	
	private void drawOutline(Graphics2D g2d, double dmtr) {
		//inner circle
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(this.color);
		g2d.drawOval(
				edge, 
				edge, 
				(int) (dmtr * this.size), 
				(int) (dmtr * this.size)); 
	}
	
	private void drawGlow(Graphics2D g2d, double dmtr) {
		//draw glow
		int biggestStroke = (int) (Math.sqrt(this.mass / Math.PI) * 4);
		Color[] colorArray = new Color[biggestStroke];
		for (int i = 0; i < biggestStroke; i+=3) {
			colorArray[i] = new Color(this.color.getRed(), this.color.getGreen(), this.getColor().getBlue(), 5);
		}
		for (int i = 0; i < colorArray.length-3; i+=3) {
		   	g2d.setStroke(new BasicStroke(biggestStroke - i-3));
		    g2d.setColor(colorArray[i]);
		    g2d.drawOval(
		    		edge, 
		    		edge, 
					(int) (dmtr * this.size), 
					(int) (dmtr * this.size));
		}
	}
	
	private void drawInfo(Graphics2D g2d, double rds) {
		//draw info
		if (Config.entityIsTransparent) {
			g2d.setColor(Color.white);
			if (this.color == Color.green && Config.entityTransparency < 127) {
				g2d.setColor(Color.black);
			}
		} else if (this.color == Color.blue) {
			g2d.setColor(Color.white);
		} else {
			g2d.setColor(Color.black);
		}
		if (g2d.getFontMetrics().stringWidth(this.name) / 2 + 5 < rds * this.size && g2d.getFontMetrics().stringWidth("mass: " + (int) this.mass) / 2 + 5 < rds * this.size) {
			g2d.drawString(
					this.name, 
					(int) (edge + rds * this.size - g2d.getFontMetrics().stringWidth(this.name)/2), 
					(int) (edge + rds * this.size - 5));
			g2d.drawString(
					"mass: " + (int) this.mass, 
					(int) (edge + rds * this.size - g2d.getFontMetrics().stringWidth("mass: " + (int) this.mass)/2), 
					(int) (edge + rds * (int) this.size + 15));
		} else {
			//draw as much of the name as possible
			for (int i = this.name.length(); i > 0; i--) {
				if (rds * this.size >= g2d.getFontMetrics().stringWidth(this.name.substring(0, i)) / 2 + 5) {
					g2d.drawString(
							this.name.substring(0, i), 
							(int) (edge + rds * this.size- g2d.getFontMetrics().stringWidth(this.name.substring(0, i)) / 2), 
							(int) (edge + rds * this.size + 5));
					i=0;
				}
			}
			
		}
	}
	
	private void drawAxes(Graphics2D g2d, BufferedImage image) {
		g2d.setColor(Color.red);
		g2d.drawLine(image.getWidth()/2, 0, image.getWidth()/2, image.getHeight());
		g2d.drawLine(0, image.getHeight()/2, image.getWidth(), image.getHeight()/2);
	}
	
	
	//getters & setters	
	public static int getImageSize() {
		return imageSize;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public double getMass() {
		// TODO Auto-generated method stub
		return super.getMass();
	}
	
	public double getSlowdown() {
		return slowdown;
	}

	public void multiplySpeed(double speedMultiplier) {
		this.speed *= speedMultiplier;
		
	}
	
}
