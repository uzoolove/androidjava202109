package ch11;

public class BellTest {
	public static void main(String[] args) {
//		Bell b = new DoorBell();
		Bell b = new AlarmBell();
		b.ring();
	}
}

abstract class Bell{
	abstract void ring();
}

class DoorBell extends Bell{
	void ring() {
		System.out.println("띵동~ 띵동~");
	}
}

class AlarmBell extends Bell{
	void ring() {
		System.out.println("띠리리리~ 띠리리리~");
	}
}






