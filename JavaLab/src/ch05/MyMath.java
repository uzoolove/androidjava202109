package ch05;

public class MyMath {
	
	/*
	 * 메소드 오버로딩
	 * 	- 같은 클래스 내에서 동일한 이름의 메소드를 중복 정의
	 * 	- 단, 매개변수의 타입, 개수, 순서를 다르게 정의해야한다.
	 */
	
	// 10 + 20의 결과를 출력한다.
	static void printSum() {
		int n1 = 10;
		int n2 = 20;
		int result = n1 + n2;
		System.out.println(n1 + " + " + n2 + " = " + result);
	}	
	// 10 + n2의 결과를 출력한다.
	static void printSum(int n2) {
		int n1 = 10;
		int result = n1 + n2;
		System.out.println(n1 + " + " + n2 + " = " + result);
	}	
	// n1 + n2의 결과를 출력한다.
	void printSum(int n1, int n2) {
		int result = n1 + n2;
		System.out.println(n1 + " + " + n2 + " = " + result);
	}
	// n1 + n2의 결과를 반환한다.
	static String getSum(int n1, int n2) {
		int result = n1 + n2;
		return (n1 + " + " + n2 + " = " + result);
	}

	public static void main(String[] args) {
		printSum();
		printSum(30);
		printSum(40);
		
		MyMath m = new MyMath();
		m.printSum(50, 60);
		m.printSum(70, 80);
		String result = getSum(80, 90);
		System.out.println(result);
	}

}
