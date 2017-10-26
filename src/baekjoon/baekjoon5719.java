package baekjoon;

/*
 * 거의 최단 경로
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon5719 {

	static int[][] data;
	static boolean delCheck, dikstraCheck=true;
	static int shortPath=10000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int point, path, startPoint, endPoint, i, j;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			point = scanner.nextInt();
			path = scanner.nextInt();
			if (point == 0 && path == 0)
				break;

			delCheck = true;
			startPoint = scanner.nextInt();
			endPoint = scanner.nextInt();
			data = new int[point][point];
			for (i = 0; i < point; i++) {
				for (j = 0; j < point; j++)
					data[i][j] = 10000;
			}
			for (i = 0; i < path; i++) {
				int point1, point2, value;
				point1 = scanner.nextInt();
				point2 = scanner.nextInt();
				value = scanner.nextInt();
				data[point1][point2] = value;
			}

			while(dikstraCheck) {
				dikstra(data, point, path, startPoint, endPoint);
				
			}
		}
	}

	public static void dikstra(int[][] data, int point, int path, int startPoint, int endPoint) {
		boolean[] isVisit = new boolean[point];
		int[] distance = new int[point];
		int[] history = new int[point];

		int next = startPoint;
		int min = 0, i, j;

		for (i = 0; i < point; i++) {
			isVisit[i] = false;
			distance[i] = 9999;
			history[i] = 9999;
		}
		distance[startPoint] = 0;

		while (true) {
			min = 9999;
			for (j = 0; j < point; j++) {
				if (isVisit[j] == false && distance[j] < min) {
					next = j;
					min = distance[j];
				}
			}
			if (min == 9999) {
				break;
			}
			isVisit[next] = true;

			for (j = 0; j < point; j++) {
				int tmp_distance = distance[next] + data[next][j];
				if (distance[j] > tmp_distance) {
					distance[j] = tmp_distance;
					history[j] = next;
				}
			}
		}

		if (distance[endPoint]<9999)
			System.out.println(distance[endPoint]);
		else {
			System.out.println("-1");
			dikstraCheck = false;
			return ;
		}
		
		
		
		if(shortPath >= distance[endPoint]) {
			shortPath = distance[endPoint];
			delCheck = true;
		}
		else {
			delCheck = false;
			dikstraCheck = false;
		}
		printPath(history, startPoint, endPoint, point);
	}

	public static void printPath(int[] history, int startPoint, int endPoint, int point) {
		Stack<Integer> path = new Stack<Integer>();
		int position = endPoint, i = 0;
		int[] delPoint = new int[point];
		while (true) {
			path.push(position);
			if (position == startPoint)
				break;
			position = history[position];
		}

		while (!path.isEmpty()) {
			int prePosition = path.pop();
			delPoint[i++] = prePosition;
		}
		while (delCheck) {
			for (i = 0; i < delPoint.length - 1; i++) {
				data[delPoint[i]][delPoint[i + 1]] = 10000;
			}
			delCheck = false;
		}
	}

}
