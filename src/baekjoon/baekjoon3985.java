package baekjoon;

/*
 * 롤 케이크
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon3985 {
	
	static class Person {
		int start, end;
		Person(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L+1];
		Person[] person = new Person[N+1];
		
		int expectedMax = 0, actualMax = 0, expectedResult = 0, actualResult = 0;
		
		for(int i=1; i<=N; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]), end = Integer.parseInt(input[1]);
			person[i] = new Person(start, end);
		}
		
		for(int i=1; i<=N; i++) {
			int start = person[i].start, end = person[i].end;
			int value = end-start+1;
			if(expectedMax < value) {
				expectedMax = value;
				expectedResult = i;
			}
			
			int cnt = 0;
			for(int j=start; j<=end; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}
			}
			
			if(actualMax < cnt) {
				actualMax = cnt;
				actualResult = i;
			}
		}
		
		System.out.println(expectedResult);
		System.out.println(actualResult);
	}

}
