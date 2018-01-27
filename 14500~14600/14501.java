import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14501
//	Algorithm - DP
//	Samsung SW

public class Main {
	
	private static day [] schedule;
	private static int n;
	private static int max_profit=0;
	
	private static class day{
		int t;
		int p;
		
		public day(int t,int p) {
			this.t = t;
			this.p = p;
		}
	}
	
	public static void resignation(){
		profit(0,0,0);
	}
	public static void profit(int pivot, int profit,int depth){
		int cnt=0;
		int save_profit,save_pivot;
		for(int i=pivot;i<n;i++,cnt++) {
			if(schedule[i].p==0 || schedule[i].t + pivot > n ) {
				if(profit>max_profit) {
					max_profit = profit;
				}
			}
			else {
				profit+=schedule[i].p;
				pivot+=(schedule[i].t+cnt);
				profit(pivot,profit,depth+1);
				profit-=schedule[i].p;
				pivot-=(schedule[i].t+cnt);
			}
		}
		if(pivot >= n ) {
			if(profit>max_profit) {
				max_profit = profit;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		schedule = new day [n];
		for(int i=0;i<n;i++) {
			int tmp_t = scn.nextInt();
			int tmp_p = scn.nextInt();
			schedule[i] = new day(tmp_t,tmp_p);
			if(schedule[i].t+i>n) {
				schedule[i].p = 0;
			}
		}
		scn.close();
		resignation();
		System.out.println(max_profit);
	}
}