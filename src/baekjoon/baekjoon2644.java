package baekjoon;

/*
 * ÃÌ¼ö°è»ê
 */

import java.util.*;

public class baekjoon2644 {

	static int[][] data;
	static int[][] check;
	static int result, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		data = new int[n + 1][n + 1];
		check = new int[n + 1][n + 1];
		int start = sc.nextInt(), end = sc.nextInt();
		int m = sc.nextInt();
		result = -1;

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			if((x==start && y==end) || (y==start && x==end)) { //1ÃÌ
				result = 1;
			}
			data[x][y] = data[y][x] = 1;
		}
		if (start == end) { //0ÃÌ
			result = 0;
		} 
		else if(result<0){
			for (int i = 1; i < n + 1; i++) { //2ÃÌ ÀÌ»ó
				if (data[i][start] == 1)
					bfs(i, start, end);
			}
		}

		System.out.println(result);
	}

	public static void bfs(int point, int start, int end) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int tmp = 1;

		check[point][start] = check[start][point] = 1;
		qy.add(point);
		qx.add(start);

		while (!qx.isEmpty() && !qy.isEmpty()) {
			int x = qx.poll(), y = qy.poll();

			for (int i = 1; i < n + 1; i++) {
				if (data[i][y] == 1 && check[i][y] == 0) {
					qy.add(i);
					qx.add(y);
					check[i][y] = 1;
					tmp++;
					if (i == end) {
						tmp -= qx.size() - 1;
						result = tmp;
						qx.clear(); qy.clear(); break;
					}

				}
			}
			
		}
	}

}
