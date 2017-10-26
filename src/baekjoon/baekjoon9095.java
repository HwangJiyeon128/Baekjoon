package baekjoon;

/*
 * 1, 2, 3 ´õÇÏ±â
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n + 1];

			dp[1] = 1;
			if (n > 1) {
				dp[2] = 2;
				if (n > 2) {
					dp[3] = 4;
					if (n > 3) {
						for (int i = 4; i <= n; i++) {
							dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
						}
					}
				}
			}
			System.out.println(dp[n]);
		}
	}

}
