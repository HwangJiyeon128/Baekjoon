package baekjoon;

import java.util.*;

public class baekjoon1173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //운동시간
		int m = sc.nextInt(); //시작맥박, 최소
		int M = sc.nextInt(); //최대
		int T = sc.nextInt(); //증가
		int R = sc.nextInt(); //감소
		int now = m, time = 0, check = 0;
		
		while(N > 0) {
			if(T+m>M)
				break;
			if(now+T <= M) { //운동
				now += T;
				N--;
				check = 0;
			}
			else if (now+T > M) { //휴식
				now -= R;
				check++;
			}
			
			if(now < m) {
				now = m;
			}
			time++;
			
//			if(check >= M )
//				break;
		}
		
		if(N > 0) {
			System.out.println("-1");
		}
		else
			System.out.println(time);
	}

}
