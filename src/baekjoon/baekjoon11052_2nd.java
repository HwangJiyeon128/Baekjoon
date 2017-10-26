package baekjoon;

/*
 * ºØ¾î»§ ÆÇ¸ÅÇÏ±â
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon11052_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];
		int[] dp = new int[N];
		
		String tmp[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			p[i] = Integer.parseInt(tmp[i]);
		}
		
		for(int i=0; i<N; i++) {
			dp[i] = p[i];
			for(int j=0; j<i; j++) {
				dp[i] = findMax(dp[i-j-1]+p[j], dp[i]);
			}
		}
		System.out.println(dp[N-1]);
	}
	
	public static int findMax(int a, int b) {
		return a>b? a:b;
	}
}
