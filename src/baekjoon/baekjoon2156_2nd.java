package baekjoon;

/*
 * 포도주 시식
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon2156_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
		dp[0] = compareInt(wine[0], 0);
		if(n>1) {
			dp[1] = compareInt(dp[0], dp[0]+wine[1]);
			if(n>2) {
				dp[2] = compareInt(dp[1], wine[0]+wine[2], wine[1]+wine[2]);
				for(int i=3; i<n; i++) {
					dp[i] = compareInt(dp[i-1], dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
	
	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
	public static int compareInt(int a, int b, int c) {
		int[] tmp = {a, b, c};
		Arrays.sort(tmp);
		return tmp[2];
	}
}
