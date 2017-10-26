package baekjoon;

/*
 * 가장 긴 증가하는 부분수열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		int[] dp = new int[N+1];
		String[] input = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(input[i-1]);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<i; j++) {
				if(num[i]>num[j]) {
					dp[i] = compareInt(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}

	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
