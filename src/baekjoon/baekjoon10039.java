package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon10039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] score = new int[5];
		int sum = 0;
		for(int i=0; i<5; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp < 40)
				score[i] = 40;
			else
				score[i] = tmp;
		}
		for(int i=0; i<5; i++) {
			sum += score[i];
		}
		System.out.println(sum/5);
	}

}
