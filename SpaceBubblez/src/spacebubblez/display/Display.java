/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import spacebubblez.input.Input;
import spacebubblez.state.State;
 

public class Display extends JFrame {
	
	//init
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private Renderer renderer;
	private boolean drawGrid;
	
	
	//constructor
	public Display(int width, int height, boolean fullscreen, boolean windowed, boolean drawGrid, Input input) {
		this.setTitle("SpaceBubblez!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(width, height));
		this.setLocationRelativeTo(null);
		this.drawGrid = drawGrid;
		this.renderer = new Renderer();
		
		if (fullscreen) { this.setExtendedState(MAXIMIZED_BOTH); } else { this.setSize(new Dimension(width, height)); }
		if (windowed) { this.setUndecorated(false); } else { this.setUndecorated(true); }
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		canvas.setFocusable(false);
		canvas.setBackground(Color.white);
		
		this.add(canvas);
		this.addKeyListener(input);
		this.pack();
		
		canvas.createBufferStrategy(3); //rendering next image earlier to prevent flickering
		
		this.setVisible(true);
	}
	
	
	//methods
	public void render(State state, int fps) {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		drawBackground(g2d); //basic background
		renderer.render(state, g2d); //draw content
		drawStats(g2d, fps);
		
		
		//printFonts();
		g2d.dispose();
		bufferStrategy.show();
	}
	
	private void drawBackground(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.darkGray);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		GradientPaint grad = new GradientPaint(0, 0, new Color(22, 55, 55), 0, canvas.getHeight(), new Color(27, 22, 11));
		g2d.setPaint(grad);
		g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		//draw inner boxes
		if (this.drawGrid) {
			g2d.setColor(new Color(17,21,11));
			int size=60, spacing=3;
			for (int i = -size/2; i < this.getHeight(); i+=size) {
				for (int j = -size/2; j < this.getWidth(); j+=size) {
				g2d.fillRoundRect(j+spacing/2, i+spacing/2, size-spacing, size-spacing, 8, 8);
				}
			}
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	
	private void drawStats(Graphics2D g2d, int fps) {
		g2d.setFont(new Font("Consolas", 0, 15));
		g2d.setColor(Color.white);
		g2d.drawString(fps + " fps", 5, 20);
	}
	
	private void printFonts() {
		//print available fonts
		GraphicsEnvironment ge;  
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
	    String[] names = ge.getAvailableFontFamilyNames();
	    Font[] allFonts = ge.getAllFonts();
	    for(int x=0; x<names.length; x++)
	        System.out.println(names[x]);

	    for(int x=0; x<allFonts.length; x++){           
	        System.out.println(allFonts[x].getName());
	        System.out.println(allFonts[x].getFontName());
	        System.out.println(allFonts[x].getFamily());
	        System.out.println(allFonts[x].getPSName());
	    }
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

}
