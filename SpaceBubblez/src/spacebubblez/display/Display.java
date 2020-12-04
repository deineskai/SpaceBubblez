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
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import spacebubblez.entity.Entity;
import spacebubblez.game.Game;
import spacebubblez.input.Input;

public class Display extends JFrame {
	
	//init
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	
	//constructor
	public Display(int width, int height, boolean fullscreen, boolean windowed, Input input) {
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
		this.addKeyListener(input);
		this.pack();
		
		canvas.createBufferStrategy(3); //rendering next image earlier to prevent flickering
		
		this.setVisible(true);
	}
	
	
	//methods
	public void render(Game game, int fps) {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
			
		//bg
		GradientPaint gra = new GradientPaint(0, 0, new Color(22, 55, 66), 0, canvas.getHeight(), new Color(0, 0, 11));
		g2d.setPaint(gra);
		//g2d.setColor(Color.black);
		g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		//content
		game.getGameObjects().forEach(Entitiy -> g2d.drawImage(
				Entitiy.getSprite(),
				(int) (Entitiy.getPosX() - Entity.getImageSize() / 2),
				(int) (Entitiy.getPosY() - Entity.getImageSize() / 2),
				null));
		
		
		//draw stats
		g2d.setFont(new Font("Consolas", 0, 15));
		g2d.setColor(Color.white);
		g2d.drawString(fps + " fps", 5, 20);
		
		
		/*//print available fonts
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
	    } */
		
		
		g2d.dispose();
		bufferStrategy.show();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

}
