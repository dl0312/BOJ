import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 1475
//	Algorithm - Find a rule

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int max_cnt=0;
		int [] digit_count = new int [10];
		String str = Integer.toString(n);
		int [] digit_ary = new int [str.length()];
		for(int i=0;i<str.length();i++) {
			digit_ary[i] = Character.digit(str.charAt(i), 10);
		}
		for(int i=0;i<10;i++) {
			digit_count[i] = 0;
		}
		for(int i=0;i<digit_ary.length;i++){
			digit_count[digit_ary[i]]++;
		}
		digit_count[6] += digit_count[9];
		for(int i=0;i<9;i++) {
			if(i!=6 && digit_count[i]>max_cnt) {
				max_cnt = digit_count[i];
			}
			else if(i==6 && (digit_count[i]/2+digit_count[i]%2)>max_cnt) {
				max_cnt =  (digit_count[i]/2+digit_count[i]%2);
			}
		}
		System.out.println(max_cnt);
		scn.close();
	}
}