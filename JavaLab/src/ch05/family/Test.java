package ch05.family;

public class Test {

	public static void main(String[] args) {
//		Parent p = new Parent("부모");
//		Parent p = new Son("자식");	// 자동 형변환(up casting)
		Parent p = new Daughter("딸");
		
		
		dailyPlan(p);
	}
	
	/*
	 * 다형성의 조건
	 * 	1. 상속관계
	 * 	2. up casting
	 * 	3. 메소드 오버라이딩
	 */
	static void dailyPlan(Parent p) {
		p.eat();
		p.play();	// 다형성(캬바레/나이트)
		p.sleep();
	}

}
