package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), test = 0;
		
		while(test++ < T) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			String str = input[1];
			String answer = "";
			
			for(int i=0; i<str.length(); i++) {
				for(int j=0; j<N; j++) {
					answer += str.charAt(i);
				}
			}
			System.out.println(answer);
		}
	}

}
