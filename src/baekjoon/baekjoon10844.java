package baekjoon;

/*
 * 쉬운 계단 수
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon10844 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		long result=0;
		
		for(int j=1; j<10; j++) {
			dp[1][j] = 1;
		}
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if(j==0)
					dp[i][j] += dp[i-1][1];
				else if(j==9)
					dp[i][j] += dp[i-1][8];
				else {
					dp[i][j] += dp[i-1][j+1]+dp[i-1][j-1];
				}
				dp[i][j] %= 1000000000;
			}
		}
		
		for(int i=0; i<10; i++) {
			result += dp[N][i];
		}
		System.out.println(result%1000000000);
	}
}
