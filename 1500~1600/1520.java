import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ - 1520
// Algorithm - DP

public class Main {

    static int [][] map = new int [501][501];
    static int [][] visit = new int [501][501];
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int M,N;
    static {
        for(int i=0;i<=500;i++){
            Arrays.fill(visit[i],-1);
        }
    }

    public static int search(int x,int y)
    {
        if(x==N && y==M){
            return 1;
        }
        if(visit[y][x]!=-1) return visit[y][x];
        int tmp = 0;
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX<=0 || nextX>N || nextY<=0 || nextY>M){
                continue;
            }
            if(map[nextY][nextX] < map[y][x]){
                tmp += search(nextX,nextY);
            }
        }
        return visit[y][x] = tmp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(search(1,1));
    }
}
