import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 2294
// Algorithm - DP

public class Main {
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int [] coin = new int [n];
        for(int i=0;i<n;i++){
            coin[i] = scn.nextInt();
        }
        Arrays.sort(coin);
        int [] dp = new int [k+1];
        Arrays.fill(dp,20000);
        dp[0] = 0;
        for(int i=0;i<n;i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }
        if(dp[k]>=20000){
            System.out.println(-1);
        }
        else System.out.println(dp[k]);
        scn.close();
    }
}
