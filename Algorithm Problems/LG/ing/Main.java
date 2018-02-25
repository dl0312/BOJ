import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	LG #3
//	Algorithm - Stack

public class Main {
	static int [][] map = new int [300001][300001];
	static int [] crystal = new int [300001];
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int n;	//n:the number of nodes
		int k;
		int f;
		int s;
		while(t-->0) {
			n = scn.nextInt();
			k = scn.nextInt();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = 0;
				}
			}
			for(int i=0;i<n;i++) {
				crystal[i] = scn.nextInt();
			}
			for(int i=0;i<n;i++) {
				f = scn.nextInt();
				s = scn.nextInt();
				map[f-1][s-1] = 1;
				map[s-1][f-1] = 1;
			}
		}
		scn.close();
	}
}