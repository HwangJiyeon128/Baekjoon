package baekjoon;

/*
 * ���̾�
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.IOException;

public class baekjoon5622 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		HashMap <String,Integer> map = new HashMap<String, Integer>();
		map.put("A", 2); map.put("B", 2); map.put("C", 2);
		map.put("D", 3); map.put("E", 3); map.put("F", 3);
		map.put("G", 4); map.put("H", 4); map.put("I", 4);
		map.put("J", 5); map.put("K", 5); map.put("L", 5);
		map.put("M", 6); map.put("N", 6); map.put("O", 6);
		map.put("P", 7); map.put("Q", 7); map.put("R", 7); map.put("S", 7);
		map.put("T", 8); map.put("U", 8); map.put("V", 8);
		map.put("W", 9); map.put("X", 9); map.put("Y", 9); map.put("Z", 9);
		
		int result = 0;
		for(int i=0; i<input.length(); i++) {
			String tmp = Character.toString(input.charAt(i));
			result += map.get(tmp)+1;
		}	
		System.out.println(result);
	}
}
