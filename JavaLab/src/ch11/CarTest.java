package ch11;

public class CarTest {
	public static void main(String[] args) {
		
	}
}
class Car{
	void start() {
		System.out.println("출발.");
	}
	void drive() {
		System.out.println("운전.");
	}
	void stop() {
		System.out.println("정지.");
	}
}
class OpenCar extends Car{
	void open() {
		System.out.println("open.");
	}
	void close() {
		System.out.println("close.");
	}
	void start() {
		open();
		super.start();
	}
	void stop() {
		super.stop();
		close();
	}
}
interface Tank{
	void shoot();
}
interface Fork{
	void fork();
}

class MyCar extends OpenCar implements Tank{
	
}

class MyCar2 extends Car implements Tank, Fork{
	
}



