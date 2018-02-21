import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 2504
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
				else if(c=='[') {
					s.push(c);
				}
				else if(c==')') {
					if(s.peek()=='(') s.pop();
					else return false;
				}
				else if(c==']') {
					if(s.peek()=='[') s.pop();
					else return false;
				}
			}
			else {
				if(c==')' || c==']') {
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
	
	public static int pare(String str) {
		Stack<Character> s = new Stack<>();
		Stack<Integer> cal = new Stack<>();
		boolean flag = false;
		char [] c_ary = str.toCharArray();
		for(char c : c_ary) {
			print(s);
			print(cal);
			if(c=='(') {
				if(s.isEmpty()==false) {
					if(s.peek()!='n') {
						flag = false;
					}
					else flag = true;
				}
				s.push(c);
			}
			else if(c==')') {
				if(s.peek()=='(') {
					s.pop();
					s.push('n');
					cal.push(2);
					if(flag == true) {
						int tmp2 = cal.pop();
						int tmp3 = cal.pop();
						cal.push(tmp2+tmp3);
						s.pop();
						s.pop();
						if(s.isEmpty()==false) {
							if(s.peek()!='n') {
								flag = false;
							}
							else flag = true;
						}
						s.push('n');
					}
				}
				else if(s.peek()=='n') {
					int tmp = cal.pop()*2;
					cal.push(tmp);
					s.pop();
					s.pop();
					if(s.isEmpty()==false) {
						if(s.peek()!='n') {
							flag = false;
						}
						else flag = true;
					}
					s.push('n');
					if(flag == true) {
						int tmp2 = cal.pop();
						int tmp3 = cal.pop();
						cal.push(tmp2+tmp3);
						s.pop();
						s.pop();
						if(s.isEmpty()==false) {
							if(s.peek()!='n') {
								flag = false;
							}
							else flag = true;
						}
						s.push('n');
					}
				}
			}
			else if(c=='[') {
				if(s.isEmpty()==false) {
					if(s.peek()!='n') {
						flag = false;
					}
					else flag = true;
				}
				s.push(c);
			}
			else if(c==']') {
				if(s.peek()=='[') {
					s.pop();
					s.push('n');
					cal.push(3);
					if(flag == true) {
						int tmp2 = cal.pop();
						int tmp3 = cal.pop();
						cal.push(tmp2+tmp3);
						s.pop();
						s.pop();
						if(s.isEmpty()==false) {
							if(s.peek()!='n') {
								flag = false;
							}
							else flag = true;
						}
						s.push('n');
					}
				}
				else if(s.peek()=='n') {
					int tmp = cal.pop()*3;
					cal.push(tmp);
					s.pop();
					s.pop();
					if(s.isEmpty()==false) {
						if(s.peek()!='n') {
							flag = false;
						}
						else flag = true;
					}
					s.push('n');
					if(flag == true) {
						int tmp2 = cal.pop();
						int tmp3 = cal.pop();
						cal.push(tmp2+tmp3);
						s.pop();
						s.pop();
						if(s.isEmpty()==false) {
							if(s.peek()!='n') {
								flag = false;
							}
							else flag = true;
						}
						s.push('n');
					}
				}
			}
		}
		if(cal.isEmpty()) {
			return 0;
		}
		else return cal.pop();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		if(is_pare(str)==true) {
			System.out.println(pare(str));
		}
		else System.out.println(0);
	}
}