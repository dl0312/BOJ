import java.util.Scanner;

// BOJ - 2156
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int n = scn.nextInt();
	       	int [] wine_bottle = new int [10010];
	       	int [] dp = new int [10010];
	       	for(int i=1;i<=n;i++) {
	       		wine_bottle[i] = scn.nextInt();
	       	}
	       	for(int i=1;i<3&&i<=n;i++) {
	       		if(i==1) dp[i] = wine_bottle[i];
	       		else dp[i] = wine_bottle[i] + wine_bottle[i-1];
	       	}
	       	for(int i=3;i<=n;i++) {
	       		int result = 0;
	       		result = Math.max(wine_bottle[i]+dp[i-2], dp[i-1]);
	       		result = Math.max(result,  wine_bottle[i] + wine_bottle[i-1] + dp[i-3]);
	       		dp[i] = result;
	       	}
	       	System.out.println(dp[n]);
	  }
}