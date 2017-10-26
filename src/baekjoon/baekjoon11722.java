package baekjoon;

/*
 * 가장 긴 감소하는 부분 수열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(input[i]);
			dp[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(A[i]<A[j]) {
					dp[i] = compareInt(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}

	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
