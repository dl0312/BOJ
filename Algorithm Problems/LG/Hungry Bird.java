import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	LG #2
//	Algorithm - Stack

public class Main {
	
	static char [][] map = new char [501][501];
	static int [][] point = new int [501][501];
	
	public static class Ele{
		int x;
		int y;
		int b_cnt = 0;
		int flag = 1;//1:ascending,2:descending
		public Ele(int x,int y) {
			this.x = x;
			this.y = y;
		}
		
		public Ele(int x,int y, int b_cnt,int flag) {
			this.x = x;
			this.y = y;
			this.b_cnt = b_cnt;
			this.flag = flag;
		}
	}
	public static int eat(int f_x,int f_y,int s_x,int s_y) {
		int cnt=0;
		if(f_x>s_x) {
			for(int i=f_x;i>=s_x;i--) {
				if(map[i][s_y]=='B') cnt++;
			}
		}
		else if(f_x<s_x){
			for(int i=f_x;i<=s_x;i++) {
				if(map[i][s_y]=='B') cnt++;
			}
		}
		else if(f_x==s_x) {
			if(map[f_x][s_y]=='B') cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int n;
		int max;
		while(t-->0) {
			Queue<Ele> q = new LinkedList<>();
			max=0;
			for(int i=0;i<501;i++) {
				for(int j=0;j<501;j++) {
					point[i][j] = -1;
				}
			}
			n = scn.nextInt();
			for(int i=0;i<501;i++) {
				Arrays.fill(map[i], ' ');
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[n-i-1][j] = scn.next().charAt(0);
				}
			}
			Ele now = new Ele(0,-1);
			q.add(now);
			while(q.isEmpty()==false) {
				Ele tmp = q.poll();
//				System.out.println("x: "+tmp.x+ " y: "+tmp.y+" b: "+tmp.b_cnt+" flag: "+tmp.flag);
				if(tmp.x==0&&tmp.y==n) {
					if(max<tmp.b_cnt) {
						max = tmp.b_cnt;
					}
				}
				if(tmp.y<n) {
					for(int i=0;i<=tmp.x;i++) {
						q.add(new Ele(i,tmp.y+1,tmp.b_cnt+eat(tmp.x,tmp.y,i,tmp.y+1),2));
						
					}
					if(tmp.flag==1) {
						for(int i=tmp.x;i<n;i++) {
							q.add(new Ele(i,tmp.y+1,tmp.b_cnt+eat(tmp.x,tmp.y,i,tmp.y+1),1));				
						}
					}
				}
			}
			System.out.println("max: "+max);
		}
		scn.close();
	}
}