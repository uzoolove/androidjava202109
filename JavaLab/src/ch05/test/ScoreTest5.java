package ch05.test;

import ch05.Score5;

public class ScoreTest5 {

	public static void main(String[] args) {
		// 김철수의 국어, 영어, 수학 점수가 각각 100, 90, 71일때
		// 총점과 평균을 출력하시오.
		Score5 kim = new Score5(100, 90, 92);
		System.out.println("kim 평균: " + kim.avg());

		// 이영희의 국어, 영어, 수학 점수가 각각 90, 80, 99일때
		// 총점과 평균을 출력하시오.
		Score5 lee = new Score5(90, 80, 99);
		System.out.println("lee 평균: " + lee.avg());
		
		System.out.println(kim.toString());
		System.out.println(lee);
		
	}

}
