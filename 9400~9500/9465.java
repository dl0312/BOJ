import java.util.Arrays;
import java.util.Scanner;

// BOJ - 9465
// Algorithm - DP

public class Main{
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int test_case = scn.nextInt();
	       	for(int case_num=0;case_num<test_case;case_num++) {
	       		int [][] sticker = new int [2][100010];
	       		int [] dp  = new int [200020];
	       		int length = scn.nextInt();
	       		for(int x=0;x<2;x++) {
	       			for(int y=0;y<length;y++) {
	       				sticker[x][y] = scn.nextInt();
	       			}
	       		}
       			dp[0] = 0;
       			dp[1] = sticker[0][0];
	       		dp[2] = sticker[1][0];
	       		for(int idx=3;idx<=length*2;idx++) {
	       			if(idx%2==1) {
		       			dp[idx] = Math.max(dp[idx-1], dp[idx-3]) + sticker[(idx%2+1)%2][idx/2];	
	       			}
	       			else if(idx%2==0){
	       				if(idx<5) {
		       				dp[idx] = dp[idx-3] + sticker[(idx%2+1)%2][idx/2-1];
	       				}
	       				else {
	       					dp[idx] = Math.max(dp[idx-3], dp[idx-5]) + sticker[(idx%2+1)%2][idx/2-1];
	       				}
	       			}
	       				
	       		}
	       		int result = 0;
	       		for(int i=1;i<=length*2;i++) {
	       			if(result<dp[i]) {
	       				result = dp[i];
	       			}
	       		}
	       		for(int i=1;i<=length*2;i++) {
	       			System.out.print(dp[i] + " ");
	       		}
	       		System.out.println(result);
	       	}
	       	scn.close();
	  }
}