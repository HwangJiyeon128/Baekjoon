package baekjoon;

import java.util.*;

public class baekjoon1173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //��ð�
		int m = sc.nextInt(); //���۸ƹ�, �ּ�
		int M = sc.nextInt(); //�ִ�
		int T = sc.nextInt(); //����
		int R = sc.nextInt(); //����
		int now = m, time = 0, check = 0;
		
		while(N > 0) {
			if(T+m>M)
				break;
			if(now+T <= M) { //�
				now += T;
				N--;
				check = 0;
			}
			else if (now+T > M) { //�޽�
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
