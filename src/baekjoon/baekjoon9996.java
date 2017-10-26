package baekjoon;

/*
 * 한국이 그리울 땐 서버에 접속하지
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon9996 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String startP = pattern.substring(0, pattern.indexOf("*"));
		String endP = pattern.substring(pattern.indexOf("*")+1, pattern.length());
		
		String[] file = new String[N];
		for(int i=0; i<N; i++) {
			file[i] = br.readLine();
		}
		String[] result = new String[N];
		
		for(int i=0; i<N; i++) {
			int check = 0;
			boolean startC = false, endC = false;
			if(startP.length()+endP.length()>file[i].length()) {
				result[i] = "NE";
				continue;
			}
			for(int j=0; j<startP.length(); j++) {
				if(j>=file[i].length())
					break;
				if(file[i].charAt(j) == startP.charAt(j))
					check++;
			}
			if(check == startP.length())
				startC = true;
			
			check = 0;
			int index = endP.length()-1;
			for(int j=file[i].length()-1; j>file[i].length()-endP.length()-1; j--) {
				if(file[i].length()-endP.length()-1<0)
					break;
				if(file[i].charAt(j) == endP.charAt(index--))
					check++;
			}
			if(check == endP.length())
				endC = true;
			if(startC && endC)
				result[i] = "DA";
			else
				result[i] = "NE";
		}
		
		for(int i=0; i<N; i++)
			System.out.println(result[i]);
	}

}
