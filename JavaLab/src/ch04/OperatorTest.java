package ch04;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 100;
		short s = 30000;
		int i = 2000000000;
		long l = 2342342342352345234L;
		float f = 23423434534534.234234F;
		double d = 43252343451234435.12345345345;
		char c1 = 'a';
		char c2 = '가';
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.print(b);
		System.out.print(s);
		System.out.print(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(b1);
		System.out.println(b2);
		
		int bb = (int)b + 100;
		System.out.println(bb);
		
		byte bbb = (byte)bb;	// 紐낆떆�쟻 �삎蹂��솚(�겙 �뜲�씠�꽣瑜� �옉�� �겕湲곕줈 蹂�寃�)
		System.out.println(bbb);
		
		int bbbb = b;			// �옄�룞 �삎蹂��솚
		System.out.println(bbbb);
	}

}


//class System{
//	public static PrintStream out = new PrintStream();
//}
//
//class PrintStream{
//	public void println() {
//		
//	}
//	public void println(int msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void println(float msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void println(double msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void println(boolean msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void println(String msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void println(Object msg) {
//		// 표준출력장치에 msg를 출력하고 줄바꿈 기호 추가.
//		// ......
//	}
//	public void print(int msg) {
//		// 표준출력장치에 msg를 출력한다.
//		// ......
//	}
//	// ......
//}



