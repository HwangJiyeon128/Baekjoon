package baekjoon;

/*
 * ������ ��
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
		
		//startNum: ���ϱ� �����ϴ� ����, sum: ����, nextL: ����
		int startNum = N/L, sum = 0, nextL = L;
		
		while(sum!=N && nextL<=100 && startNum>=0) {
			
			//�� �� ���ϱ�
			sum = 0;
			for(int i=0; i<nextL; i++) {
				sum+=startNum++;
			}
			//������ ������ ���Ϸ��� ���� ����
			if(sum<N) {
				nextL++;
				startNum = N/nextL;
			}
			//������ ũ�� ���ۼ��� ���̱�
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
