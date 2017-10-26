package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i=0, plus=1, result = 1, cnt = 0;
		
		while(N > result) {
			result = 6*i+1;
			i=i+(plus++);
			cnt++;
//			System.out.println("plus: "+plus);
//			System.out.println("6*"+i+"+1="+result);
		}
		
		if(N==1)
			System.out.println(1);
		else
			System.out.println(cnt);
	}

}
