package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1152 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		String[] inputArr = input.split(" ");
		if(inputArr[0].equals(""))
			System.out.println(0);
		else
			System.out.println(inputArr.length);
	}

}
