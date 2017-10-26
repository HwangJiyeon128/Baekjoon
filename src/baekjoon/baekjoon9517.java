package baekjoon;

/*
 * 아이 러브 크로아티아
 */
import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon9517 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int startPerson = scanner.nextInt();
		int questionNum = scanner.nextInt();
		int i = 0;

		ArrayList<PlayerAns> list = (ArrayList<PlayerAns>) new ArrayList();
		for (i = 0; i < questionNum; i++) {
			PlayerAns playerAns = new PlayerAns();
			playerAns.time = scanner.nextInt();
			String tmp_right = scanner.next();
			if (tmp_right.equals("T"))
				playerAns.right = true; 
			else	
				playerAns.right = false;
			list.add(playerAns);
		}
		
		
		int totalTime = 0, player = startPerson;
		for (i=0; i<list.size(); i++) {
			System.out.println("player.time: " + list.get(i).time + " player.right: " + list.get(i).right);
			totalTime += list.get(i).time;
			if(totalTime >= 210)
				break;
			if(list.get(i).right) {
				if(player>=8)
					player=1;
				else
					player++;
			}
			else {
				continue;
			}
			
		}
		System.out.println(player);
	}

	static class PlayerAns {
		int time;
		boolean right;
	}

}
