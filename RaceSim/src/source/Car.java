package source;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Car{
	
	final static int EAST = 0;
	final static int NORTH = 1;
	final static int WEST = 2;
	final static int SOUTH = 3;

	private BufferedImage face;
	private int direction = EAST;
	private int[] position = {0,0}; //Car's current position.
	private double speed = 1; //Car's speed.
	private int topBound;
	private int rightBound;
	private int leftBound;
	private int botBound;
	
	public Car(String newFace, int x, int y){
		setFace(newFace);
		position[0] = x;
		position[1] = y;
		setBounds();
	}

	/**
	 * 
	 */
	private void setBounds() {
		leftBound = position[0];
		rightBound = position[0] + face.getWidth();
		topBound = position[1];
		botBound = position[1] + face.getHeight();
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
		if(direction == EAST){
			position[0] += speed;
		}
		else if(direction == WEST){
			position[0] -= speed;
		}
		else if(direction == NORTH){
			position[1] -= speed;
		}
		else {
			position[1] += speed;
		}
		setBounds();
	}

	public int getPosX(){
		return position[0];
	}
	
	public int getPosY(){
		return position[1];
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