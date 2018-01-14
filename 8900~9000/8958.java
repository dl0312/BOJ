//	BOJ - 8958
//	Algorithm - implement


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int tnum = scn.nextInt();
		String trash = scn.nextLine();
		for(int i=0;i<tnum;i++) {
			System.out.println(solution(scn.nextLine()));
		}
	}
	
	private static int solution(String str) {
		//boolean combo_flag = false;
		int combo = 0;
		int point = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='O') {
				point += ++combo;
			}
			else if(str.charAt(i)=='X') {
				combo = 0;
			}
		}
		return point;
	}
}
