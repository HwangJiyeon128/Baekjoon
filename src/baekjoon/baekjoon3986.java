package baekjoon;

import java.util.*;

//STACK
public class baekjoon3986 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt(), cnt = 0, i, j, result = 0;
		boolean check = false;
		String[] str = new String[num];
		

		for (i = 0; i < num; i++) {
			str[i] = scanner.next();
		}

		for (i = 0; i < num; i++) {
			cnt = 0;
			String tmp_str = str[i];
			char tmp = str[i].charAt(i);
			int length = str[i].length();
			check = true;

			if (length % 2 == 0) {
				for (j = 1; j < length; j++) {
					if (tmp_str.charAt(j) == tmp) {
						if (check) {
							check = false;
							if (cnt % 2 == 1)
								break;
							if(j<length-1)
								tmp = str[i].charAt(j+1);
						} else
							check = true;
					} 
					else
						cnt++;
					if (!check && j == length - 1)
						result++;
				}
			}
		}
		System.out.println(result);
	}

}
