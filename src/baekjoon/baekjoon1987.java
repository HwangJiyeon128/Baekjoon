package baekjoon;

import java.util.*;

public class baekjoon1987 {

	static char[][] data;
	static boolean[][] check;
	static int max = 0;
	static String val = "";
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int R = scanner.nextInt(), C = scanner.nextInt();
		data = new char[R][C];
		check = new boolean[R][C];
		int i, j;

		for (i = 0; i < R; i++) {
			String tmp_str = scanner.next();
			for (j = 0; j < C; j++) {
				data[i][j] = tmp_str.charAt(j);
				check[i][j] = false;
			}

		}

		check[0][0] = true;
		System.out.println(DFS(0, 0, 1, C, R));
	}

	public static int DFS(int a, int b, int cnt, int width, int height) {
		int nextA = a, nextB = b;
		System.out.println("a: " + a + " b: " + b);

		String tmp_val = Character.toString(data[a][b]);
		if (val.contains(tmp_val))
			return cnt;
		val += tmp_val;

		System.out.println("hello " + cnt);
		System.out.println("data[a][b]: " + data[a][b] + " val: " + val);
		for (int i = 0; i < 4; i++) {
			nextA = a + dy[i];
			nextB = b + dx[i];
			System.out.println("nextA: " + nextA + " nextB: " + nextB);
			if ((nextB < width) && (nextA < height) && (nextB >= 0) && (nextA >= 0)
					&& !val.contains(Character.toString(data[nextA][nextB]))) {
				if (!check[nextA][nextB]) {
					cnt++;
					max = DFS(nextA, nextB, cnt, width, height);
					check[nextA][nextB] = true;
				}
			}
			if (cnt < max)
				cnt = max;
		}
		return cnt;

	}
}
