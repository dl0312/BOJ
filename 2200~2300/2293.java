import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ - 2293
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int k = scn.nextInt();
	        int [] coin_ary = new int [n];
	        
	        for(int i=0;i<n;i++) {
	        	coin_ary[i] = scn.nextInt();
	        }
	        Arrays.sort(coin_ary);
	        int [] dp = new int [k+1];
	        dp[0] = 1;
	        
	        for(int i=0;i<n;i++) {
	        	for(int j=coin_ary[i];j<=k;j++) {
	        		dp[j] += dp[j-coin_ary[i]];
	        	}
	        }
	        
	        System.out.println(dp[k]);
	  }
}