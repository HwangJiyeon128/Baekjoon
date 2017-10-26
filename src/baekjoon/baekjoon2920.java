package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int[] arr = new int[input.length];
		int cnt = 0;
		
		for(int i=0; i<input.length; i++)
			arr[i] = Integer.parseInt(input[i]);
		
		for(int i=1; i<input.length; i++) {
			if((arr[i]-arr[i-1])>0)
				cnt++;
			else
				cnt--;
		}
		
		if(cnt==input.length-1)
			System.out.println("ascending");
		else if(cnt==input.length*(-1)+1)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}

}
