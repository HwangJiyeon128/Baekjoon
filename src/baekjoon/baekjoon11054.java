package baekjoon;

/*
 * 가장 긴 바이토닉 부분 수열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		int[] dpIncre = new int[N];
		int[] dpDecre = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(input[i]);
			dp[i] = 1;
			dpIncre[i] = 1;
			dpDecre[i] = 1;
		}
		
		//incre
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(A[i]>A[j])
					dpIncre[i] = compareInt(dpIncre[i], dpIncre[j]+1);
			}
		}
		
		//decre
		for(int i=N-1; i>=0; i--) {
			for(int j=i; j<N; j++) {
				if(A[i]>A[j]) {
					dpDecre[i] = compareInt(dpDecre[i], dpDecre[j]+1);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			dp[i] = dpIncre[i]+dpDecre[i]-1;
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
	public static int compareInt(int a, int b) {
		return (a>b)? a:b;
	}
}
