package source;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.String;

import javax.imageio.ImageIO;

class Car{
	
	final static int EAST = 0;
	final static int NORTH = 1;
	final static int WEST = 2;
	final static int SOUTH = 3;

	private BufferedImage face;
	private int direction = WEST;
	private Point position = new Point(); //Car's current position.
	private double speed = 1; //Car's speed.
	public String tempFace;
	
	/** Minimum and maximum x and y coordinates of the car*/
	private int topBound;
	private int rightBound;
	private int leftBound;
	private int botBound;
	
	public Car(String newFace, Point p){
		tempFace = newFace;
		setFace(newFace);
		position = p;
		setBounds();
	}

	/**
	 * 
	 */
	private void setBounds() {
		leftBound = position.x;
		rightBound = position.x + face.getWidth();
		topBound = position.y;
		botBound = position.y + face.getHeight();
	}

	public double getSpeed(){
		return speed;
	}

	public int getDirection(){
		return direction;
	}

	public BufferedImage getFace(){
		return face;
	}

	private void setFace(String faceLocation){
		try {
			face = ImageIO.read(new File(faceLocation));
		}
		catch (IOException e){
			e.printStackTrace();
		} 
	}

	/* Changes the direction the car is facing*/
	public void changeDirection(int x){
		if(x == NORTH || x == SOUTH || x == EAST || x == WEST){
			direction = x;
		}
	}

	/* Moves the car in the direction it is facing speed/100 pixels.*/
	public void moveForward(){
		String mdTempFace;
		
		if(direction == EAST){
			position.x += speed;
			try {
				face = ImageIO.read(new File(tempFace));
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		else if(direction == WEST){
			position.x -= speed;
			mdTempFace = tempFace.substring(0,26) + "_westFace.gif";
			
			try {
				face = ImageIO.read(new File(mdTempFace));
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		else if(direction == NORTH){
			position.y -= speed;
			mdTempFace = tempFace.substring(0,26) + "_northFace.gif";
			
			try {
				face = ImageIO.read(new File(mdTempFace));
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		else {
			position.y += speed;
			mdTempFace = tempFace.substring(0,26) + "_southFace.gif";
			
			try {
				face = ImageIO.read(new File(mdTempFace));
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		setBounds();
	}

	public int getPosX(){
		return position.x;
	}
	
	public int getPosY(){
		return position.y;
	}
	
	public int getTopBound(){
		return topBound;
	}
	
	public int getBotBound(){
		return botBound;
	}
	
	public int getLeftBound(){
		return leftBound;
	}
	
	public int getRightBound(){
		return rightBound;
	}
}