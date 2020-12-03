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
		
		canvas.setBackground(Color.black);
		
		this.add(canvas);
		this.pack();
		
		canvas.createBufferStrategy(3);
		
		this.setVisible(true);
	}
	
	public void render(Game game) {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(this.getWidth()/4, canvas.getHeight()/4, canvas.getWidth()/2, canvas.getHeight()/2);
		g2d.setColor(Color.red);
		g2d.drawRect(this.getWidth()/4, canvas.getHeight()/4, canvas.getWidth()/2, canvas.getHeight()/2);
		
		g2d.dispose();
		bufferStrategy.show();
	}

}
