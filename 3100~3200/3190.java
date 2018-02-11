
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 3190
//	Algorithm - ?
//	Samsung SW #3

public class Main {
	
	static int n;
	static int k;
	static int l;
	static int [][] map;
	
	private static class Map{
		int [][] map;
		int second = 0;
		Snake snake = new Snake(1,1);
		boolean finished = false;
		
		public Map(int n) {
			this.map = new int [n+2][n+2];
			for(int i=0;i<n+2;i++) {	//	2: wall
				for(int j=0;j<n+2;j++) {
					this.map[i][j] = 2;
				}
			}
			for(int i=1;i<n+1;i++) {	//	0: empty space
				for(int j=1;j<n+1;j++) {
					this.map[i][j] = 0;
				}
			}
			this.map[1][1] = 3;
		}
		
		public void setAppleAry(Pos [] apple_pos_ary) {
			for(int i=0;i<apple_pos_ary.length;i++) {	//	1: apple 
				this.map[apple_pos_ary[i].x][apple_pos_ary[i].y] = 1;
			}
		}
		
		public void curve(char curve) {
			this.snake.curve_list.add(new Curve_Pos(new Pos(this.snake.head.x,this.snake.head.y),(this.snake.dir+2)%4));
			if(curve=='L') {
				this.snake.dir = (this.snake.dir+3)%4;
			}
			else if(curve=='D'){
				this.snake.dir = (this.snake.dir+1)%4;
			}
			this.snake.sep_length.add(0);
		}
		
		public void print() {
			System.out.println("head: " + this.snake.head.x  +", " + this.snake.head.y);
			System.out.println("Second " + this.second);
			for(int i=0;i<n+2;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
		}
		
		public void move(int length) {
			if(length!=0) {
				//this.print();
				if(this.snake.dir==0) {
					this.snake.head.y+=1;
				}
				else if(this.snake.dir==1) {
					this.snake.head.x+=1;
				}
				else if(this.snake.dir==2) {
					this.snake.head.y-=1;
				}
				else if(this.snake.dir==3) {
					this.snake.head.x-=1;
				}
				if(map[this.snake.head.x][this.snake.head.y]==2) {
					length=1;
					this.finished = true;
				}
				else if(map[this.snake.head.x][this.snake.head.y]==3) {
					/*
					this.snake.sep_length.set(0, this.snake.sep_length.get(0)-1);	// Ã³À½²¨ -1
					this.snake.sep_length.set(this.snake.sep_length.size()-1, this.snake.sep_length.get(this.snake.sep_length.size()-1)+1);
					int tmp_x=0;
					int tmp_y=0;
					if(this.snake.curve_list.isEmpty()==false) {
						tmp_x = this.snake.curve_list.get(0).curve_pos.x;
						tmp_y = this.snake.curve_list.get(0).curve_pos.y;
						if(this.snake.curve_list.get(0).curve_dir==0) {
							tmp_y+=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==1) {
							tmp_x+=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==2) {
							tmp_y-=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==3) {
							tmp_x-=this.snake.sep_length.get(0);
						}
					}
					if(this.snake.head.x!=tmp_x || this.snake.head.y!=tmp_y) {
						length=1;
						this.finished = true;
					}
					*/
					length=1;
					this.finished = true;
				}
				else if(map[this.snake.head.x][this.snake.head.y]==1) {
					this.snake.length+=1;
					map[this.snake.head.x][this.snake.head.y] = 3;

					this.snake.sep_length.set(this.snake.sep_length.size()-1, this.snake.sep_length.get(this.snake.sep_length.size()-1)+1);
				}
				else {
					map[this.snake.head.x][this.snake.head.y] = 3;
					this.snake.sep_length.set(0, this.snake.sep_length.get(0)-1);	// Ã³À½²¨ -1
					this.snake.sep_length.set(this.snake.sep_length.size()-1, this.snake.sep_length.get(this.snake.sep_length.size()-1)+1);
					if(this.snake.curve_list.isEmpty()==false) {
						int tmp_x = this.snake.curve_list.get(0).curve_pos.x;
						int tmp_y = this.snake.curve_list.get(0).curve_pos.y;
						if(this.snake.curve_list.get(0).curve_dir==0) {
							tmp_y+=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==1) {
							tmp_x+=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==2) {
							tmp_y-=this.snake.sep_length.get(0);
						}
						else if(this.snake.curve_list.get(0).curve_dir==3) {
							tmp_x-=this.snake.sep_length.get(0);
						}
						map[tmp_x][tmp_y] = 0;
					}
					else if(this.snake.curve_list.isEmpty()==true) {
						int tmp_x = this.snake.head.x;
						int tmp_y = this.snake.head.y;
						if(this.snake.dir==2) {
							tmp_y+=this.snake.sep_length.get(0);
						}
						else if(this.snake.dir==3) {
							tmp_x+=this.snake.sep_length.get(0);
						}
						else if(this.snake.dir==0) {
							tmp_y-=this.snake.sep_length.get(0);
						}
						else if(this.snake.dir==1) {
							tmp_x-=this.snake.sep_length.get(0);
						}
						map[tmp_x][tmp_y] = 0;
					}
				}
				if(this.snake.sep_length.get(0)==0) {
					this.snake.sep_length.pop();
					this.snake.curve_list.pop();
				}
				length--;
				this.second++;
				this.move(length);
			}
		}
	}
	
	private static class Snake{
		Pos head;
		int dir=0; // 0:east, 1:south, 2:west, 3:north
		int length=1;
		LinkedList<Curve_Pos> curve_list = new LinkedList<Curve_Pos>();
		LinkedList<Integer> sep_length = new LinkedList<Integer>();
		
		public Snake(int x,int y) {
			this.head = new Pos(x,y);
			sep_length.add(length);
		}
	}
	
	private static class Curve_Pos{
		Pos curve_pos;
		int curve_dir;
		
		public Curve_Pos(Pos curve_pos, int curve_dir) {
			this.curve_pos = curve_pos;
			this.curve_dir = curve_dir;
		}
	}
	
	private static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		Map map = new Map(n);
		k = scn.nextInt();
		Pos [] apple_pos_ary = new Pos[k];
		int length;
		char dir;
		for(int i=0;i<k;i++) {
			apple_pos_ary[i] = new Pos(scn.nextInt(),scn.nextInt());
		}
		map.setAppleAry(apple_pos_ary);
		l = scn.nextInt();
		int tmp=0;
		int tmp2=0;
		for(int i=0;i<l&&map.finished==false;i++) {
			if(i==0) {
				tmp = scn.nextInt();
				map.move(tmp);
			}
			else {
				tmp2 = scn.nextInt();
				map.move(tmp2-tmp);
				tmp = tmp2;
			}
			map.curve(scn.next().charAt(0));
		}
		if(map.finished==false) {
			map.move(n);
		}
		//System.out.println("end time: " + map.second);

		System.out.println(map.second);
		scn.close();
	}
}