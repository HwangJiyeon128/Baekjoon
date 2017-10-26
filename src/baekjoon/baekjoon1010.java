package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1010 {
	
	static int N, M, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), test = 0;
		while(test++ < T) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			cnt = 0;
			
			solve(1, 1);
			
			System.out.println(cnt);
		}
		br.close();
	}

	public static void solve(int level, int num) {
		if(level >= M) {
			cnt++;
			return ;
		}
		solve(++level, ++num);
	}
}
