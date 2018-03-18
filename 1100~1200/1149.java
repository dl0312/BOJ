import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 1149
// Algorithm - DP

public class Main {

    public static class House{
        int r;
        int g;
        int b;
        char color;
        public House(int r,int g,int b){
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // The number of houses
        House [] house = new House [1000]; // cost of the paint in each house colors
        for(int i=1;i<=n;i++){
            house[i] = new House(scn.nextInt(),scn.nextInt(),scn.nextInt());
        }
        int [] red = new int [1000];
        int [] blue = new int [1000];
        int [] green = new int [1000];
        red[1] = house[1].r;
        green[1] = house[1].g;
        blue[1] = house[1].b;
        for(int i=2;i<=n;i++){
            red[i] = Math.min(green[i-1],blue[i-1])+house[i].r;
            green[i] = Math.min(red[i-1],blue[i-1])+house[i].g;
            blue[i] = Math.min(green[i-1],red[i-1])+house[i].b;
        }
        System.out.println(Math.min(Math.min(red[n],green[n]),blue[n]));

        scn.close();
    }
}
