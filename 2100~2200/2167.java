import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ - 2167
// Algorithm - DP

public class Main{
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub
	       	Scanner scn = new Scanner(System.in);
	       	int N = scn.nextInt();
	       	int M = scn.nextInt();
	       	int [][] array = new int [N][M];
	       	int [][] DP = new int [N][M];
	       	for(int i=0;i<N;i++) {
	       		for(int j=0;j<M;j++) {
	       			array[i][j] = scn.nextInt();
	       		}
	       	}
	       	for(int i=0;i<N;i++) {
	       		for(int j=0;j<M;j++) {
	       			if(i>=1 && j>=1) {
	       				DP[i][j] = DP[i-1][j] + DP[i][j-1] -DP[i-1][j-1] + array[i][j];
	       			}
	       			else if(i>=1 && j<1) {
	       				DP[i][j] = DP[i-1][j] + array[i][j];
	       			}
	       			else if(i<1 && j>=1) {
	       				DP[i][j] = DP[i][j-1] + array[i][j];
	       			}
	       			else if(i<1 && j<1) {
	       		       	DP[0][0] = array[0][0];
	       			}
	       		}
	       	}
	       	int K = scn.nextInt();
	       	for(int idx=0;idx<K;idx++) {
	       		int i = scn.nextInt();
	       		int j = scn.nextInt();
	       		int x = scn.nextInt();
	       		int y = scn.nextInt();
	       		if(i>=2 && j>=2) {
		       		System.out.println(DP[x-1][y-1] - DP[x-1][j-2] - DP[i-2][y-1] + DP[i-2][j-2]);	       			
	       		}
	       		else if(i>=2 && j<2) {
		       		System.out.println(DP[x-1][y-1] - DP[i-2][y-1]);
	       		}
	       		else if(i<2 && j>=2) {
		       		System.out.println(DP[x-1][y-1] - DP[x-1][j-2]);
	       		}
	       		else if(i<2 && j<2) {
		       		System.out.println(DP[x-1][y-1]);
	       		}
	       	}
	  }
}