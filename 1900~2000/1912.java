import java.util.Arrays;
import java.util.Scanner;

// BOJ - 1912
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int[] array = new int [100010];
	       	int[] dp = new int [100010];
	       	int length_of_array = scn.nextInt();
	       	for(int idx=1;idx<=length_of_array;idx++) {
	       		array[idx] = scn.nextInt();
	       	}
	       	for(int idx=1;idx<=length_of_array;idx++) {
	       		dp[idx] = array[idx];
	       		if(idx==1){
	       			continue;
	       		}
	       		if(array[idx]<dp[idx-1]+array[idx]){
	       		
	       			dp[idx] = dp[idx-1] + array[idx];
	       		}
	       	}
	  		int result = dp[1];
	  		for(int idx=1;idx<=length_of_array;idx++) {
	  			if(result<dp[idx]) result = dp[idx];
	  		}
	       	System.out.println(result);
	  }
}