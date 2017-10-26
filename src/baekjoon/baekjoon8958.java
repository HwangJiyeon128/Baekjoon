package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), test = 0;
		
		while(test++ < T) {
			String str = br.readLine();
			char[] strArr = str.toCharArray();
			int size = strArr.length, answer = 0;
			int[] dp = new int[size];
			
			if(strArr[0]=='O')
				dp[0] = 1;
			else
				dp[0] = 0;
			for(int i=1; i<size; i++) {
				if(strArr[i]=='O') {
					dp[i] = dp[i-1]+1;
				}
			}
			
			for(int i=0; i<size; i++) {
				answer += dp[i];
			}
			System.out.println(answer);
		}
	}

}
