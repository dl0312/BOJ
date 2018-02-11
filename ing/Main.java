
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 3190
//	Algorithm - ?
//	Samsung SW #3

public class Main {
	
	static int n;
	static int k;
	static long l;
	
	private static class Line{
		Pos str;
		Pos end;
		
		public Line(Pos str, Pos end) {
			this.str = str;
			this.end = end;
		}
		
		public boolean is_pos_contain(Pos pos) {
			if(pos.x == str.x && pos.x == end.x) {
				if(pos.y>=this.str.y && pos.y<=this.end.y || pos.y<=this.str.y && pos.y>=this.end.y) {
					return true;
				}
			}
			else if(pos.y == this.str.y && pos.y == this.end.y) {
				if(pos.x>=this.str.x && pos.x<=this.end.x || pos.x<=this.str.x && pos.x>=this.end.x) {
					return true;
				}
			}
			return false;
		}
		
		public boolean is_line_cross(Line line) {
			
		}
	}
	
	private static class Snake{
		int second = 0;
		boolean finished = false;
		Pos head;
		int dir=0; // 0:east, 1:south, 2:west, 3:north
		int length=1;
		boolean crash = false;
		
//		LinkedList<Curve_Pos> curve_list = new LinkedList<Curve_Pos>();
		LinkedList<Integer> sep_length = new LinkedList<Integer>();
		LinkedList<Pos> trace = new LinkedList<Pos>();
		
		public Snake() {
			this.head = new Pos(0,0);
			this.trace.add(new Pos(0,0));
		}
		
		public void curve(char curve) {
			/*
			this.snake.curve_list.add(new Curve_Pos(new Pos(this.snake.head.x,this.snake.head.y),(this.snake.dir+2)%4));
			*/
			if(curve=='L') {
				this.dir = (this.dir+3)%4;
			}
			else if(curve=='R'){
				this.dir = (this.dir+1)%4;
			}
			this.trace.add(new Pos(this.head.x,this.head.y));
			/*s
			this.snake.sep_length.add(0);
			*/
		}
		
		public void print() {
			System.out.println("head: " + this.head.x  +", " + this.head.y);
			System.out.println("Second " + this.second);
		}
		
		public void move(long distance) {
			while(distance!=0) {
//				this.print();
				if(this.dir==0) {
					this.head.y+=1;
				}
				else if(this.dir==1) {
					this.head.x+=1;
				}
				else if(this.dir==2) {
					this.head.y-=1;
				}
				else if(this.dir==3) {
					this.head.x-=1;
				}
				for(int i=0;i<trace.size()&&trace.size()>3;i++) {
					if(trace.get(i).x==this.head.x){
						if(i==0) {
							if(trace.get(i+1).x==this.head.x) {
								if((trace.get(i+1).y >= this.head.y && trace.get(i).y <= this.head.y) || (trace.get(i+1).y <= this.head.y && trace.get(i).y >= this.head.y)){
									crash = true;
								}
							}
						}
						else if(i==trace.size()-1) {
							if(trace.get(i-1).x==this.head.x) {
								if((trace.get(i-1).y >= this.head.y && trace.get(i).y <= this.head.y) || (trace.get(i+1).y <= this.head.y && trace.get(i).y >= this.head.y)){
									crash = true;
								}
							}
						}
						else {
							if(trace.get(i+1).x==this.head.x) {
								if((trace.get(i+1).y >= this.head.y && trace.get(i).y <= this.head.y) || (trace.get(i+1).y <= this.head.y && trace.get(i).y >= this.head.y)){
									crash = true;
								}
							}
							if(trace.get(i-1).x==this.head.x) {
								if((trace.get(i-1).y >= this.head.y && trace.get(i).y <= this.head.y) || (trace.get(i+1).y <= this.head.y && trace.get(i).y >= this.head.y)){
									crash = true;
								}
							}
						}
					}
					else if(trace.get(i).y==this.head.y) {
						if(i==0) {
							if(trace.get(i+1).y==this.head.y) {
								if((trace.get(i+1).x >= this.head.x && trace.get(i).x <= this.head.x) || (trace.get(i+1).x <= this.head.x && trace.get(i).x >= this.head.x)){
									crash = true;
								}
							}
						}
						else if(i==trace.size()-1) {
							if(trace.get(i-1).y==this.head.y) {
								if((trace.get(i-1).x >= this.head.x && trace.get(i).x <= this.head.x) || (trace.get(i+1).x <= this.head.x && trace.get(i).x >= this.head.x)){
									crash = true;
								}
							}
						}
						else {
							if(trace.get(i+1).y==this.head.y) {
								if((trace.get(i+1).x >= this.head.x && trace.get(i).x <= this.head.x) || (trace.get(i+1).x <= this.head.x && trace.get(i).x >= this.head.x)){
									crash = true;
								}
							}
							if(trace.get(i-1).y==this.head.y) {
								if((trace.get(i-1).x >= this.head.x && trace.get(i).x <= this.head.x) || (trace.get(i+1).x <= this.head.x && trace.get(i).x >= this.head.x)){
									crash = true;
								}
							}
						}
					}
				}
				if(Math.abs(this.head.x)>l || Math.abs(this.head.y)>l) {
					distance=1;
					this.finished = true;
				}
				else if(crash==true) {
					distance=1;
					this.finished = true;
				}
				else {
					/*
					this.snake.sep_length.set(0, this.snake.sep_length.get(0)-1);	// Ã³À½²¨ -1
					this.snake.sep_length.set(this.snake.sep_length.size()-1, this.snake.sep_length.get(this.snake.sep_length.size()-1)+1);
					if(this.snake.curve_list.isEmpty()==false) {
						long tmp_x = this.snake.curve_list.get(0).curve_pos.x;
						long tmp_y = this.snake.curve_list.get(0).curve_pos.y;
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
					else if(this.snake.curve_list.isEmpty()==true) {
						long tmp_x = this.snake.head.x;
						long tmp_y = this.snake.head.y;
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
					}
					*/
				}
				distance--;
				this.second++;
			}
		}
	}
	/*
	private static class Curve_Pos{
		Pos curve_pos;
		int curve_dir;
		
		public Curve_Pos(Pos curve_pos, int curve_dir) {
			this.curve_pos = curve_pos;
			this.curve_dir = curve_dir;
		}
	}
	*/
	private static class Pos{
		long x;
		long y;
		
		public Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public long getX() {
			return x;
		}

		public void setX(long x) {
			this.x = x;
		}

		public long getY() {
			return y;
		}

		public void setY(long y) {
			this.y = y;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		l = scn.nextLong();
		n = scn.nextInt();
		Snake snake = new Snake();
		for(int i=0;i<n&&snake.finished==false;i++) {
			snake.move(scn.nextInt());
			snake.curve(scn.next().charAt(0));
		}
		if(snake.finished==false) {
			snake.move(2*l+1);
		}
		//System.out.println("end time: " + map.second);

		System.out.println(snake.second);
		scn.close();
	}
}