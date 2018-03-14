import java.util.Arrays;
import java.util.Scanner;

// BOJ - 11053
// Algorithm - DP

public class Main{
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int [] array = new int [1010];
	       	int size = scn.nextInt();
	       	int [] dp = new int [1010];
	       	Arrays.fill(dp, 1);
	       	int max = 1;
	       	for(int idx=0;idx<size;idx++) {
	       		array[idx] = scn.nextInt();
	       	}
	       	for(int idx=1;idx<size;idx++) {
	       		for(int j=idx-1;j>=0;j--) {
	       			if(array[idx]>array[j]) {
	       				if(dp[idx]<dp[j]+1) {
	       					dp[idx] = dp[j]+1;
	       				}
	       			}
	       		}	
	       	}
	       	for(int i=0;i<size;i++) {
	       		if(max<dp[i]) {
	       			max = dp[i];
	       		}
	       	}
	       	System.out.println(max);
	       	scn.close();
	  }
}