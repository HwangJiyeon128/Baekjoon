package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1094 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int len = 64, sum = 64, cnt = 1, shortbar = len/2;
		int[] bar = new int[64];
		
		while(X != sum) {
			
			if(X <= sum) {
				
				bar[--cnt] = shortbar;
				bar[++cnt] = shortbar;
				int tmpsum = 0;
				for(int i=0; i<cnt; i++) {
					tmpsum += bar[i];
				}
				System.out.println("tmpsum: "+tmpsum);
				if(X <= tmpsum) {
					bar[cnt] = 0;
				}
				else
					cnt++;
			}
			sum = 0;
			for(int i=0; i<cnt; i++) {
				sum += bar[i];
			}
			System.out.println("sum "+sum);
			shortbar = shortbar/2;
		}
		System.out.println(cnt);
	}

}
