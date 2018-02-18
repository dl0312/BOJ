import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 2581
//	Algorithm - prime number

public class Main {
	static int n;
	
	public static boolean is_prime(int num) {
		int cnt = 0;
		for(int i=1;i<num;i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		if(cnt==1) return true;
		else return false;
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int f,s;
		int min_prime = -1;
		int sum_prime = 0;
		boolean flag = false;
		f = scn.nextInt();
		s = scn.nextInt();
		
		for(int i=f;i<=s;i++) {
			if(is_prime(i)==true){
				if(flag==false) {
					min_prime = i;
					flag = true;
				}
				sum_prime += i;
			}
		}
		if(min_prime==-1) {
			System.out.println(min_prime);
		}
		else {
			System.out.println(sum_prime);
			System.out.println(min_prime);
		}
		scn.close();
	}
}