package baekjoon;

/*
 * 체스판 다시 칠하기
 */

import java.util.*;

public class baekjoon1018 {

	static int[][] board;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt(), N = scanner.nextInt();
		board = new int[M][N];
		int[][] check = new int[M-7][N-7];
		
		for(int i=0; i<M; i++) {
			String input = scanner.next();
			for(int j=0; j<N; j++) {
				char inputChar;
				inputChar = input.charAt(j);
				if(inputChar=='W')
					board[i][j] = 0;
				else
					board[i][j] = 1;
			}
		}
		
		for(int i=0; i<M-7; i++) {
			for(int j=0; j<N-7; j++) {
				check[i][j] = changeBlock(i, j);
			}
		}
		
		for(int i=0; i<M-7; i++) {
			for(int j=0; j<N-7; j++)
				System.out.print(check[i][j]+" ");
			System.out.println();
		}
		
		int min=10000;
		for(int a=0; a<M-7; a++) {
			for(int b=0; b<N-7; b++) {
				if(check[a][b] < min)
					min = check[a][b];
			}
		}
		System.out.println(min);
	}
	
	public static int changeBlock(int startY, int startX) {
		int whiteCheck = 0, blackCheck = 0;
		int endY = startY+7, endX = startX+7;
		int val = startX%2;
		
		//white
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(j%2 == val) {
					if(board[i][j] == 1) {
						whiteCheck++;
					}
				}
				else {
					if(board[i][j] == 0) {
						whiteCheck++;
					}
				}
			}
			if(val > 0)
				val = 0;
			else
				val = 1;
		}
		
		//black
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(j%2 == val) {
					if(board[i][j] == 0) {
						blackCheck++;
					}
				}
				else {
					if(board[i][j] == 1) {
						blackCheck++;
					}
				}
			}
			if(val > 0)
				val = 0;
			else
				val = 1;
		}
		if(whiteCheck > blackCheck)
			return blackCheck;
		else
			return whiteCheck;
	}

}
