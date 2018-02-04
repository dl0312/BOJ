import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 13460
//	Algorithm - ?

public class Main {
	private static int n,m;
	private static Pos O;
	private static char [][] map;
	private static boolean [][] visit_b;
	private static boolean [][] visit_r;
	private static Queue<t_Pos> q = new LinkedList<>();
	
	private static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class t_Pos{
		Pos B;
		Pos R;
		int cnt;
		public t_Pos(Pos B, Pos R, int cnt) {
			this.B = B;
			this.R = R;
			this.cnt = cnt;
		}
	}
	
	public static int BFS(t_Pos now) {
		t_Pos tmp = now;
		q.offer(now);
		boolean b_flag = false;
		boolean r_flag = false;
		int min_cnt = 11;
		while(!q.isEmpty()) {
			b_flag = false;
			r_flag = false;
			now = q.poll();
			visit_b[now.B.x][now.B.y] = true;
			visit_r[now.R.x][now.R.y] = true;
			if(now.cnt>=11) {
				System.out.println(-1);
				min_cnt = -1;
				break;
			}
			print_map(now);
			for(int i=0;i<4;i++) {	// 0:µ¿,1:¼­,2:³²,3:ºÏ
				tmp = new t_Pos(roll(now.B,i),roll(now.R,i),now.cnt+1);
				if(i==0) {
					if(tmp.B.y==tmp.R.y && tmp.B.x==tmp.R.x) {
						if(now.B.y>now.R.y) {
							tmp.R.y--;
						}
						else {
							tmp.B.y--;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && (visit_b[tmp.B.x][tmp.B.y]==false||visit_r[tmp.R.x][tmp.R.y]==false))  {
						if((now.B.y<O.y && tmp.B.y>=O.y) && now.B.x == O.x) {
							b_flag = true;
						}
						if((now.R.y<O.y && tmp.R.y>=O.y) && now.R.x == O.x) {
							r_flag = true;
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
//							System.out.println(tmp.cnt);
							if(min_cnt>tmp.cnt) min_cnt = tmp.cnt;
							break;
						}
					}
				}
				else if(i==1) {
					if(tmp.B.y==tmp.R.y && tmp.B.x==tmp.R.x) {
						if(now.B.y<now.R.y) {
							tmp.R.y++;
						}
						else {
							tmp.B.y++;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && (visit_b[tmp.B.x][tmp.B.y]==false||visit_r[tmp.R.x][tmp.R.y]==false)) {
						if((now.B.y>O.y && tmp.B.y<=O.y) && now.B.x == O.x) {
							b_flag = true;
						}
						if((now.R.y>O.y && tmp.R.y<=O.y) && now.R.x == O.x) {
							r_flag = true;
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
//							System.out.println(tmp.cnt);
							if(min_cnt>tmp.cnt) min_cnt = tmp.cnt;
							break;
						}
					}
				}
				else if(i==2) {
					if(tmp.B.y==tmp.R.y && tmp.B.x==tmp.R.x) {
						if(now.B.x>now.R.x) {
							tmp.R.x--;
						}
						else {
							tmp.B.x--;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && (visit_b[tmp.B.x][tmp.B.y]==false||visit_r[tmp.R.x][tmp.R.y]==false)) {
						if((now.B.x<O.x && tmp.B.x>=O.x) && now.B.y == O.y) {
							b_flag = true;
						}
						if((now.R.x<O.x && tmp.R.x>=O.x) && now.R.y == O.y) {
							r_flag = true;
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
//							System.out.println(tmp.cnt);
							if(min_cnt>tmp.cnt) min_cnt = tmp.cnt;
							break;
						}
					}		
				}
				else if(i==3) {
					if(tmp.B.y==tmp.R.y && tmp.B.x==tmp.R.x) {
						if(now.B.x<now.R.x) {
							tmp.R.x++;
						}
						else {
							tmp.B.x++;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && (visit_b[tmp.B.x][tmp.B.y]==false||visit_r[tmp.R.x][tmp.R.y]==false)) {
						if((now.B.x>O.x && tmp.B.x<=O.x) && now.B.y == O.y) {
							b_flag = true;
						}
						if((now.R.y>O.x && tmp.R.x<=O.x) && now.R.y == O.y) {
							r_flag = true;
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
//							System.out.println(tmp.cnt);
							if(min_cnt>tmp.cnt) min_cnt = tmp.cnt;
							break;
						}
					}
				}
			}
		}
		if(min_cnt==11) {
			return -1;
		}
		else return min_cnt;
	}
	
	public static Pos roll(Pos p, int dir) {
		// dir 0:µ¿,1:¼­,2:³²,3:ºÏ
		Pos tmp = new Pos(p.x,p.y);
		if(dir==0) {
			while(true) {
				tmp.y++;
				if(map[tmp.x][tmp.y]=='#') {
					tmp.y--;
					break;
				}
			}
		}
		else if(dir==1) {
			while(true) {
				tmp.y--;
				if(map[tmp.x][tmp.y]=='#') {
					tmp.y++;
					break;
				}
			}
		}
		else if(dir==2) {
			while(true) {
				tmp.x++;
				if(map[tmp.x][tmp.y]=='#') {
					tmp.x--;
					break;
				}
			}
		}
		else if(dir==3) {
			while(true) {
				tmp.x--;
				if(map[tmp.x][tmp.y]=='#') {
					tmp.x++;
					break;
				}
			}
		}
		return tmp;
	}
	
	public static void print_map(t_Pos pos) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(pos.B.x==i && pos.B.y==j) {
					System.out.print('B' + " ");
				}
				else if(pos.R.x==i && pos.R.y==j) {
					System.out.print('R' + " ");
				}
				else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println("cnt: " + pos.cnt);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		Pos B = new Pos(0,0);
		Pos R = new Pos(0,0);
		map = new char [n][m];
		visit_b = new boolean [n][m];
		visit_r = new boolean [n][m];
		String trash = scn.nextLine();
		
		for(int i=0;i<n;i++) {
			String str = scn.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
				if(str.charAt(j)=='B') {
					B = new Pos(i,j);
					map[i][j] = '.';
				}
				else if(str.charAt(j)=='R') {
					R = new Pos(i,j);
					map[i][j] = '.';
				}
				else if(str.charAt(j)=='O') {
					O = new Pos(i,j);
				}
			}
		}
		System.out.println(BFS(new t_Pos(B,R,0)));
		scn.close();
	}
}