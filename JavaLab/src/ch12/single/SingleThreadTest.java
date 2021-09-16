package ch12.single;

public class SingleThreadTest {
	public static void main(String[] args) {
		System.out.println("1. main 시작.");
		OddNum odd = new OddNum();
		EvenNum even = new EvenNum();
		
		odd.start();
		new Thread(even).start();
				
		// 3의 배수 출력(익명 inner class)
		// Thread를 상속받고 run() 메소드를 오버라이드하는 클래스를 정의해서 객체 생성
		new Thread() {
			public void run() {
				for(int i=3; i<=10; i+=3) {
					System.out.println("3의 배수: " + i);
				}
			}
		}.start();
		
		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("8. main 종료.");
	}
}

//class Thread{
//	private Runnable r;
//	public Thread() {}
//	public Thread(Runnable r) {
//		this.r = r;
//	}
//	public void run() {}
//	public void start() {
//		// 쓰레드 생성 및 관리 작업 시작
//		// ......
//		if(r != null) {
//			r.run();
//		}else {
//			run();
//		}		
//	}
//}







