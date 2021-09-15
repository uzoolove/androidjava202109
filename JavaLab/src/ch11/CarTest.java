package ch11;

public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new OpenCar();
		Car c3 = new MyCar();
		Car c4 = new MyCar2();
		
		cityTour(c1);
		cityTour(c2);
		cityTour(c3);
		cityTour(c4);
	}
	static void cityTour(Car c) {
		c.start();
		c.drive();
		
		System.out.println("벽을 만났다.");
		if(c instanceof Tank) {
			((Tank)c).shoot();
		}else {
			System.out.println("벽을 돌아감");
		}
		System.out.println("흙더미를 만났다.");
		if(c instanceof Fork) {
			((Fork)c).fork();
		}else {
			System.out.println("흙더미를 돌아감");
		}
		
		c.stop();
		System.out.println("");
	}
}
class Car {
	void start() {
		System.out.println("출발");
	}
	void drive() {
		System.out.println("운전");
	}
	void stop() {
		System.out.println("정지");
	}
}
class OpenCar extends Car{
	void open() {
		System.out.println("open");

	}
	void close() {
		System.out.println("close");
		
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
	public void shoot() {
		System.out.println("포를 쏜다");
	}
}
class MyCar2 extends Car implements Tank, Fork{
	public void shoot() {
		System.out.println("포를 쏜다");
	}
	public void fork() {
		System.out.println("흙더미를 치우다");
	}
	
}
