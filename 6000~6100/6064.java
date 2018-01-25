import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 6064
//	Algorithm - Find a rule

public class Main {

	public static long lcm(long a, long b) {
		int gcd_value = gcd((int)a, (int)b);

		if (gcd_value == 0) return 0; // 인수가 둘다 0일 때의 에러 처리

		    return Math.abs( (a * b) / gcd_value );
	}
	
	public static int gcd(int a, int b) {
	    while (b != 0) {
	      int temp = a % b;
	      a = b;
	      b = temp;
	    }
	    return Math.abs(a);
	  }
	 
	private static class calender{
		
		int m,n;
		
		public calender(int m,int n) {
			this.m = m;
			this.n = n;
		}
		
		public long year(int target_x, int target_y) {
			long cnt = 1;
			int x = 1;
			int y = 1;
			long lcm = lcm((long)m,(long)n);
			if(target_x<=m) {
				cnt = target_x;
				x = target_x;
			}
			else return -1;
			y = x%n;
			if(y==0) {
				y = n;
			}
			while(true) {
				if(target_x == x && target_y == y && lcm >= cnt) {
					break;
				}
				if(lcm+m < cnt) {
					return -1;
				}
				cnt += m;
				y = (y+m)%n;
				if(y==0) {
					y = n;
				}
			}
			return cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test_num = scn.nextInt();
		int m,n,x,y;
		for(int i=0;i<test_num;i++) {
			m = scn.nextInt();
			n = scn.nextInt();
			x = scn.nextInt();
			y = scn.nextInt();
			calender cal = new calender(m,n);
			System.out.println(cal.year(x, y));
		}
		scn.close();
	}
}