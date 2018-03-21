import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

// BOJ - 10844
// Algorithm - DP

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [][] dp = new int [101][10];
        Arrays.fill(dp[1],1);
        dp[1][0] = 0;
        for(int i=1;i<n;i++){
            dp[i+1][0] = (dp[i][1]) % 1000000000;
            dp[i+1][1] = (dp[i][0] + dp[i][2])% 1000000000;
            dp[i+1][2] = (dp[i][1] + dp[i][3])% 1000000000;
            dp[i+1][3] = (dp[i][2] + dp[i][4])% 1000000000;
            dp[i+1][4] = (dp[i][3] + dp[i][5])% 1000000000;
            dp[i+1][5] = (dp[i][4] + dp[i][6])% 1000000000;
            dp[i+1][6] = (dp[i][5] + dp[i][7])% 1000000000;
            dp[i+1][7] = (dp[i][6] + dp[i][8])% 1000000000;
            dp[i+1][8] = (dp[i][7] + dp[i][9])% 1000000000;
            dp[i+1][9] = (dp[i][8])% 1000000000;
        }
        long sum=0;
        for(int tmp:dp[n]){
            sum += tmp;
        }
        System.out.println(sum%1000000000);
    }
}
