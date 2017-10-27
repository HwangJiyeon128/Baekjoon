package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1254 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int result = 0, n = 0;
		boolean finish = false;
		
		result = checkString(input);
		if(result > 0)
			finish = true;
		
		
		while(!finish) {
			String subStr = input.substring(0, n+1);
			subStr = (new StringBuffer(subStr)).reverse().toString();
			
			String tmp = input+subStr;
			
			result = checkString(tmp);
			if(result > 0)
				finish = true;
			n++;
		}
		
		System.out.println(result);
	}

	public static int checkString (String str) {
		String tmp = (new StringBuffer(str)).reverse().toString();
		
		if(tmp.equals(str))	return str.length();
		return 0;
	}
}
