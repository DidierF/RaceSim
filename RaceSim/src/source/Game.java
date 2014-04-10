package source;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy strategy;
	private boolean gameRunning = true;
	private ArrayList entities = new ArrayList();
	private ArrayList removeList = new ArrayList();
	private BufferedImage track;
	private ArrayList<BufferedImage> cars = new ArrayList<BufferedImage>();
	private String trackLoc = "src/source/Pictures/PistaRectangular_3.jpg";
	
	
	public Game(){
		JFrame container = new JFrame();
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(null);
		
		setBounds(0,0,800,600);
		panel.add(this);
		
		setIgnoreRepaint(true);
		
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}
	
	private void setupGame(){
		String carLoc = "src/source/Pictures/carro1.gif";
		BufferedImage img = null;
		
		for(int i = 1; i <= 10; i++){
			carLoc = "src/source/Pictures/carro" + i + ".gif";
			try {
				img = ImageIO.read(new File(carLoc));
			} catch(IOException e){
				e.printStackTrace();
			}
			cars.add(img);
		}
	}
	
	public void gameLoop(){
		long lastLoopTime = System.currentTimeMillis();
		long delta;
		int[] location = {0,0};
		try {
			track = ImageIO.read(new File(trackLoc));
		} catch (IOException e){
			e.printStackTrace();
		}
		int i = 0;
		
		while(gameRunning){
			
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			
			g.drawImage(track, null, 0, 0);
			g.drawImage(cars.get(i++), null, 0, 0);

			g.dispose();
			strategy.show();
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
			if(i == 10) {
				i = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.setupGame();
		g.gameLoop();

	}

}
