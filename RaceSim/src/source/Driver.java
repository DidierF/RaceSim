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
		for(int i = 0; i < 100; i++){
			accelerate();
			car.moveForward();
		}
		// while(car.getSpeed() < Car.TOP_SPEED){
		//  	car.speedUp();
		//  	// System.out.println("Speed: " + car.getSpeed());
		//  	// System.out.println("Gear: " + car.getGear());
		//  	if(car.getRPM() >= Car.MAX_RPM){
		//  		car.gearUp();
		//  	}
		//  	try{
		//  		Thread.sleep(100);
		//  	}
		//  	catch (InterruptedException e){
		//  		e.printStackTrace();
		//  	}
		//  }
		//  while(car.getSpeed() > 0){
		//  	car.speedDown();
		//  	// System.out.println("Speed: " + car.getSpeed());
		//  	// System.out.println("Gear: " + car.getGear());
		//  	if(car.getRPM() <= 1000){
		//  		car.gearDown();
		//  	}
		//  	try {
		//  		Thread.sleep(100);
		//  	}
		//  	catch (InterruptedException e){
		//  		e.printStackTrace();
		//  	}
		//  }
	}

	public void drive(){
		run();
	}

	private void accelerate(){
		car.speedUp();
	}
//
//	private void brake(){
//		car.speedDown();
//	}
}