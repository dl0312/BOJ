import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 2775
//	Algorithm - Find a rule

public class Main {
	public static int people_num(int floor, int room) {
		int people=0;
		if(floor==0) {
			return room;
		}
		for(int i=1;i<=room;i++) {
			people += people_num(floor-1,i);
		}
		return people;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test_num = scn.nextInt();
		int k,n;
		for(int i=0;i<test_num;i++) {
			k = scn.nextInt();
			n = scn.nextInt();
			System.out.println(people_num(k,n));
		}
		scn.close();
	}
}