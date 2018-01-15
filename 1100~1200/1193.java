//	BOJ - 1193
//	Algorithm - Find Pattern

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int min_range=1,max_range=1;
		int input = scn.nextInt();
		int cnt=2; // 분모 분자의 합
		int mother=0,son=0;
		while(true) {
			if(input>=min_range && input<=max_range) {
				if(cnt%2==0) { 	// 우상향 분모오름 분자내림
					mother = input-min_range+1;
					son = cnt - mother;
					System.out.print(son + "/" + mother);
					break;
				}
				else { 			// 좌하양 분모내림 분자오름
					son = input - min_range+1;
					mother = cnt - son;
					System.out.print(son + "/" + mother);
					break;
				}
			}
			cnt++;
			min_range = max_range + 1;
			max_range += cnt-1;
		}
	}
}
