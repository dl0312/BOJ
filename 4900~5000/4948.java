import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 4948
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int f,s;
		int cnt;
		boolean [] ary = new boolean [1000001];
		ary[1] = true;
		while(true) {
			cnt = 0;
			for(int i=0;i<1000001;i++) {
				ary[i] = false;
			}
			f = scn.nextInt();
			if(f==0) break;
			s = 2*f;
			for(int i=2;i<=s/2;i++) {
				for(int j=2;i*j<=s;j++) {
					ary[i*j] = true;
				}
			}
			for(int i=f+1;i<=s;i++) {
				if(ary[i]==false) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		scn.close();
	}
}