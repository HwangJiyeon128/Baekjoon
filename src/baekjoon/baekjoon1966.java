package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class baekjoon1966 {

	static class Text {
		int num, val;
		Text(int num, int val) {
			this.num = num;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), test = 0;
		while(test++ < T) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);//문서의 개수
			int M = Integer.parseInt(input[1]);//알고싶은 문서번호
			String[] input2 = br.readLine().split(" ");
			Queue<Text> text = new LinkedList<Text>();
			for(int i=0; i<N; i++) {
				text.add(new Text(i, Integer.parseInt(input2[i])));
			}
			
			int answer = 0;
			while(!text.isEmpty()) {
				answer++;
				int maxVal = 0;
				for(Text t: text) {
					if(t.val > maxVal) {
						maxVal = t.val;
					}
				}
				for(int i=0; i<text.size(); i++) {
					Text x = text.poll();
					if(x.val == maxVal) {
//						System.out.println("print ("+x.num+")"+", val is "+x.val);
						if(x.num == M)
							System.out.println(answer);
						break;
					}
					else
						text.add(x);
				}
			}
		}
	}

}
