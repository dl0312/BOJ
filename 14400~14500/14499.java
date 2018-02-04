import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14499
//	Algorithm - ?

public class Main {
	
	static int [][] map;
	static int [] order;
	
	private static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Dice{
		int [] dice_num = new int [6]; //[0]:top [1~4]:side(from east clockwise) [5]:bottom
		
		public Dice(int [] dice_num_ary) {
			this.dice_num = dice_num_ary;
		}
		
		public static Dice move(Dice dice, int dir) {
			Dice moved = new Dice(new int [6]);
			if(dir==1) {	// east
				moved.dice_num[0] = dice.dice_num[3];
				moved.dice_num[1] = dice.dice_num[0];
				moved.dice_num[2] = dice.dice_num[2];
				moved.dice_num[3] = dice.dice_num[5];
				moved.dice_num[4] = dice.dice_num[4];
				moved.dice_num[5] = dice.dice_num[1];
			}
			else if(dir==2) {	// west
				moved.dice_num[0] = dice.dice_num[1];
				moved.dice_num[1] = dice.dice_num[5];
				moved.dice_num[2] = dice.dice_num[2];
				moved.dice_num[3] = dice.dice_num[0];
				moved.dice_num[4] = dice.dice_num[4];
				moved.dice_num[5] = dice.dice_num[3];
			}
			else if(dir==4) {	// south
				moved.dice_num[0] = dice.dice_num[4];
				moved.dice_num[1] = dice.dice_num[1];
				moved.dice_num[2] = dice.dice_num[0];
				moved.dice_num[3] = dice.dice_num[3];
				moved.dice_num[4] = dice.dice_num[5];
				moved.dice_num[5] = dice.dice_num[2];
			}
			else if(dir==3) {	// north
				moved.dice_num[0] = dice.dice_num[2];
				moved.dice_num[1] = dice.dice_num[1];
				moved.dice_num[2] = dice.dice_num[5];
				moved.dice_num[3] = dice.dice_num[3];
				moved.dice_num[4] = dice.dice_num[0];
				moved.dice_num[5] = dice.dice_num[4];
			}
			return moved;
		}
	}
		
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int x = scn.nextInt();
		int y = scn.nextInt();
		int order_num = scn.nextInt();
		boolean move_flag= false;
		map = new int [n][m];
		order = new int [order_num];
		Pos dice_pos = new Pos(x,y);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = scn.nextInt();
			}
		}
		Dice dice = new Dice(new int [6]);
		for(int i=0;i<6;i++) {
			dice.dice_num[i] = 0;
		}
		for(int i=0;i<order_num;i++) {
			order[i] = scn.nextInt();
		}
		//dice.dice_num[5] =  map[dice_pos.x][dice_pos.y];
		//System.out.println(dice.dice_num[0]);
		for(int i=0;i<order_num;i++) {
			move_flag = false;
			if(order[i]==1 && dice_pos.y+1 < m) {
				dice_pos.y++;
				move_flag = true;
			}
			else if(order[i]==2 && dice_pos.y-1 >= 0){
				dice_pos.y--;
				move_flag = true;
			}
			else if(order[i]==3 && dice_pos.x-1 >= 0){
				dice_pos.x--;
				move_flag = true;
			}
			else if(order[i]==4 && dice_pos.x+1 < n){
				dice_pos.x++;
				move_flag = true;
			}
			if(move_flag==true) {
				dice = Dice.move(dice,order[i]);
				if(map[dice_pos.x][dice_pos.y]!=0) {
					dice.dice_num[5] = map[dice_pos.x][dice_pos.y];
					map[dice_pos.x][dice_pos.y] = 0;
				}
				else map[dice_pos.x][dice_pos.y]=dice.dice_num[5];
				System.out.println(dice.dice_num[0]);
			}
		}
		scn.close();
	}
}