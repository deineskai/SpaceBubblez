/*
##################################
## Copyright [2020] [deineskai] ##
##################################
*/
package spacebubblez.game;

public class GameLoop implements Runnable {
	
	//init
	public static final int UPS = 60;
	
	private Game game;
	
	private boolean running;
	
	private final double updateRate = 1.0d/UPS;
	
	private long nextStatTime;
	
	private int lastFPS, fps, ups;
	
	
	//constructor
	public GameLoop(Game game) {
		this.game = game;
	}

	
	//methods
	@Override
	public void run() {
		running = true;
		double accumulator = 0;
		long currentTime, lastUpdate = System.currentTimeMillis();
		nextStatTime = System.currentTimeMillis() + 1000;
		
		while (running) {
			currentTime = System.currentTimeMillis();
			double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
			accumulator += lastRenderTimeInSeconds;
			lastUpdate = currentTime;
			if (accumulator >= updateRate) {
				while (accumulator >= updateRate) {
					update();
					accumulator -= updateRate;
				}
				render();
			}
			printStats();
		}
	}

	private void printStats() {
		if (System.currentTimeMillis() > nextStatTime) {
			System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
			lastFPS = fps;
			fps = 0;
			ups = 0;
			nextStatTime = System.currentTimeMillis() + 1000;
		}
	}

	private void render() {
		game.render(lastFPS);
		fps++;
	}

	private void update() {
		game.update(game.getDisplay());
		ups++;
	}
}
