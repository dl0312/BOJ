import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 1937
// Algorithm - DP

public class Main {

    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    static int n,max=0;

    static int [][] map = new int [501][501];
    static int [][] visit = new int [501][501];

    public static void dfs(int y, int x){
        int nextX,nextY;
        int value = 0;
        for(int i=0;i<4;i++){
            nextX=x+dx[i];
            nextY=y+dy[i];
            if(nextX>=n||nextX<0||nextY>=n||nextY<0) continue;
            if(map[nextY][nextX]<map[y][x]){
                if(visit[nextY][nextX]==0){
                    dfs(nextY,nextX);
                }
                if(value<visit[nextY][nextX]){
                    value=visit[nextY][nextX];
                }
            }
        }
        visit[y][x] = value+1;

        if(max<visit[y][x]){
            max=visit[y][x];
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j]==0){
                    dfs(i,j);
                }
            }
        }
        sc.close();
        System.out.println(max);
    }
}
