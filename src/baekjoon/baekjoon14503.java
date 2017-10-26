package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon14503 {

	static int N, M;
	static int[][] map, visit;
	static Robot robot;

	static class Robot {
		int y, x, type;

		Robot(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	static class Pair {
		int y, x;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		map = new int[N][M];
		visit = new int[N][M];

		String[] input2 = br.readLine().split(" ");
		int y = Integer.parseInt(input2[0]);
		int x = Integer.parseInt(input2[1]);
		int type = Integer.parseInt(input2[2]);
		robot = new Robot(y, x, type);
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		System.out.println(makeClean());
	}

	public static int makeClean() {
		int cnt = 1;
		int[] ch = { 3, 0, 1, 2 };
		int[][] find = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		int[][] back = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		int y = robot.y;
		int x = robot.x;
		int type = robot.type;
		boolean finish = false;
		int check = 0;
		visit[y][x] = 1;
//		System.out.println("start!! ("+y+", "+x+") type:"+type);
		while (!finish) {
			int nextY = y + find[type][0], nextX = x + find[type][1];
//			System.out.println("next ("+nextY+", "+nextX+")");
			if(nextY>=0 && nextX>=0 && nextY<N && nextX<M) {
				if(map[nextY][nextX]==0 && visit[nextY][nextX]==0) {
					type = ch[type];
					y = nextY;
					x = nextX;
					check = 0;
					cnt++;
					visit[nextY][nextX] = 1;
//					System.out.println("move!!" + " ("+nextY+", "+nextX+") type: "+type);
				} else {
					type = ch[type];
					check++;
//					System.out.println("turn..");
				}
			}
//			System.out.println("check --> "+check);
			if (check >= 4) {
				nextY = y + back[type][0];
				nextX = x + back[type][1];
//				System.out.println("back ("+nextY+", "+nextX+")");
				if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
					if (map[nextY][nextX] == 0) {
						y = nextY;
						x = nextX;
						check = 0;
//						System.out.println("back..");
					} else {
						finish = true;
					}
				}
			}
		}
		return cnt;
	}
}
