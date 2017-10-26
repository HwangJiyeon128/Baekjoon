 package baekjoon;

/*
 * 문자열 폭발
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
			
			
			//맨 마지막 글자와 비교
			if(inputStr.charAt(i) == delStr.charAt(last)) {
				
				
				System.out.println("hi"+ (i >= last && inputStr.substring(i-delStr.length()+1, i+1).equals(delStr)));
				
				
				//이전글자가 삭제할 글자와 같은지 비교
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