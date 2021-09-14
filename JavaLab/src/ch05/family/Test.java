package ch05.family;

public class Test {

	public static void main(String[] args) {
//		Parent p = new Parent("부모");
		Parent p = new Son("아들");	// 자동 형변환(up casting)
//		Parent p = new Daughter("딸");
		
		dailyPlan(p);		
		
		Gamer f = new SonFriend();
		playGame(f);
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
		p.study();
		
		if(p instanceof Son) {
			Son s = (Son)p;	// down casting
			s.game();
		}
		
		p.sleep();
	}
	
	static void playGame(Gamer g) {
		g.game();
	}

}
