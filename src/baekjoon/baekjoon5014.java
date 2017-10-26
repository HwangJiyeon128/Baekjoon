package baekjoon;

/*
 * ��ŸƮ ��ũ
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class baekjoon5014 {

	static int F, S, G, U, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		F = Integer.parseInt(input[0]);//�� �ǹ� �� ��
		S = Integer.parseInt(input[1]);//���� ��ġ
		G = Integer.parseInt(input[2]);//���� �����ϴ°�?
		U = Integer.parseInt(input[3]);//����
		D = Integer.parseInt(input[4]);//�Ʒ�
		
		System.out.println(bfs());
	}

	public static String bfs() {
		int result = 0;
		int[] floor = new int[F+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		floor[S] = 1;
			
		
		while(!queue.isEmpty()) {
			int nextF = queue.poll();
			if(nextF == G)
				return Integer.toString(result);
			else if(nextF > G)
				nextF -= D;
			else if(nextF < G)
				nextF +=U;
			
			if(nextF<0)
				nextF = nextF+(D+U);
			else if(nextF>F)
				nextF = nextF-(D+U);
			
			if(floor[nextF]==1)
				break;
			
			floor[nextF] = 1;
			queue.add(nextF);
			result++;
		}
		return "use the stairs";
	}
}
