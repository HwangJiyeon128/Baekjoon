package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(countNum(N));
	}

	public static long countNum(int n) {
		long result = 0;
		int[][] dp = new int[n + 1][10];

		if (n > 0) {
			for (int i=0; i<10; i++)
				dp[1][i] = 1;
			if (n > 1) {
				for (int i=2; i<=n; i++) {
					for (int j = 0; j < 10; j++) {
						for(int k=j; k>=0; k--) {
							dp[i][j] = (dp[i][j]+dp[i-1][k]) % 10007;
						}
					}
				}
			}
		}

		for (int j = 0; j < 10; j++) {
			result = (result + dp[n][j]) % 10007;
		}
		return result;
	}
}
