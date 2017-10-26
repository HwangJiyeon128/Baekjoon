package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1547 {
	
	static class Cup {
		int num;
		Cup(int num) {
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		Cup[] cup = new Cup[3];
		for(int i=1; i<=3; i++) {
			cup[i-1] = new Cup(i);
		}
		
		while(M-- > 0) {
			String[] input = br.readLine().split(" ");
			int cup1 = Integer.parseInt(input[0]);
			int cup2 = Integer.parseInt(input[1]);
			int index1 = 0, index2 = 0;
			
			for(int i=0; i<3; i++) {
				if(cup[i].num==cup1)
					index1 = i;
				else if(cup[i].num==cup2)
					index2 = i;
			}
			
			int tmp = cup[index1].num;
			cup[index1].num = cup[index2].num;
			cup[index2].num = tmp;
		}
		
		System.out.println(cup[0].num);
	}

}
