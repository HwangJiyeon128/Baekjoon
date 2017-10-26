package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon14888 {

	static int N, max = -999999999, min = 999999999;
	static int[] numList, opList, opArr;
	
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
		opArr = new int[N-1];
		int index = 0;
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			opList[i] = Integer.parseInt(input2[i]);
			for(int j=0; j<opList[i]; j++) {
				opArr[index++] = i;
			}
		}
		for(int x: opArr) {
			System.out.print(x+" ");
		}
		Operate();
		while(next_Permutation()) {
			Operate();
		}
//		System.out.println("max: "+max+", min: "+min);
		System.out.println(max);
		System.out.println(min);
	}

	public static boolean next_Permutation() {
		int i=opArr.length-1;
		while(i>0 && opArr[i-1] >= opArr[i]) {
			i -= 1;
		}
		if(i <= 0)
			return false;
		
		int j = opArr.length-1;
		while(opArr[j] <= opArr[i-1]) {
			j -= 1;
		}
		
		int temp = opArr[i-1];
		opArr[i-1] = opArr[j];
		opArr[j] = temp;
		
		j = opArr.length-1;
		while(i < j) {
			temp = opArr[i];
			opArr[i] = opArr[j];
			opArr[j] = temp;
			i += 1;
			j -= 1;
		}
		for(int x: opArr) {
			System.out.print(x+" ");
		}
		return true;
	}
	
	public static void Operate() {
		int cal = numList[0];
		for(int i=1; i<N; i++) {
			int op = opArr[i-1];
			if(op==0) {
				cal += numList[i];
			}
			else if(op==1) {
				cal -= numList[i];
			}
			else if(op==2) {
				cal *= numList[i];
			}
			else if(op==3) {
				cal /= numList[i];
			}
		}
		System.out.println(" "+cal);
		if(cal > max) {
			max = cal;
		}
		if(cal < min) {
			min = cal;
		}
	}
}
