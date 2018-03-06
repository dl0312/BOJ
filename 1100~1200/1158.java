import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 11866
//	Algorithm - Queue

public class Main {
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> remove = new LinkedList<>();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int pivot=m-1;
		for(int i=0;i<n;i++) {
			list.add(i+1);
		}
		while(true) {
			remove.add(list.remove(pivot));
			pivot--;
			if(list.isEmpty()==true) {
				break;
			}
			pivot+=m;
			if(pivot>=list.size()) {
				pivot%=list.size();
			}
		}
		System.out.print("<");
		while(true) {
			System.out.print(remove.poll());
			if(remove.isEmpty()==false) {
				System.out.print(", ");
			}
			else {
				System.out.print(">");
				break;
			}
		}
	}
}