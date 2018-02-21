import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 1978
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
		int n = scn.nextInt();
		int prime_num = 0;
		for(int i=0;i<n;i++) {
			if(is_prime(scn.nextInt())==true){
				prime_num++;
			}
		}
		System.out.println(prime_num);
		scn.close();
	}
}