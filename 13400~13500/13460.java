import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 13460
//	Algorithm - BFS
//	Samsung SW

public class Main {
	private static int n,m;
	private static Pos O;
	private static char [][] map;
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
		boolean v_flag = false;
		LinkedList<int[]> visit = new LinkedList<int[]>();
		while(!q.isEmpty()) {
			b_flag = false;
			r_flag = false;
			v_flag = false;
			now = q.poll();
			int [] v_tmp = {now.B.x,now.B.y,now.R.x,now.R.y};
			visit.add(v_tmp);
			if(now.cnt>=10) {
				return -1;
			}
//			print_map(now);
			for(int i=0;i<4;i++) {	// 0:µ¿,1:¼­,2:³²,3:ºÏ
				b_flag = false;
				r_flag = false;
				v_flag = false;
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
					int [] v_tmp2 = {tmp.B.x,tmp.B.y,tmp.R.x,tmp.R.y};
					for(int l=0;l<visit.size();l++) {
						if((visit.get(l)[0]==v_tmp2[0])&&(visit.get(l)[1]==v_tmp2[1])&&(visit.get(l)[2]==v_tmp2[2])&&(visit.get(l)[3]==v_tmp2[3])) {
							v_flag = true;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && v_flag==false)  {
						if((now.B.y<O.y && tmp.B.y>=O.y) && now.B.x == O.x) {
							b_flag = true;
						}
						if((now.R.y<O.y && tmp.R.y>=O.y) && now.R.x == O.x) {
							r_flag = true;
						}
						if(b_flag==false&&r_flag==true) {
							if((now.R.y>now.B.y) && now.R.x==now.B.x){
								tmp = new t_Pos(roll(tmp.B,i),tmp.R,now.cnt+1);
								if((now.B.y<O.y && tmp.B.y>=O.y) && now.B.x == O.x) {
									b_flag = true;
								}
							}
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
							return tmp.cnt;
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
					int [] v_tmp2 = {tmp.B.x,tmp.B.y,tmp.R.x,tmp.R.y};
					for(int l=0;l<visit.size();l++) {
						if((visit.get(l)[0]==v_tmp2[0])&&(visit.get(l)[1]==v_tmp2[1])&&(visit.get(l)[2]==v_tmp2[2])&&(visit.get(l)[3]==v_tmp2[3])) {
							v_flag = true;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && v_flag==false) {
						if((now.B.y>O.y && tmp.B.y<=O.y) && now.B.x == O.x) {
							b_flag = true;
						}
						if((now.R.y>O.y && tmp.R.y<=O.y) && now.R.x == O.x) {
							r_flag = true;
						}
						if(b_flag==false&&r_flag==true) {
							if((now.R.y<now.B.y) && now.R.x==now.B.x){
								tmp = new t_Pos(roll(tmp.B,i),tmp.R,now.cnt+1);
								if((now.B.y>O.y && tmp.B.y<=O.y) && now.B.x == O.x) {
									b_flag = true;
								}
							}
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
							return tmp.cnt;
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
					int [] v_tmp2 = {tmp.B.x,tmp.B.y,tmp.R.x,tmp.R.y};
					for(int l=0;l<visit.size();l++) {
						if((visit.get(l)[0]==v_tmp2[0])&&(visit.get(l)[1]==v_tmp2[1])&&(visit.get(l)[2]==v_tmp2[2])&&(visit.get(l)[3]==v_tmp2[3])) {
							v_flag = true;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && v_flag==false) {
						if((now.B.x<O.x && tmp.B.x>=O.x) && now.B.y == O.y) {
							b_flag = true;
						}
						if((now.R.x<O.x && tmp.R.x>=O.x) && now.R.y == O.y) {
							r_flag = true;
						}
						if(b_flag==false&&r_flag==true) {
							if((now.R.x>now.B.x) && now.R.y==now.B.y){
								tmp = new t_Pos(roll(tmp.B,i),tmp.R,now.cnt+1);
								if((now.B.x<O.x && tmp.B.x>=O.x) && now.B.y == O.y) {
									b_flag = true;
								}
							}
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
							return tmp.cnt;
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
					int [] v_tmp2 = {tmp.B.x,tmp.B.y,tmp.R.x,tmp.R.y};
					for(int l=0;l<visit.size();l++) {
						if((visit.get(l)[0]==v_tmp2[0])&&(visit.get(l)[1]==v_tmp2[1])&&(visit.get(l)[2]==v_tmp2[2])&&(visit.get(l)[3]==v_tmp2[3])) {
							v_flag = true;
						}
					}
					if((tmp.B!=now.B || tmp.R!=now.R) && v_flag==false) {
						if((now.B.x>O.x && tmp.B.x<=O.x) && now.B.y == O.y) {
							b_flag = true;
						}
						if((now.R.x>O.x && tmp.R.x<=O.x) && now.R.y == O.y) {
							r_flag = true;
						}
						if(b_flag==false&&r_flag==true) {
							if((now.R.x<now.B.x) && now.R.y==now.B.y){
								tmp = new t_Pos(roll(tmp.B,i),tmp.R,now.cnt+1);
								if((now.B.x>O.x && tmp.B.x<=O.x) && now.B.y == O.y) {
									b_flag = true;
								}
							}
						}
						if(b_flag == false && r_flag == false) {
							q.offer(tmp);
						}
						else if(r_flag == true && b_flag == false ) {
							return tmp.cnt;
						}
					}
				}
			}
		}
		return -1;
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
	/*
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
	*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		Pos B = new Pos(0,0);
		Pos R = new Pos(0,0);
		map = new char [n][m];
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