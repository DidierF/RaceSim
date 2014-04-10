package source;


class Driver extends Thread{

	private Car car;

	//TODO: Rotate car in corners.
	
	public Driver(Car newCar){
		car = newCar;
	}

	public Car getCar(){
		return car;
	}

	public void run(){
		car.changeDirection(Car.EAST);
		int i = 0;
		while(true){
			if(i == 200){
				turnLeft();
				i = 0;
			}
			i++;
			car.moveForward();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void turnLeft(){
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