import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

// BOJ - 1915
// Algorithm - DP

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int [][] map = new int [1005][1005];
        int [][] dp = new int [1005][1005];
        int y = scn.nextInt();
        int x = scn.nextInt();
        int max=0;
        for(int i=0;i<y;i++){
            String tmp = scn.next();
            for(int j=0;j<x;j++){
                map[i][j] = tmp.toCharArray()[j]-48;
                if(map[i][j]==1){
                    max = 1;
                }
            }
        }
        for(int i=0;i<x;i++){
            dp[0][i] = map[0][i];
        }
        for(int i=0;i<y;i++){
            dp[i][0] = map[i][0];
        }
        for(int i=1;i<y;i++){
            for(int j=1;j<x;j++){
                if(map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
        }

        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        scn.close();
        System.out.println(max*max);
    }
}
