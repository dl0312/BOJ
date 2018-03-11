import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ - 11726
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner scn = new Scanner(System.in);
	        int width = scn.nextInt();	// width
	        long [] dp = new long [width+1];
	        dp[0] = 1;
	        for(int i=0;i<width-1;i++) {
	        	dp[i+1] += dp[i]%10007;
	        	dp[i+2] += dp[i]%10007;
	        }
	        dp[width] += dp[width-1]%10007;
	        System.out.println(dp[width]%10007);
	  }
}