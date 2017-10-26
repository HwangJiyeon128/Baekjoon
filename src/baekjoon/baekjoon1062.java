package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1062 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int result = 0;
		
		int[] alpha;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			int cnt = 0;
			alpha = new int[26];
			for(int j=0; j<input.length(); j++) {
				alpha[(int)input.charAt(j)-97]++;
			}
			for(int j=0; j<26; j++) {
				if(alpha[j]>0)
					cnt++;
			}
			if(cnt <= K)
				result++;
		}
		
		System.out.println(result);
	}
}
