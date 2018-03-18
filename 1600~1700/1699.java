import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 1699
// Algorithm - DP

public class Main {
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int [] num = new int [400];
        for(int i=1;i<400;i++) {
            num[i] = i * i;
        }
        int [] dp = new int [k+1];
        Arrays.fill(dp,200000);
        dp[0] = 0;
        for(int i=1;i*i<=k;i++) {
            for (int j = num[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
            }
        }
        System.out.println(dp[k]);
        scn.close();
    }
}
