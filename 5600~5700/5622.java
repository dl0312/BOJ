//	BOJ - 5622
//	Algorithm - ?

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int time=0;
		for(int i=0;i<str.length();i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'C') {
				time += 3;
			}
			else if('D' <= str.charAt(i) && str.charAt(i) <= 'F') {
				time += 4;
			}
			else if('G' <= str.charAt(i) && str.charAt(i) <= 'I') {
				time += 5;
			}
			else if('J' <= str.charAt(i) && str.charAt(i) <= 'L') {
				time += 6;
			}
			else if('M' <= str.charAt(i) && str.charAt(i) <= 'O') {
				time += 7;
			}
			else if('P' <= str.charAt(i) && str.charAt(i) <= 'S') {
				time += 8;
			}
			else if('T' <= str.charAt(i) && str.charAt(i) <= 'V') {
				time += 9;
			}
			else if('W' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				time += 10;
			}
		}
		System.out.print(time);
	}
}
