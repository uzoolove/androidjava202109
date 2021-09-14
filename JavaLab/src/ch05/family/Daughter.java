package ch05.family;

public class Daughter extends Parent {

	public Daughter(String name) {
		super(name);
	}
	
	public void play() {
		System.out.println(name + ": 클럽에 간다.");
	}

}
