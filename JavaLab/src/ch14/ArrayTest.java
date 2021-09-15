package ch14;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// 배열 선언
		int[] nums;
		// 배열 생성
		nums = new int[3];
		
		// 배열 선언과 생성
		int[] nums2 = new int[3];
		// 배열 초기화
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 배열 선언 + 생성 + 초기화
		int[] nums3 = new int[] {10, 20, 30};
		int[] nums4 = {10, 20, 30};
		
		System.out.println(Arrays.toString(nums));
		
		// 배열의 모든 요소 출력
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		// enhanced for loop
		for(int num : nums) {
			System.out.println(num);
		}
		
	}

}
