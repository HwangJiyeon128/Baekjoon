package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class baekjoon1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
		Queue<String> result = new LinkedList<String>();
		String[] input = new String[N+M];
		
		for(int i=0; i<N+M; i++) {
			input[i] = br.readLine();
		}
		Arrays.sort(input);
		
		for(int i=0; i<N+M-1; i++) {
			if(input[i].equals(input[i+1]))
				result.add(input[i]);
		}
		
		System.out.println(result.size());
		for(String x: result) {
			System.out.println(x);
		}
	}
}
