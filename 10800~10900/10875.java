import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 10875
//	Algorithm - ?
//	Samsung SW #6

public class Main {
	
	static int n;
	static long l;
	
	private static class Line{
		Pos str;
		Pos end;
		int type=0; // 0: vertical, 1: horizental
		
		public Line(Pos str, Pos end) {
			this.str = str;
			this.end = end;
			if(str.x==end.x) {
				type = 1;
			}
			if(str.y==end.y) {
				type = 0;
			}
		}
		
		public Pos is_line_cross(Line line) {
			long tmp_x,tmp_y;
			if(line.type == this.type) {
				if(this.type==0) {
					if(this.str.y==line.str.y) {
						if(this.end.x>=line.str.x && this.end.x<=line.end.x) {
							if(Math.abs(line.end.x-this.str.x)<Math.abs(line.str.x-this.str.x)) {
								return line.end;
							}
							else if(Math.abs(line.end.x-this.str.x)>Math.abs(line.str.x-this.str.x)) {
								return line.str;
							}
						}
						else if(this.end.x<=line.str.x && this.end.x>=line.end.x) {
							if(Math.abs(line.end.x-this.str.x)<Math.abs(line.str.x-this.str.x)) {
								return line.end;
							}
							else if(Math.abs(line.end.x-this.str.x)>Math.abs(line.str.x-this.str.x)) {
								return line.str;
							}
						}
						else if((this.end.x>=line.str.x && this.end.x>=line.end.x)&&(this.str.x<=line.str.x && this.str.x<=line.end.x)) {
							if(Math.abs(line.end.x-this.str.x)<Math.abs(line.str.x-this.str.x)) {
								return line.end;
							}
							else if(Math.abs(line.end.x-this.str.x)>Math.abs(line.str.x-this.str.x)) {
								return line.str;
							}
						}
						else if((this.end.x<=line.str.x && this.end.x<=line.end.x)&&(this.str.x>=line.str.x && this.str.x>=line.end.x)) {
							if(Math.abs(line.end.x-this.str.x)<Math.abs(line.str.x-this.str.x)) {
								return line.end;
							}
							else if(Math.abs(line.end.x-this.str.x)>Math.abs(line.str.x-this.str.x)) {
								return line.str;
							}
						}
					}
					else {
						return null;
					}
				}
				else if(this.type==1) {
					if(this.str.x==line.str.x) {
						if(this.end.y>=line.str.y && this.end.y<=line.end.y) {
							if(Math.abs(line.end.y-this.str.y)<Math.abs(line.str.y-this.str.y)) {
								return line.end;
							}
							else if(Math.abs(line.end.y-this.str.y)>Math.abs(line.str.y-this.str.y)) {
								return line.str;
							}
						}
						else if(this.end.y<=line.str.y && this.end.y>=line.end.y) {
							if(Math.abs(line.end.y-this.str.y)<Math.abs(line.str.y-this.str.y)) {
								return line.end;
							}
							else if(Math.abs(line.end.y-this.str.y)>Math.abs(line.str.y-this.str.y)) {
								return line.str;
							}
						}
						else if((this.end.y>=line.str.y && this.end.y>=line.end.y)&&(this.str.y<=line.str.y && this.str.y<=line.end.y)) {
							if(Math.abs(line.end.y-this.str.y)<Math.abs(line.str.y-this.str.y)) {
								return line.end;
							}
							else if(Math.abs(line.end.y-this.str.y)>Math.abs(line.str.y-this.str.y)) {
								return line.str;
							}
						}
						else if((this.end.y<=line.str.y && this.end.y<=line.end.y)&&(this.str.y>=line.str.y && this.str.y>=line.end.y)) {
							if(Math.abs(line.end.y-this.str.y)<Math.abs(line.str.y-this.str.y)) {
								return line.end;
							}
							else if(Math.abs(line.end.y-this.str.y)>Math.abs(line.str.y-this.str.y)) {
								return line.str;
							}
						}
					}
					else {
						return null;
					}
				}
				return null;
			}
			else if(line.type != this.type) {
				if(this.type==0) {
					tmp_y = this.str.y;
					tmp_x = line.str.x;
					if((tmp_x>=this.str.x && tmp_x<=this.end.x)||(tmp_x<=this.str.x && tmp_x>=this.end.x)) {
						if((tmp_y>=line.str.y && tmp_y<=line.end.y)||(tmp_y<=line.str.y && tmp_y>=line.end.y)) {
							return new Pos(tmp_x,tmp_y);
						}
					}
				}
				else if(this.type==1) {
					tmp_x = this.str.x;
					tmp_y = line.str.y;
					if((tmp_y>=this.str.y && tmp_y<=this.end.y)||(tmp_y<=this.str.y && tmp_y>=this.end.y)) {
						if((tmp_x>=line.str.x && tmp_x<=line.end.x)||(tmp_x<=line.str.x && tmp_x>=line.end.x)) {
							return new Pos(tmp_x,tmp_y);
						}
					}
				}
			}
			return null;
		}
	}
	
	private static class Snake{
		long second = 0;
		boolean finished = false;
		Pos head;
		Pos fake_tail;
		int dir=0; // 0:east, 1:south, 2:west, 3:north
		long min_distance = 2*l+1;
		boolean self_crash = false;
		
		LinkedList<Line> trace = new LinkedList<Line>();
		
		public Snake() {
			this.head = new Pos(0,0);
			this.fake_tail = new Pos(0,0);
		}
		
		public void curve(char curve) {
			if(curve=='L') {
				this.dir = (this.dir+3)%4;
			}
			else if(curve=='R'){
				this.dir = (this.dir+1)%4;
			}
			this.trace.add(new Line(new Pos(this.head.x,this.head.y),new Pos(this.fake_tail.x,this.fake_tail.y)));
			this.fake_tail = new Pos(this.head.x,this.head.y);
		}
		
		public void print() {
			System.out.println("head: " + this.head.x  +", " + this.head.y);
			System.out.println("Second " + this.second);
		}
		
		public void move(long distance) {
			this.print();
			Pos str = new Pos(this.head.x,this.head.y);
			if(this.dir==0) {
				this.head.y+=distance;
			}
			else if(this.dir==1) {
				this.head.x+=distance;
			}
			else if(this.dir==2) {
				this.head.y-=distance;
			}
			else if(this.dir==3) {
				this.head.x-=distance;
			}
			Pos end = new Pos(this.head.x,this.head.y);
			Line line = new Line(str,end);
			for(int i=0;i<trace.size()-1&&trace.size()>2;i++) {
				if(line.is_line_cross(trace.get(i))!=null) {
					self_crash = true;
					finished = true;
					Pos meet = new Pos(line.is_line_cross(trace.get(i)).x,line.is_line_cross(trace.get(i)).y);
					if(min_distance>str.distance(meet)) {
						min_distance = str.distance(new Pos(meet.x,meet.y));
					}
				}
			}
			if((Math.abs(end.x)>l || Math.abs(end.y)>l)&&self_crash==false) {
				if(end.x>l) {
					this.second += Math.abs(l+1-str.x);
				}
				else if(end.x<-1*l) {
					this.second += Math.abs(str.x+l+1);
				}
				else if(end.y>l) {
					this.second += Math.abs(l+1-str.y);
				}
				else if(end.y<-1*l) {
					this.second += Math.abs(str.y+l+1);
				}
				this.finished = true;
			}
			else if(self_crash==true) {
				second+=min_distance;
				this.finished = true;
			}
			else {
				this.second+=distance;
			}
		}
	}
	
	private static class Pos{
		long x;
		long y;
		
		public Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}
		public long distance(Pos pos) {
			return Math.abs(this.x+this.y-pos.x-pos.y);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		l = scn.nextLong();
		n = scn.nextInt();
		Snake snake = new Snake();
		for(int i=0;i<n&&snake.finished==false;i++) {
			snake.move(scn.nextLong());
			snake.curve(scn.next().charAt(0));
		}
		if(snake.finished==false) {
			snake.move(2*l+1);
		}
		System.out.println(snake.second);
		scn.close();
	}
}