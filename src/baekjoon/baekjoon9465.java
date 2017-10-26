package baekjoon;

import java.util.*;

/*
 * ½ºÆ¼Ä¿
 */

public class baekjoon9465 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		
		while(testCase-- > 0) {
			int n = scanner.nextInt();
			int[][] sticker = new int[2][n];
			int[][] point = new int[2][n+1];
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<n; j++) {
					sticker[i][j] = scanner.nextInt();
				}
			}
			
			point[0][0] = point[1][0] = 0;
			point[0][1] = sticker[0][0];
			point[1][1] = sticker[1][0];
			for(int s=2; s<n+1; s++) {
				point[0][s] = findMax(point[1][s-1], point[1][s-2]) + sticker[0][s-1];
				point[1][s] = findMax(point[0][s-1], point[0][s-2]) + sticker[1][s-1];
			}
			
			System.out.println(findMax(point[0][n], point[1][n]));
		}
	}
	
	public static int findMax(int val1, int val2) {
		return (val1 > val2)? val1 : val2;
	}

}
