import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 10828
//	Algorithm - Stack

public class Main {
	
	static Stack<Integer> s = new Stack<Integer>();
	static int n;	//	the number of case
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		for(int i=0;i<n;i++) {
			String str = scn.next();
			if(str.equals("push")) {
				s.push(scn.nextInt());
			}
			else if(str.equals("pop")) {
				if(s.isEmpty()) {
					System.out.println(-1);
				}
				else System.out.println(s.pop());
			}
			else if(str.equals("size")) {
				System.out.println(s.size());
			}
			else if(str.equals("empty")) {
				if(s.isEmpty()==true) System.out.println(1);
				else System.out.println(0);
			}
			else if(str.equals("top")) {
				if(s.isEmpty()) {
					System.out.println(-1);
				}
				else System.out.println(s.peek());
				
			}
		}
		scn.close();
	}
}