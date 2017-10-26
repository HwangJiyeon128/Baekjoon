package baekjoon;

/*
 * 동전 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		for(int i=0; i<n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=k; i++)
			dp[i] = 10001;
		
		Arrays.sort(coin);
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {//0부터 시작하면 표현할 수 있는 가치, 0부터 아니면 표현 못하는 가지
				//System.out.println("j: "+j+", dp[j]: "+dp[j]+", dp[j-coin[i]]+1: "+(dp[j-coin[i]]+1));
				dp[j] = compareInt(dp[j], dp[j-coin[i]]+1);
				//System.out.println("j: "+j+", dp[j]: "+dp[j]+", dp[j-coin[i]]+1: "+(dp[j-coin[i]]+1));
			}
		}
		
//		for(int i=0; i<=k; i++)
//			System.out.print(dp[i]+" ");
//		System.out.println();
		
		if(dp[k]>=10001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}

	public static int compareInt(int a, int b) {
		return (a<b)? a:b;
	}
}
