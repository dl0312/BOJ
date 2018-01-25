import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 10250
//	Algorithm - Find a rule

public class Main {
	
	public static class hotel{
		int [][] room_matrix;
		int h;
		int w;
		int n;
		
		public hotel(int h,int w) {
			this.h = h;
			this.w = w;
			room_matrix = new int [h][w];
		}
		
		void select_room(int n){
			int floor;
			int room_num;
			String room;
			/*
			boolean [][] selected = new boolean [h][w];
			for(int i=0;)
			*/
			room_num  = n/h+1;
			floor = n%h;
			if(floor == 0) {
				floor = h;
				room_num-=1;
			}
			if(room_num<10) {
				room = new String(floor + "0" + room_num);
			}
			else {
				room = new String(floor+ "" + room_num);
			}
			System.out.println(room);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test_num = scn.nextInt();
		int h,w,n;
		for(int i=0;i<test_num;i++) {
			h = scn.nextInt();
			w = scn.nextInt();
			n = scn.nextInt();
			hotel acm = new hotel(h,w);
			acm.select_room(n);
		}
		scn.close();
	}
}