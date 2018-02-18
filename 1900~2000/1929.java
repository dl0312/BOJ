import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 1929
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int f,s;
		boolean [] ary = new boolean [1000001];
		for(int i=0;i<1000001;i++) {
			ary[i] = false;
		}
		int min_prime = -1;
		int sum_prime = 0;
		boolean flag = false;
		ary[1] = true;
		f = scn.nextInt();
		s = scn.nextInt();
		for(int i=2;i<=s/2;i++) {
			for(int j=2;i*j<=s;j++) {
				ary[i*j] = true;
			}
		}
		for(int i=f;i<=s;i++) {
			if(ary[i]==false) {
				System.out.println(i);
			}
		}
		scn.close();
	}
}