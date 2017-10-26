package baekjoon;

/*
 * 수열의 합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1024 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		
		//startNum: 더하기 시작하는 숫자, sum: 총합, nextL: 길이
		int startNum = N/L, sum = 0, nextL = L;
		
		while(sum!=N && nextL<=100 && startNum>=0) {
			
			//총 합 구하기
			sum = 0;
			for(int i=0; i<nextL; i++) {
				sum+=startNum++;
			}
			//총합이 작으면 구하려는 길이 증가
			if(sum<N) {
				nextL++;
				startNum = N/nextL;
			}
			//총합이 크면 시작숫자 줄이기
			else {
				startNum = startNum-nextL-1;
			}
		}
		startNum++;
		if(sum == N) {
			for(int i=0; i<nextL; i++) {
				System.out.print(startNum+i +" ");
			}
		}
		else
			System.out.println("-1");
	}

}
