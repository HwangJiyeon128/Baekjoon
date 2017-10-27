package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(countTile(n) % 10007);
	}

	public static long countTile(int n) {
		long[] dp = new long[n + 1];
		dp[1] = 1;
		if (n > 1) {
			dp[2] = 3;

			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
			}
		}
		return dp[n];
	}
}
