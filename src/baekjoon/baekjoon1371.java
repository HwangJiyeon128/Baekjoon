package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1371 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int[] alpha = new int[26];
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("") || tmp.equals(null))
				break;
			str += tmp;
		}
		
		str = str.replace(" ", "");
		int max = 0;
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i)-97]++;
		}
		for(int i=0; i<26; i++) {
			if(alpha[i] > max)
				max = alpha[i];
		}
		for(int i=0; i<26; i++) {
			if(alpha[i]==max)
				System.out.print((char)(i+97));
		}
		System.out.println();
	}

}
