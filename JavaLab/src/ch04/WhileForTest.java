package ch04;

public class WhileForTest {

	public static void main(String[] args) {
		// 1~100 합계(while)
		int sum = 0;
		int n = 1;
		while(n <= 100) {
			sum += n;
			n++;
		}
		
		// 1~100 합계(for)
		sum = 0;
		for(int i=1; i<=100; i++) {	// 초기화, 조건문, 증감식
			sum += i;
		}
		System.out.println("1~100 합계: " + sum);
		
		/*
		 * 채팅앱을 구글플레이에 런칭했다.
		 * 가격은 1000원.
		 * 1일차에 1명이 다운로드 받음.
		 * 2일차에 2명이 다운로드 받음.
		 * 3일차에 4명이 다운로드 받음.
		 * 2주후 총 매출은 얼마인가?(for)
		 */
		int price = 1000;
		int totalDownload = 0;
		int todayDownload = 1;
		int day = 1;
		for(; day<=14; day++) {
			totalDownload += todayDownload;
			todayDownload *= 2;
			System.out.println(day + ": " + totalDownload);
		}
		System.out.println(--day + "일이 지나면 매출은 " + totalDownload*price);
				
		/*
		 * 총 매출 10억을 넘기려면 몇일이 걸리나?(while) 
		 */
		totalDownload = 0;
		day = 1;
		todayDownload = 1;
		while(totalDownload < 1000000000/price) {
			totalDownload += todayDownload;
			todayDownload *= 2;
			day++;
		}
		System.out.println(--day + "일이 지나면 매출은 " + totalDownload*price);
	}

}
