//	BOJ - 14889
//	Algorithm - ?
//	Samsung SW

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int [][] synergy_ad;
	
	public int total_synergy( int [] team) {
		int synergy = 0;
		for(int i=0;i<team.length;i++) {
			for(int j=i+1;j<team.length;j++) {
				synergy += synergy_ad[team[i]][team[j]];
				synergy += synergy_ad[team[j]][team[i]];
			}
		}
		return synergy;
	}
	
	public void split_team( int [] total){
		int [] start = new int[total.length/2];
		int [] link = new int[total.length/2];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int people_num = 0;
		int [] total;
		Scanner scn = new Scanner(System.in);
		people_num = scn.nextInt();
		total = new int [people_num+1];
		synergy_ad = new int [people_num][people_num];
		for(int i=0;i<people_num;i++) {
			for(int j=0;j<people_num;j++) {
				synergy_ad[i][j] = scn.nextInt();
			}
		}
	}
}