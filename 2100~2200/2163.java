import java.util.Arrays;
import java.util.Scanner;

// BOJ - 2163
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int n = scn.nextInt();
	       	int m = scn.nextInt();
	       	int [][] dp = new int [301][301];
	       	dp[1][1] = 0;
	       	for(int i=1;i<301;i++) {
	       		for(int j=1;j<301;j++) {
	       			dp[i][j] = i*j-1;
	       		}
	       	}
	       	System.out.print(dp[n][m]);
	  }
}