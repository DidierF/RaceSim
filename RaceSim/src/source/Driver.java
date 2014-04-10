package source;


class Driver extends Thread{

	private Car car;

	public Driver(Car newCar){
		car = newCar;
	}

	public Car getCar(){
		return car;
	}

	public void run(){
		car.changeDirection(Car.EAST);
		while(true){
			car.moveForward();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

//	private void accelerate(){
//		car.speedUp();
//	}

//	private void brake(){
//		car.speedDown();
//	}
}