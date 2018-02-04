import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14500
//	Algorithm - ?

public class Main {
		
	static int [][] paper;
	

	public static int bar_horizental(int x,int y) { // ㅡ
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+2][y];
		point += paper[x+3][y];
		return point;
	}
	public static int bar_vertical(int x,int y) { // ㅣ
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x][y+2];
		point += paper[x][y+3];
		return point;
	}
	public static int square(int x,int y) { // ㅁ
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		return point;
	}
	public static int warm_1(int x,int y) { // ㄹ 가로 뒤집기
		int point = 0;
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		point += paper[x][y+1];
		point += paper[x][y+2];
		return point;
	}
	public static int warm_1_rotate(int x,int y) { // ㄹ 가로 뒤집기 돌리기
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		point += paper[x+2][y+1];
		return point;
	}
	public static int warm_2(int x,int y) { // ㄹ
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x+1][y+1];
		point += paper[x+1][y+2];
		return point;
	}
	public static int warm_2_rotate(int x,int y) { // ㄹ 돌리기
		int point = 0;
		point += paper[x][y+1];
		point += paper[x+1][y+1];
		point += paper[x+1][y];
		point += paper[x+2][y];
		return point;
	}
	public static int gun_1(int x,int y) { // 위에 보는 총 손잡이 오른쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x][y+1];
		point += paper[x][y+2];
		return point;
	}
	public static int gun_1_rotate_1(int x,int y) { // 오른쪽 보는 총 손잡이 아래쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x+1][y+1];
		point += paper[x+2][y+1];
		return point;
	}
	public static int gun_1_rotate_2(int x,int y) { // 아래 보는 총 손잡이 왼쪽
		int point = 0;
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		point += paper[x+1][y+2];
		point += paper[x][y+2];
		return point;
	}
	public static int gun_1_rotate_3(int x,int y) { // 왼쪽 보는 총 손잡이 위쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+2][y];
		point += paper[x+2][y+1];
		return point;
	}
	
	public static int gun_2(int x,int y) { // 위에 보는 총 손잡이 왼쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		point += paper[x+1][y+2];
		return point;
	}
	
	public static int gun_2_rotate_1(int x,int y) { // 오른쪽 보는 총 손잡이 위쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+2][y];
		point += paper[x][y+1];
		return point;
	}
	
	public static int gun_2_rotate_2(int x,int y) { // 아래쪽 보는 총 손잡이 오른쪽
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x][y+2];
		point += paper[x+1][y+2];
		return point;
	}
	
	public static int gun_2_rotate_3(int x,int y) { // 왼쪽 보는 총 손잡이 아래쪽
		int point = 0;
		point += paper[x][y+1];
		point += paper[x+1][y+1];
		point += paper[x+2][y+1];
		point += paper[x+2][y];
		return point;
	}
	
	public static int oh(int x,int y) { // ㅗ
		int point = 0;
		point += paper[x][y];
		point += paper[x+1][y];
		point += paper[x+2][y];
		point += paper[x+1][y+1];
		return point;
	}
	public static int oh_rotate_1(int x,int y) { // ㅏ
		int point = 0;
		point += paper[x][y];
		point += paper[x][y+1];
		point += paper[x][y+2];
		point += paper[x+1][y+1];
		return point;
	}
	public static int oh_rotate_2(int x,int y) { // ㅜ
		int point = 0;
		point += paper[x][y+1];
		point += paper[x+1][y+1];
		point += paper[x+1][y];
		point += paper[x+2][y+1];
		return point;
	}
	public static int oh_rotate_3(int x,int y) { // ㅓ
		int point = 0;
		point += paper[x+1][y];
		point += paper[x+1][y+1];
		point += paper[x][y+1];
		point += paper[x+1][y+2];
		return point;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int result;
		int max_num=0;
		paper = new int [n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				paper[i][j] = scn.nextInt();
			}
		}
		for(int i=0;i<n-3;i++) {
			for(int j=0;j<m;j++) {
				result = bar_horizental(i,j);
				if(result>max_num) {
					max_num=result;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m-3;j++) {
				result = bar_vertical(i,j);
				if(result>max_num) {
					max_num=result;
				}
			}
		}
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				result = square(i,j);
				if(result>max_num) {
					max_num=result;
				}
			}
		}
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-1;j++) {
				result = warm_1_rotate(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = warm_2_rotate(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_1_rotate_1(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_1_rotate_3(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_2_rotate_1(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_2_rotate_3(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = oh(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = oh_rotate_2(i,j);
				if(result>max_num) {
					max_num=result;
				}
			}
		}
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				result = warm_1(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = warm_2(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_1_rotate_2(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_1(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_2(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = gun_2_rotate_2(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = oh_rotate_1(i,j);
				if(result>max_num) {
					max_num=result;
				}
				result = oh_rotate_3(i,j);
				if(result>max_num) {
					max_num=result;
				}
			}
		}
		System.out.print(max_num);
		scn.close();
	}
}