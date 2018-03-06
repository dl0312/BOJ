import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 1966
//	Algorithm - Queue

public class Main {
	
	public static class Ele{
		int prior = 0;
		boolean target = false;
		
		public Ele(int prior) {
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int paper_num;
		int target_num;
		int cnt = 0;
		boolean poll_flag = true;
		while(t-->0) {
			cnt = 0;
			LinkedList<Ele> q = new LinkedList<>();
			paper_num = scn.nextInt();
			target_num = scn.nextInt();
			for(int i=0;i<paper_num;i++) {
				Ele tmp = new Ele(scn.nextInt());
				if(i==target_num) {
					tmp.target = true;
				}
				q.add(tmp);
			}
			while(true){
				poll_flag = true;
				int tmp = q.peek().prior;
				for(Ele e:q) {
					if(tmp<e.prior) {
						Ele tmp2 = q.poll();
						q.add(tmp2);
						poll_flag = false;
						break;
					}
				}
				if(poll_flag==true) {
					cnt++;
					if(q.poll().target==true) {
						System.out.println(cnt);
						break;
					}
				}
			}
		}
	}
}