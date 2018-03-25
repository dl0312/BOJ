import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// BOJ - 1931
// Algorithm - Greedy Algorithm

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [][] meeting = new int [n][2];
        Comparator c = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1]-b[1]!=0) return a[1] - b[1];
                else return a[0] - b[0];
            }
        };
        boolean [] flag = new boolean [n];
        for(int i=0;i<n;i++){
            meeting[i][0] = scn.nextInt();
            meeting[i][1] = scn.nextInt();
        }
        Arrays.sort(meeting, c);
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(meeting[i]));
        scn.close();
        int start=0, end= 0;
        int meeting_num = 0;
        boolean has_meeting = false;
        while(true){
            has_meeting = false;
            for(int i=0;i<n;i++){
                if(start<=meeting[i][0] && flag[i] == false){
                    has_meeting = true;
                    end = meeting[i][1];
                    flag[i] = true;
                    meeting_num++;
                    start = end;
                    end = start;
                }
            }
            if(has_meeting==false){
                break;
            }
        }
        System.out.println(meeting_num);
    }
}
