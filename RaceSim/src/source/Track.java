package source;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Track extends JPanel implements Runnable{
	//Track will be a box of coordinates that will contain
	//the points where a car can move to.

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String location;
	private BufferedImage image;
	private ArrayList<Driver> drivers;

	public Track(String trackLocation){
		try {
			image = ImageIO.read(new File(trackLocation));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		drivers = new ArrayList<Driver>();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	public int getHeight(){
		return image.getHeight();
	}

	public int getWidth(){
		return image.getWidth();
	}
	
	public void addDriver(Driver newDriver){
		drivers.add(newDriver);	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		for(Driver drv: drivers){
			add(drv.getCar(), 0, i*50);
			i++;
			drv.getCar().setVisible(true);
//			drv.drive();
		}
		setVisible(true);
	}

}