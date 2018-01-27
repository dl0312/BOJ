import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14503
//	Algorithm - ?
//	Samsung SW

public class Main {
	
	private static class Pos{
		int x;
		int y;
		int wall;
		
		public Pos(int x, int y,int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int [] dx = {-1,0,1,0};
	private static int [] dy = {0,1,0,-1};
	private static int n,m;
	private static int [][] area;
	
	public static void cleaning(Pos robot, int dir) {
		boolean [][] cleaned = new boolean [n][m];
		int cleaned_area = 0;
		int rotation_num=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cleaned[i][j] = false;
			}
		}
		
		cleaned[robot.x][robot.y] = true;
		cleaned_area++;
		area[robot.x][robot.y] = 2;
		// 1 	로봇자리 청소
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(area[i]));
//		}
//		System.out.println("청소한 곳 : " + robot.x + ", " + robot.y);
//		System.out.println("청소한 영역 : " + cleaned_area);
		
		while(true) {
			if(cleaned[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == false 
				&& area[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] != 1) {
				// 2-1	왼쪽으로 돈 방향이 청소가 안되있으면서 벽이 아닌경우
				dir = (dir+3)%4;										
				// 2-1	왼쪽으로 회전
				robot.x += dx[dir];
				robot.y += dy[dir];										
				// 2-1 	해당방향 전진
				cleaned[robot.x][robot.y] = true;
				cleaned_area++;
				area[robot.x][robot.y] = 2;
				rotation_num=0;
				// 1 	로봇자리 청소
//				System.out.println("청소한 곳 : " + robot.x + ", " + robot.y);
//				System.out.println("방향 : " + dy[dir] + ", " + -1*dx[dir]);
//				System.out.println("청소한 영역 : " + cleaned_area);
			}
			else if(((cleaned[robot.x+1][robot.y+0]==true || area[robot.x+1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y+1]==true || area[robot.x+0][robot.y+1] == 1)
					&& (cleaned[robot.x-1][robot.y+0]==true || area[robot.x-1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y-1]==true || area[robot.x+0][robot.y-1] == 1))
						&& area[robot.x-dx[dir]][robot.y-dy[dir]] == 1) {	
				// 2-4	네 방향 모두 청소가 되어있거나 벽인경우이고 뒤에 벽이 있는 경우
				break;
				// 2-4	작동을 멈춘다.
			}
			else if(((cleaned[robot.x+1][robot.y+0]==true || area[robot.x+1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y+1]==true || area[robot.x+0][robot.y+1] == 1)
					&& (cleaned[robot.x-1][robot.y+0]==true || area[robot.x-1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y-1]==true || area[robot.x+0][robot.y-1] == 1))
						&& area[robot.x-dx[dir]][robot.y-dy[dir]] != 1) {	
					// 2-3 	네 방향 모두 청소가 되었거나 벽인경우이고 뒤에 벽이 없는 경우
					robot.x -= dx[dir];
					robot.y -= dy[dir];
					rotation_num = 0;
					// 2-3	바라보는 방향 유지한 채로 한 칸 후진하고 2번으로 
			}
			else if((cleaned[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == true 
					|| area[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == 1)
					&& rotation_num < 5) {
				dir = (dir+3)%4;
				rotation_num++;
				// 2-2 	왼쪽 방향에 청소할 공간이 없다면 일단 회전후 2번으로
			}
		}
		System.out.println(cleaned_area);
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		area = new int [n][m];
		int r = scn.nextInt();
		int c = scn.nextInt();
		int d = scn.nextInt();
		Pos robot = new Pos(r,c);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				area[i][j] = scn.nextInt();
			}
		}
		cleaning(robot,d);
	}
}