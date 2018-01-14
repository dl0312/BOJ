//	BOJ - 10039
//	Algorithm - implement


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int [] grade = new int [5];
		int total=0;
		for(int i=0;i<5;i++) {
			grade[i] = scn.nextInt();
			if(grade[i]<40) grade[i] = 40;
			total += grade[i];
		}
		System.out.print(total/5);
	}
}
