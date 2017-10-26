package baekjoon;

/*
 * Á¦°ö¼öÀÇ ÇÕ
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.*;

public class baekjoon1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		if(N>1)
			dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = 10000;
			for(int j=1; j<=Math.sqrt(i); j++) {
				dp[i] = compareInt(dp[i-j*j]+1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
	
	public static int compareInt(int a , int b) {
		return (a<b)? a:b;
	}
}
