import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ - 2193
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();	//	length of pinary number
	        long [] dp = new long [n+1];
	        Arrays.fill(dp, 0);
	        dp[1] = 1;
	        for(int i=1;i<n-1;i++) {
	        	dp[i+2] += dp[i];
	        	dp[i+1] += dp[i];	
	        }
	        dp[n] += dp[n-1];
	        System.out.println(dp[n]);
	  }
}