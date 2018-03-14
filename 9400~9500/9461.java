import java.util.Arrays;
import java.util.Scanner;

// BOJ - 9461
// Algorithm - DP

public class Main{
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int test_case = scn.nextInt();
	       	long [] wave = new long [110];
	       	wave[1] = 1;
	       	wave[2] = 1;
	       	wave[3] = 1;
	       	wave[4] = 2;
	       	wave[5] = 2;
	       	for(int idx=6;idx<110;idx++) {
	       		wave[idx] = wave[idx-1] + wave[idx-5];
	       	}
	       	for(int case_num=0;case_num<test_case;case_num++) {
	       		System.out.println(wave[scn.nextInt()]);
	       	}
	       	scn.close();
	  }
}