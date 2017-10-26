package baekjoon;

/*
 * 포도주 시식 - 값은 정수이다->음수값도 생각해 봐야 한다.
 */

import java.util.*;

public class baekjoon2156 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int N;
		int[] wine = new int[10010];
		int[] Dp = new int[10010];
		
		N = scanner.nextInt();
		for(int i=1; i<=N; i++)
			wine[i] = scanner.nextInt();
		
		for(int i=1; i<3 && i<=N; i++) {
			if(i==1)
				Dp[i] = wine[i];
			else
				Dp[i] = wine[i] +wine[i-1];
		}
		
		for(int i=3; i<=N; i++) {
			int result = 0;
			if(wine[i]+Dp[i-2]>Dp[i-1]) 
				result = wine[i]+Dp[i-2];
			else
				result = Dp[i-1];
			if(result<wine[i]+wine[i-1]+Dp[i-3])
				result = wine[i]+wine[i-1]+Dp[i-3];
			Dp[i] = result;
		}
		
		System.out.println(Dp[N]);
	}

}
