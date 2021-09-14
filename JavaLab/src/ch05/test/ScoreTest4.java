package ch05.test;

import ch05.Score4;

public class ScoreTest4 {

	public static void main(String[] args) {
		// 김철수의 국어, 영어, 수학 점수가 각각 100, 90, 71일때
		// 총점과 평균을 출력하시오.
		Score4 kim = new Score4();
		kim.setKor(100);
		kim.setEng(90);
		kim.setMath(92);
		kim.setMath(kim.getMath()+10);
//		kim.kor = 100;
//		kim.eng = 90;
//		kim.math = 72;
//		kim.math += 10;

//		System.out.println("kim 총점: " + kim.sum());
		System.out.println("kim 평균: " + kim.avg());

		// 이영희의 국어, 영어, 수학 점수가 각각 90, 80, 99일때
		// 총점과 평균을 출력하시오.
		Score4 lee = new Score4();
		lee.setKor(90);
		lee.setEng(80);
		lee.setMath(99);
//		lee.kor = 90;
//		lee.eng = 80;
//		lee.math = 99;

//		System.out.println("lee 총점: " + lee.sum());
		System.out.println("lee 평균: " + lee.avg());
		
	}

}
