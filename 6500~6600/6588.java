import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 6588
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int f,s;
		int n;
		int cnt;
		boolean [] ary = new boolean [1000001];
		for(int i=0;i<1000001;i++) {
			ary[i] = false;
		}
		ary[1] = true;
		for(int i=2;i<=500000;i++) {
			if(ary[i]==false) {
				for(int j=2;i*j<=1000000;j++) {
					ary[i*j] = true;
				}
			}
		}
		while(true){
			n = scn.nextInt();
			if(n==0) break;
			f=0;
			s=n;
			f++;
			s--;
			while(true) {
				if(ary[f]==false && ary[s]==false) {
					break;
				}
				f++;
				s--;
			}
			System.out.println(n + " = " + f + " + " + s);
		}
		scn.close();
	}
}