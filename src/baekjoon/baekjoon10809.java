package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		String input = br.readLine();
		
		for(int i=0; i<alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		for(int i=0; i<input.length(); i++) {
			int index = (int)input.charAt(i)-97;
			if(alphabet[index] < 0)
				alphabet[index] = i;
		}
		
		for(int i=0; i<alphabet.length; i++) {
			System.out.print(alphabet[i]+" ");
		}
		System.out.println();
	}

}
