 package baekjoon;

/*
 * ���ڿ� ����
 */
 
import java.util.*;

public class baekjoon9935 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		String delStr = scanner.nextLine();
		int last = delStr.length()-1;
		
		inputStr.replace(delStr, "");
		
		for(int i=0; i<inputStr.length(); i++) {
			System.out.println("inputStr.charAt("+i+")"+inputStr.charAt(i));
			System.out.println(inputStr.charAt(i) == delStr.charAt(last));
			
			
			//�� ������ ���ڿ� ��
			if(inputStr.charAt(i) == delStr.charAt(last)) {
				
				
				System.out.println("hi"+ (i >= last && inputStr.substring(i-delStr.length()+1, i+1).equals(delStr)));
				
				
				//�������ڰ� ������ ���ڿ� ������ ��
				if(i >= last && inputStr.substring(i-delStr.length()+1, i+1).equals(delStr)) {
					
					inputStr = inputStr.substring(0, i-delStr.length()+1)+inputStr.substring(i+1, inputStr.length());
					i-=delStr.length();
				}
			}
		}
		if(inputStr.length()<=0)
			System.out.println("FRULA");
		else
			System.out.println(inputStr);

	}

}