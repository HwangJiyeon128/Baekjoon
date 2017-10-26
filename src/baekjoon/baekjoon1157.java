package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim().toLowerCase();
		int[] alpha = new int[26];
		String answer = "";
		
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i)-97]++;
		}
		
		int max = -1, index = 0;
		for(int i=0; i<26; i++) {
			if(alpha[i]>0) {
				if(max < alpha[i]) {
					max = alpha[i];
					index = i;
					answer = "";
				}
				else if(max == alpha[i])
					answer = "?";
			}
		}
		if(answer.length()>0)
			System.out.println("?");
		else
			System.out.println((char)(index+65));
	}

}
