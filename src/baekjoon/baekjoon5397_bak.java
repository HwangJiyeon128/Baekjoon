package baekjoon;


import java.util.*;

public class baekjoon5397_bak {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		
		while(testCase-- > 0) {
			int cur = 0;
			String str = scanner.next();
			String password = "";
			
			for(int i = 0; i<str.length(); i++) {
				System.out.println("str.charAt(i): "+str.charAt(i));
				if(str.charAt(i) == '<') {
					if(cur > 0)
						cur--;
					else continue;
				}
				else if(str.charAt(i) == '>') {
					if(cur < password.length())
						cur++;
					else continue;
				}
				else if(str.charAt(i) == '-'){
					if(password != null) {
						if(password.length() == cur)
							password = password.substring(0, cur-1);
						else
							password = password.substring(0, cur-1)+password.substring(cur, password.length());
						cur--;
					}
					continue;
				}
				else {
					if(password.length() > 0)
						password = password.substring(0, cur) + str.charAt(i)+password.substring(cur, password.length());
					else
						password = password.substring(0, cur) + str.charAt(i);
					cur++;
				}
				System.out.println("cur: " + cur);
				System.out.println("password: "+password);
			}
			System.out.println("password: "+password);
		}
	}

}
