/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public Display(int width, int height, boolean fullscreen, boolean windowed) {
		this.setTitle("SpaceBubblez!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(width, height));
		this.setLocationRelativeTo(null);
		
		if (fullscreen) { this.setExtendedState(MAXIMIZED_BOTH); } else { this.setSize(new Dimension(width, height)); }
		if (windowed) { this.setUndecorated(false); } else { this.setUndecorated(true); }
		
		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		canvas.setFocusable(false);
		
		canvas.setBackground(Color.white);
		
		this.add(canvas);
		this.pack();
		
		canvas.createBufferStrategy(3);
		
		
		
		this.setVisible(true);
	}
	
	public void render(Game game) {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		//bg
		GradientPaint blackToWhite = new GradientPaint(0, 0, Color.white, canvas.getWidth(), canvas.getHeight(), Color.black);
		g2d.setPaint(blackToWhite);
		g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		//content
		Rectangle rectangle = game.getRectangle();
		g2d.setColor(Color.blue);
		g2d.fillRect(
				(int) rectangle.getX(),
				(int) rectangle.getY(),
				(int) rectangle.getWidth(),
				(int) rectangle.getHeight());
		
		g2d.dispose();
		bufferStrategy.show();
	}

}
