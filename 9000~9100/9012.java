import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 9012
//	Algorithm - Stack

public class Main {		
	static int n;	//	the number of case
	
	public static void print(Stack s) {
		System.out.println(s);
	}
	
	public static boolean is_pare(String str) {
		Stack<Character> s = new Stack<>();	
		char [] c_ary = str.toCharArray();
		for(char c : c_ary) {
			if(s.isEmpty()==false) {
				if(c=='(') {
					s.push(c);
				}
				if(c==')') {
					s.pop();
				}
			}
			else {
				if(c==')') {
					return false;
				}
				else {
					s.push(c);
				}
			}
		}
		if(s.isEmpty()==false) {
			return false;
		}
		else return true;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		String trash = scn.nextLine();
		for(int i=0;i<n;i++) {
			String str = scn.nextLine();
			if(is_pare(str)==true) {
				System.out.println("YES");
			}
			else System.out.println("NO");
		}
	}
}