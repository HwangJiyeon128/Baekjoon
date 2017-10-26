package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon14888_2 {

	static int N, max = -999999999, min = 999999999;
	static int[] numList, opList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numList = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			numList[i] = Integer.parseInt(input[i]);
		}
		//0:+, 1:-, 2:*, 3:/
		opList = new int[4];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			opList[i] = Integer.parseInt(input2[i]);
		}
		
		solve(numList[0], 0, 0, 0, 0, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void solve(int num, int step, int plus, int minus, int mul, int div) {
		if(step == N-1) {
			if(num > max)
				max = num;
			if(num < min)
				min = num;
			return;
		}
		if(plus < opList[0])
			solve(num + numList[step+1],step+1, plus+1, minus, mul, div);
		if(minus < opList[1])
			solve(num - numList[step+1],step+1, plus, minus+1, mul, div);
		if(mul < opList[2])
			solve(num * numList[step+1],step+1, plus, minus, mul+1, div);
		if(div < opList[3])
			solve(num / numList[step+1],step+1, plus, minus, mul, div+1);
	}

}
