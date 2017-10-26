package baekjoon;

/*
 * 가장 큰 증가하는 부분수열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] dp = new int[N+1];
		String[] input = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(input[i-1]);
		}
		
		dp[1] = A[1];
		for(int i=2; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(A[i]>A[j]) {
					dp[i] = compareInt(dp[i], dp[j]+A[i]);
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
