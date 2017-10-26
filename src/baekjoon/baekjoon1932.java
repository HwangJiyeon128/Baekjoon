package baekjoon;

/*
 * 숫자 삼각형
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] data = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<i+1; j++) {
				data[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		dp[0][0] = data[0][0];
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0]+data[i][0];
			dp[i][i] = dp[i-1][i-1]+data[i][i];
			for(int j=1; j<=i; j++) {
				dp[i][j] = compareInt(dp[i-1][j-1]+data[i][j], dp[i-1][j]+data[i][j]); 
			}
		}
		
		int[] result = dp[n-1];
		Arrays.sort(result);
		System.out.println(result[n-1]);
	}
	
	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
