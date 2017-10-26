package baekjoon;

import java.util.Scanner;

public class baekjoon2941_ans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str2 = scanner.nextLine();
        int i, countAl=0;
        str2 = str2.replace("c=", "*");
        str2 = str2.replace("c-", "*");
        str2 = str2.replace("dz=", "*");
        str2 = str2.replace("d-", "*");
        str2 = str2.replace("lj", "*");
        str2 = str2.replace("nj", "*");
        str2 = str2.replace("s=", "*");
        str2 = str2.replace("z=", "*");

        
        System.out.println(str2.length());
	}

}
