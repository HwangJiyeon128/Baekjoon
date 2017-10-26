package baekjoon;

/*
 * ¿¬¼ÓÇÕ
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon1912_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] val = new int[n];
		int[] dp = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			val[i] = Integer.parseInt(input[i]);
		}
		
		dp[0] = val[0];
		for(int i=1; i<n; i++) {
			dp[i] = compareInt(dp[i-1]+val[i], val[i]);
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}

	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
