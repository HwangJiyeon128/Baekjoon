package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int kim = Integer.parseInt(input[1]);
		int lim = Integer.parseInt(input[2]);
		int[][] player = new int[N][2];
		for(int i=0; i<N; i++) {
			player[i][0] = i+1;
			if(i+1==kim || i+1==lim)
				player[i][1] = 1;
		}
		
		int round=0, num=(N+1)/2+(N%2), check=0;
		while(num>1) {
			round++; check=0;
			for(int i=0; i<N; i++) {
				if(player[i][1]==1) {//kim, lim
					player[i][1]=0;
					player[(i+1)/2+((i+1)%2)-1][1]=1;
					check++;
				}
				if(i>=num)//delete
					player[i][0] = 0;
			}
			if(check<2) { //중간에 만났을때
				round--;
				break;
			}
			num=(num)/2+(num%2);
		}
		if(num==1 && player[1][1]==1)
			round++;
		System.out.println(round);
	}

}
