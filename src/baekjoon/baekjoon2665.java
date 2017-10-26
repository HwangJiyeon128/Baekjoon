package baekjoon;

/*
 * 미로만들기
 */

import java.util.Scanner;

public class baekjoon2665 {

	static Scanner scanner;
	static int[][] dataArray;
	static boolean[][] checkArray;
	static int size, i, j;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		size = scanner.nextInt();
		dataArray = new int[size][size];
		checkArray = new boolean[size][size];

		for(i=0; i<size; i++) {
			String str = scanner.next();
			String[] data = str.split("");
			for(j=0; j<size; j++) {
				dataArray[i][j] = Integer.parseInt(data[j]);
				checkArray[i][j] = false;
			}
		}
		
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				System.out.print(dataArray[i][j]+" ");
			}
			System.out.println();
		}
		
		checkArray[0][0] = true;
		System.out.println(maze(0, 0, size, 0));
	}

	public static int maze(int startX, int startY, int size, int pre_count) {
		int nextX = startX, nextY = startY, count = pre_count;
		
		//바닥조건
		if(startX==size-1 && startY==size-1)
			return count;
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				System.out.print(dataArray[i][j]+" ");
			}
			System.out.println();
		}
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				System.out.print(checkArray[i][j]+"	");
			}
			System.out.println();
		}
		
		if(startY<size-1 && dataArray[startX][startY+1]==1 && !checkArray[startX][startY+1]) {
			System.out.println("here1");
			nextY = startY+1;
			checkArray[startX][startY+1] = true;
		}
		else if(startX<size-1 && dataArray[startX+1][startY]==1 && !checkArray[startX+1][startY]) {
			System.out.println("here2");
			nextX = startX+1;
			checkArray[startX+1][startY] = true;
		}
		else if(startY>0 && dataArray[startX][startY-1]==1 && !checkArray[startX][startY-1]) {
			System.out.println("here3");
			nextY = startY-1;
			checkArray[startX][startY-1] = true;
		}
		else if(startX>0 && dataArray[startX-1][startY]==1 && !checkArray[startX-1][startY]) {
			System.out.println("here4");
			nextX = startX-1;
			checkArray[startX-1][startY] = true;
		}
		else {
			System.out.println("here5");
			if(nextX < size-1) {
				dataArray[startX+1][startY] = 1;
				nextX = startX+1;
			}
			else if(nextY < size-1) {
				dataArray[startX][startY] = 1;
				nextY = startY+1;
			}
			
			count++;
		}
		
		System.out.println("count is "+count);
		System.out.println("nextX is "+nextX+" nextY is "+nextY);
		return maze(nextX, nextY, size, count);
	}
}
