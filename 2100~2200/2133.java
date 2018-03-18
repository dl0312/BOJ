import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 2133
// Algorithm - DP

public class Main {
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] dp = new int [100];
        dp[0] = 1;
        dp[2] = 3;
        for(int i=4;i<=n;i+=2){
            dp[i] += dp[i-2]*3;
            for(int j=4;j<=i;j+=2){
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(dp[n]);
        scn.close();
    }
}
