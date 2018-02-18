import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 9020
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int f,s;
		int n;
		int cnt;
		boolean [] ary = new boolean [10001];
		for(int i=0;i<10001;i++) {
			ary[i] = false;
		}
		ary[1] = true;
		for(int i=2;i<=5000;i++) {
			for(int j=2;i*j<=10000;j++) {
				ary[i*j] = true;
			}
		}
		for(int k=0;k<t;k++){
			n = scn.nextInt();
			s = f = n/2;
			while(true) {
				if(ary[f]==false && ary[s]==false) {
					break;
				}
				f--;
				s++;
			}
			System.out.println(f + " " + s);
		}
		scn.close();
	}
}