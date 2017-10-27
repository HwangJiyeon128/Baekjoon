package baekjoon;

import java.util.*;

public class baekjoon9933 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcase = scanner.nextInt();
		String[] str1 = new String[testcase];
		String[] str2 = new String[testcase];
		String passwd = null;
		
		for(int i=0; i<testcase; i++) {
			str1[i] = scanner.next();
			str2[i] = reverseString(str1[i]);
		}
		
		for(int j=0; j<testcase; j++) {
			for(int k=0; k<testcase; k++) {
				if(str1[j].equals(str2[k])) {
					passwd = str2[k];
				}
			}
		}
		
		if(passwd!=null)
			System.out.println(passwd.length()+" "+passwd.charAt(passwd.length()/2));
		
	}
	
	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

}
