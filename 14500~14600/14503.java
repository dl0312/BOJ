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
		// 1 	�κ��ڸ� û��
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(area[i]));
//		}
//		System.out.println("û���� �� : " + robot.x + ", " + robot.y);
//		System.out.println("û���� ���� : " + cleaned_area);
		
		while(true) {
			if(cleaned[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == false 
				&& area[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] != 1) {
				// 2-1	�������� �� ������ û�Ұ� �ȵ������鼭 ���� �ƴѰ��
				dir = (dir+3)%4;										
				// 2-1	�������� ȸ��
				robot.x += dx[dir];
				robot.y += dy[dir];										
				// 2-1 	�ش���� ����
				cleaned[robot.x][robot.y] = true;
				cleaned_area++;
				area[robot.x][robot.y] = 2;
				rotation_num=0;
				// 1 	�κ��ڸ� û��
//				System.out.println("û���� �� : " + robot.x + ", " + robot.y);
//				System.out.println("���� : " + dy[dir] + ", " + -1*dx[dir]);
//				System.out.println("û���� ���� : " + cleaned_area);
			}
			else if(((cleaned[robot.x+1][robot.y+0]==true || area[robot.x+1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y+1]==true || area[robot.x+0][robot.y+1] == 1)
					&& (cleaned[robot.x-1][robot.y+0]==true || area[robot.x-1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y-1]==true || area[robot.x+0][robot.y-1] == 1))
						&& area[robot.x-dx[dir]][robot.y-dy[dir]] == 1) {	
				// 2-4	�� ���� ��� û�Ұ� �Ǿ��ְų� ���ΰ���̰� �ڿ� ���� �ִ� ���
				break;
				// 2-4	�۵��� �����.
			}
			else if(((cleaned[robot.x+1][robot.y+0]==true || area[robot.x+1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y+1]==true || area[robot.x+0][robot.y+1] == 1)
					&& (cleaned[robot.x-1][robot.y+0]==true || area[robot.x-1][robot.y+0] == 1)
					&& (cleaned[robot.x+0][robot.y-1]==true || area[robot.x+0][robot.y-1] == 1))
						&& area[robot.x-dx[dir]][robot.y-dy[dir]] != 1) {	
					// 2-3 	�� ���� ��� û�Ұ� �Ǿ��ų� ���ΰ���̰� �ڿ� ���� ���� ���
					robot.x -= dx[dir];
					robot.y -= dy[dir];
					rotation_num = 0;
					// 2-3	�ٶ󺸴� ���� ������ ä�� �� ĭ �����ϰ� 2������ 
			}
			else if((cleaned[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == true 
					|| area[robot.x+dx[(dir+3)%4]][robot.y+dy[(dir+3)%4]] == 1)
					&& rotation_num < 5) {
				dir = (dir+3)%4;
				rotation_num++;
				// 2-2 	���� ���⿡ û���� ������ ���ٸ� �ϴ� ȸ���� 2������
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