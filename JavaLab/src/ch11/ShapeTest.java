package ch11;

public class ShapeTest {

	public static void main(String[] args) {
		Circle s1 = new Circle(5);
		Rectangle s2 = new Rectangle(10, 20);
		
		printArea(s1);
		printArea(s2);
	}
	
	static void printArea(Shape s) { // 3. 다형성의 조건(up casting)
		s.draw();	// 다형성
		s.area();	// 다형성
	}

}

abstract class Shape{
	void draw() {
		System.out.println("도형 그릴 준비를 한다.");
	}
	// 도형의 넓이를 계산해서 출력한다.
	abstract void area();
}

class Circle extends Shape{	// 1. 다형성의 조건(상속)
	private int r;
	public Circle(int r) {
		this.r = r;
	}

	void draw() { 	// 2. 다형성의 조건(메소드 오버라이딩)
		super.draw();
		System.out.println("원을 그린다.");
	}

	@Override
	void area() {
		System.out.println("원의 넓이는 " + Math.PI*r*r + "입니다.");
	}
}

class Rectangle extends Shape{
	private int w;
	private int h;
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	void draw() {
		super.draw();
		System.out.println("사각형을 그린다.");
	}

	@Override
	void area() {
		System.out.println("사각형의 넓이는 " + w*h + "입니다.");
	}
}






