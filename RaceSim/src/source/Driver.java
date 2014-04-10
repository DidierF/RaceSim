package source;


class Driver extends Thread{

	private Car car;
	
	private final Track TRACK;
	
	public Driver(Car newCar, Track t){
		car = newCar;
		TRACK = t;
	}

	public Car getCar(){
		return car;
	}

	public void run(){
		car.changeDirection(Car.EAST);
		while(true){
			checkForTurn();
			car.moveForward();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkForTurn() {
		int x;
		if(car.getDirection() == Car.EAST){
			x = car.getRightBound();
			if(x + 25 >= (int) TRACK.getOutBound().getMaxX() && Math.random() < 0.5){
				turnLeft();
			}
		} else if(car.getDirection() == Car.NORTH){
			x = car.getTopBound();
			if(x <= (int) TRACK.getOutBound().getMinY() + 25 && Math.random() < 0.5){
				turnLeft();
			}
		} else if(car.getDirection() == Car.WEST){
			x = car.getLeftBound();
			if(x <= (int) TRACK.getOutBound().getMinX() + 25 && Math.random() < 0.5){
				turnLeft();
			}
		} else if(car.getDirection() == Car.SOUTH){
			x = car.getBotBound();
			if(x + 25 >= (int) TRACK.getOutBound().getMaxY() && Math.random() < 0.5){
				turnLeft();
			}
		}
	}

	public void turnLeft(){
		//TODO: Rotate car's face when turning
		if(car.getDirection() == Car.SOUTH){
			car.changeDirection(Car.EAST);
		} else {
			car.changeDirection(car.getDirection()+1);
		}
	}
	
	public void turnRight(){
		if(car.getDirection() == Car.EAST){
			car.changeDirection(Car.SOUTH);
		} else {
			car.changeDirection(car.getDirection()-1);
		}
	}
}