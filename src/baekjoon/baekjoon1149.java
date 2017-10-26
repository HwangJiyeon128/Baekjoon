package baekjoon;

/*
 * RGB °Å¸®
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] houseRGB = new int[N][3];
		int[][] dp = new int[N][3];
		int result;
		
		for(int i=0; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				houseRGB[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		dp[0][0] = houseRGB[0][0];
		dp[0][1] = houseRGB[0][1];
		dp[0][2] = houseRGB[0][2];
		
		for(int i=1; i<N; i++) {
			dp[i][0] = compareInt(dp[i-1][1], dp[i-1][2]) + houseRGB[i][0];
			dp[i][1] = compareInt(dp[i-1][0], dp[i-1][2]) + houseRGB[i][1];
			dp[i][2] = compareInt(dp[i-1][0], dp[i-1][1]) + houseRGB[i][2];
		}
		
		result = dp[N-1][0];
		for(int i=1; i<3; i++) {
			if(result > dp[N-1][i])
				result = dp[N-1][i];
		}
		System.out.println(result);
		
	}
	
	public static int compareInt(int a, int b) {
		return (a<b)? a:b;
	}

}
