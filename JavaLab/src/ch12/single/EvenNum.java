package ch12.single;

public class EvenNum implements Runnable{
	// 1~10 까지의 짝수 출력
	public void run(){
		System.out.println("5. 짝수 출력 시작.");
		for(int i=2; i<=10; i+=2) {
			System.out.println("6. 짝수: " + i);
		}
		System.out.println("7. 짝수 출력 종료.");
	}
}
