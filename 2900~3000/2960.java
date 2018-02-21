import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 2960
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int target = scn.nextInt();
		int cnt = 0;
		boolean [] ary = new boolean [1001];
		for(int i=0;i<1001;i++) {
			ary[i] = false;
		}
		ary[1] = true;
		for(int i=2;i<=n/2;i++) {
			if(ary[i]==false) {
				for(int j=1;i*j<=n;j++) {
					if(j==1) {
						ary[i*j] = false;
						cnt++;
						if(cnt==target) {
							System.out.println(i*j);
						}
					}
					else if(ary[i*j]==true) {
						
					}
					else {
						ary[i*j] = true;
						cnt++;
						if(cnt==target) {
							System.out.println(i*j);
						}
					}
				}
			}
		}
		for(int i=n/2+1;i<=n;i++) {
			if(ary[i] == false) {
				cnt++;
				if(cnt==target) {
					System.out.println(i);
				}
			}
		}
		scn.close();
	}
}