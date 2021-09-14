package ch05;

public class MyMath2 {
	int n1;
	int n2;
	
	void plus() {
		System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
	}
	void minus() {
		System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
	}
	void multiple() {
		System.out.println(n1 + " * " + n2 + " = " + (n1*n2));
	}
	void division() {
		System.out.println(n1 + " / " + n2 + " = " + ((double)n1/n2));
	}

	public static void main(String[] args) {
		MyMath2 m2 = new MyMath2();
		m2.n1 = 10;
		m2.n2 = 20;
		m2.plus();
		m2.minus();
		m2.multiple();
		m2.division();
	}

}
