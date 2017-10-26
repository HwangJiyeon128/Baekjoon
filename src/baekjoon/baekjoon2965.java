package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class baekjoon2965 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int[] kangaroo = new int[3];
		kangaroo[0] = Integer.parseInt(input[0]);
		kangaroo[1] = Integer.parseInt(input[1]);
		kangaroo[2] = Integer.parseInt(input[2]);
		
		boolean finish = false;
		int answer = 0;
		while(!finish) {
			Arrays.sort(kangaroo);
			if((kangaroo[2]-kangaroo[1]==1)&&(kangaroo[1]-kangaroo[0]==1)) {
				finish = true;
				break;
			}
			if((kangaroo[2]-kangaroo[1]) > (kangaroo[1]-kangaroo[0]))
				kangaroo[0] = kangaroo[1]+1;
			else 
				kangaroo[2] = kangaroo[1]-1;
			answer++;
		}
		System.out.println(answer);
	}

}
