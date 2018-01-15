//	BOJ - 2292
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
		int input = scn.nextInt();
		int min_range=1, max_range=1;
		int cnt=1;
		while(true) {
			if(input>=min_range && input<=max_range) {
				System.out.print(cnt);
				break;
			}
			min_range = max_range + 1;
			max_range += 6*cnt;
			cnt++;
		}
	}
}
