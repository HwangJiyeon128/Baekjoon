package baekjoon;

/*
 * ½ºÆ¼Ä¿
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon9465_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			int[][] dp = new int[2][n];

			for (int i = 0; i < 2; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
					sticker[i][j] = Integer.parseInt(str[j]);
			}

			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			if (n > 1) {
				dp[0][1] = sticker[0][1] + sticker[1][0];
				dp[1][1] = sticker[1][1] + sticker[0][0];

				for (int i=2; i < n; i++) {
					dp[0][i] = compareInt(dp[1][i-1], dp[1][i-2])+sticker[0][i];
					dp[1][i] = compareInt(dp[0][i-1], dp[0][i-2])+sticker[1][i];
				}
			}
			System.out.println(compareInt(dp[0][n-1], dp[1][n-1]));
		}
	}
	
	public static int compareInt(int a, int b) {
		return (a>b)?a:b;
	}
}
