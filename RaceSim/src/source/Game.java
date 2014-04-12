package source;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy strategy;
	private boolean gameRunning = true;
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private Track track = new Track("src/source/Pictures/PistaRectangular_4.jpg", new Dimension(670, 550), new Dimension(460, 390));
	
	public Game(){
		JFrame container = new JFrame();
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(track.getWidth(), track.getHeight()));
		panel.setLayout(null);
		
		setBounds(0,0,track.getWidth(),track.getHeight());
		panel.add(this);
		
		setIgnoreRepaint(true);
		
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}
	
	private void setupGame(){
		String carLoc = "src/source/Pictures/carro2.gif";
		Driver drv = new Driver(new Car(carLoc, new Point()), track);
		int carNum = 10;
		track.setStartingPos(carNum, new Dimension(drv.getCar().getFace().getWidth(), drv.getCar().getFace().getHeight()), 400);
		for(int i = 1; i <= carNum; i++){
			carLoc = "src/source/Pictures/carro" + i + ".gif";
			drv = new Driver(new Car(carLoc, track.getStartingPos(i-1)), track);
			drivers.add(drv);
		}
	}
	
	public void gameLoop(){
		while(gameRunning){
			
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			
			g.drawImage(track.getTrack(), null, 0, 0);
			
			for(Driver drv: drivers){
				g.drawImage(drv.getCar().getFace(), null, drv.getCar().getPosX(), drv.getCar().getPosY());
			}
			
			g.dispose();
			strategy.show();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		for(Driver drv: drivers){
			drv.start();
		}
		gameLoop();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.setupGame();
		g.run();
	}

}
