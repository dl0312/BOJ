//	BOJ - 2920
//	Algorithm - implement


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int [] melody = new int [8];
		int state = 0;
		for(int i=0;i<8;i++) {
			melody[i] = scn.nextInt();
		}
		if(melody[0]<melody[1]) state = 1;
		else if(melody[0]>melody[1]) state = -1;
		for(int i=1;i<8;i++) {
			if( state == 1 && melody[i-1] > melody[i]) state = 0;
			else if( state == -1 && melody[i-1] < melody[i]) state = 0;
		}
		if(state==1) System.out.print("ascending");
		else if(state==-1) System.out.print("descending");
		else if(state==0) System.out.print("mixed");
	}
}
