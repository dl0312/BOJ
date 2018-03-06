import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 10649
//	USACO December 2014 Contest Gold 1©ö©ª
//	Algorithm - BFS

public class Main {
	
	static Queue<Stack_cow> q = new LinkedList<Stack_cow>();
	
	public static class Cow{
		long h;
		long w;
		long p;
		public Cow(long h,long w, long p) {
			this.h = h;
			this.w = w;
			this.p = p;
		}
	}
	
	public static class Stack_cow{
		LinkedList<Integer> list = new LinkedList<>();
		long p;
		long h;
		public Stack_cow(LinkedList<Integer> list, long p,long h) {
			for(int i=0;i<list.size();i++) {
				this.list.add(list.get(i));
			}
			
			this.p = p;
			this.h = h;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long h = scn.nextLong();
		long max_pow = 0;
		Cow [] cow_ary = new Cow[n];
		for(int i=0;i<n;i++) {
			cow_ary[i] = new Cow(scn.nextLong(),scn.nextLong(),scn.nextLong());
		}
		scn.close();
		for(int i=0;i<n;i++) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(i);
			Stack_cow tmp = new Stack_cow(list,cow_ary[i].p,cow_ary[i].h);
			q.add(tmp);
		}
		while(!q.isEmpty()) {
			Stack_cow now = q.poll();
			if(now.h>=h) {
				if(max_pow<=now.p) {
					max_pow = now.p;
//					System.out.println(now.list);
				}
			}
			for(int i=0;i<n;i++) {
				if(now.list.contains(i)==false && now.p>=cow_ary[i].w) {
					if(cow_ary[i].p<now.p-cow_ary[i].w) {
						if(max_pow<=now.p-cow_ary[i].w) {
							Stack_cow tmp = new Stack_cow(now.list,cow_ary[i].p,now.h+cow_ary[i].h);
							tmp.list.add(i);
							q.add(tmp);
						}
					}
					else {
						if(max_pow<cow_ary[i].p) {
							Stack_cow tmp = new Stack_cow(now.list,now.p-cow_ary[i].w,now.h+cow_ary[i].h);
							tmp.list.add(i);
							q.add(tmp);
						}
					}
				}
			}
		}
		System.out.println(max_pow);
	}
}