
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 2331
//	Algorithm - DFS BFS

public class Main {
	
	static int a;	// first num
	static int p;	// pow num
	static Queue<Element> q = new LinkedList<Element>();
	
	public static class Element{
		int n;
		int depth = 0;
		
		public Element(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
		
		public void print() {
			System.out.println("n: " + n + " depth: " + depth);
		}
	}
	
	public static int D(int n) {
		int result = 0;
		char [] ary = String.valueOf(n).toCharArray();
		for(int i=0;i<ary.length;i++) {
			result += Math.pow(ary[i]-48, p);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		a = scn.nextInt();
		p = scn.nextInt();
		int cnt;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(a);
		int tmp = D(a);
		while(true) {
			if(list.contains(tmp)) {
				break;
			}
			else list.add(tmp);
			tmp = D(tmp);
		}
		System.out.println(list.indexOf(tmp));
		scn.close();
	}
}