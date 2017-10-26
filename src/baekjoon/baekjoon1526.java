package baekjoon;

import java.util.*;

/*
 * 가장 큰 금민수
 */

public class baekjoon1526 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next(), result="";
		int input = Integer.parseInt(str);
		while(true) {
			String tmp_str = Integer.toString(input);
			int count4 = 0, count7 = 0;
			for(int i=0; i<tmp_str.length(); i++) {
				if(tmp_str.charAt(i)=='7')
					count7++;
				else if(tmp_str.charAt(i)=='4')
					count4++;
			}
			if((count7+count4)==tmp_str.length()) {
				result = tmp_str;
				break;
			}
			input--;
		}
		System.out.println(result);
	}
	

}
