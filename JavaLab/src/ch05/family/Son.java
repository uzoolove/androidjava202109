package ch05.family;

public class Son extends Parent implements Gamer{
	public Son(String name) {
		super(name);
	}
	
	// 메소드 오버라이딩(재정의)
	// 물려받은 부모의 메소드를 자식 클래스가 재정의
	public void play() {
		System.out.println(name + ": 나이트에 간다.");
	}
	
	public void study() {
		System.out.println(name + ": 독서실에 간다.");
	}
	
	public void game() {
		System.out.println(name + ": 피씨방에서 RPG 게임을 한다.");
	}
}
