package baekjoon;

/*
 * º¸¹°¼¶
 */

import java.util.*;
public class baekjoon2589 {

	static int[][] data;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		data = new int[height][width];
		visit = new boolean[width];
		
		for(int i=0; i<height; i++) {
			String tmp = scanner.next();
			for(int j=0; j<width; j++) {
				if(tmp.charAt(j)=='L')
					data[i][j] = 1;
				else
					data[i][j] = 0;
			}
		}
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println("");
		}
		bfs(0, 0, height, width, 0);
		//System.out.println(treasure(0, 0, height, width, 0));
	}
	
	static void bfs(int a, int b, int height, int width, int point) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(point);
		visit[point] = true;
		int nextA = a, nextB = b;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp+" ");
			
			nextA = a; nextB = b;
			int[] x = new int[] {0, 0, -1, 1};
			int[] y = new int[] {-1, 1, 0, 0};
			
			
			
			for(int i=0; i<4; i++) {
				nextA = a+x[i];
				nextB = b+y[i];
				if((nextB<width) && (nextA<height) && (nextB>=0) && (nextA>=0) && data[nextA][nextB]==1) {
					//q.add()
				}
					
			}
			
			return ;
		}
	}
	
	
	
	public static int treasure(int a, int b, int height, int width, int cnt) {
		int nextA = a, nextB = b, nextCnt = cnt,comCnt = 0, resultCnt = cnt;
		int[] q = new int[] {0, 0, -1, 1};
		int[] w = new int[] {-1, 1, 0, 0};
		
		data[a][b] = 0;
		
		
		for(int i=0; i<4; i++) {
			nextA = a+q[i];
			nextB = b+w[i];
			System.out.println("nextA is "+nextA+", nextB is "+nextB);
			if((nextA<height) && (nextB<width) && (nextB>=0) && (nextA>=0) && data[nextA][nextB]==1) {
				System.out.println("nextA is "+nextA+", nextB is "+nextB+", data[nextA][nextB]: "+data[nextA][nextB]);
				System.out.println("nextCnt is "+nextCnt);
				comCnt = treasure(nextA, nextB, width, height, ++nextCnt);
				System.out.println("comCnt is "+comCnt);
				if(comCnt>resultCnt)
					resultCnt = comCnt;
			}
			//return resultCnt;
		}
		
		return resultCnt;
		
	}

}
