package source;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

class Car extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private double weight; //Total car's weight //(Lbs).
	final private int power; //Car's engine power //(HP).
	final private double powerToWeight;
	// weight and power affect how fast the car can accelerate.
	// more weight slower acc, more power faster weight.	
	final static int EAST = 0;
	final static int NORTH = 1;
	final static int WEST = 2;
	final static int SOUTH = 3;
	final static int TOP_SPEED = 360;
	final static int MAX_RPM = 5000;

	private BufferedImage face;
	private boolean deadEngine;
	private int direction = EAST;
	private int rpm;
	private int redZone;
	private double[] position = {0.0,0.0}; //Car's current position.
	//Use two set of corrdinates to represent front and
	//rear position, useful for when turning.
	//Use square to use for crash.
	private double speed; //Car's speed.
	private int gear = 1; //Car's current gear.


	public Car(String newFace, int power, double weight){
		this.power = power;
		this.weight = weight;
		powerToWeight = power/weight;
		setFace(newFace);
	}

	public double getWeight(){
		return weight;
	}

	public int getPower(){
		return power;
	}

	public double getPtW(){
		return powerToWeight;
	}

	public double getSpeed(){
		return speed;
	}

	public int getGear(){
		return gear;
	}

	public int getRPM(){
		return rpm;
	}

	public int getDirection(){
		return direction;
	}

	public boolean checkEngine(){
		return !deadEngine;
	}

	public Image getFace(){
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
			position[0] += speed/100;
		}
		else if(direction == WEST){
			position[0] -= speed/100;
		}
		else if(direction == NORTH){
			position[1] += speed/100;
		}
		else {
			position[1] -= speed/100;
		}

	}
	/* 	Ups the speed of the car depending on the gear.
		lower gear = less speed & more power/rpm.*/
	public void speedUp(){
		//TODO: use the value of WtP
		//TODO: modify rpm
		if(speed < TOP_SPEED){
			speed += (0.5*gear);
			rpm += (100/(gear));
		}
		if(rpm >= MAX_RPM){
			redZone++;
			checkRedZone();
		}
	}


	/* 	Downs the speed of the car.*/
	public void speedDown(){
		//TODO: refine this method. Simulate real car brake system.
		if(speed > 0){
			speed -= 4;
			rpm -= 100 * gear;
		}
	}

	public void gearUp(){
		if(gear <= 6){
			gear++;
			rpm = 1000;
			redZone = 0;
		}
	}

	public void gearDown(){
		if(gear > 1){
			gear--;
			rpm = 3500;
			redZone = 0;
		}
	}

	private void checkRedZone(){
		if(redZone == 100){
			deadEngine = true;
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(face, 0, 0, this);
	}
}