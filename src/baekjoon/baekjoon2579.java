package baekjoon;

/*
 * 계단 오르기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] val = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			val[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = val[1];
		if(n>2) {
			dp[2] = val[2]+val[1];
				for(int i=3; i<=n; i++) {
					dp[i] = compareInt(dp[i-3]+val[i-1]+val[i], dp[i-2]+val[i]);
				}
			
		}
		System.out.println(dp[n]);
	}

	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
