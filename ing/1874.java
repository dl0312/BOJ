import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 1874
//	Algorithm - Stack

public class Main {
	
	static Stack<Integer> s = new Stack<Integer>();			//	채워나갈 거
	static Queue<Integer> q = new LinkedList<Integer>();	//	[1,2,3,4,...]
	static LinkedList<Integer> list = new LinkedList<>();	//	[4,3,6,8,...]
	static LinkedList<Character> figure = new LinkedList<>();
	static int n;	//	the number of case
	
	public static void print(Stack s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		int target_l=0;
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(in.readLine()));
			q.add(i+1);
		}
		while(true) {
			if(target_l==n) {
				for(int i=0;i<figure.size();i++) {
					System.out.println(figure.get(i));
				}
				break;
			}
			if(s.isEmpty()==false) {
				if(s.peek()==list.get(target_l)) {
					figure.add('-');
					s.pop();
					target_l++;
				}
				else {
					if(q.isEmpty()==true && target_l!=n) {
						System.out.println("NO");
						break;
					}
					else {
						figure.add('+');
						int tmp = q.poll();
						s.push(tmp);
					}
				}
			}
			else {
				figure.add('+');
				int tmp = q.poll();
				s.push(tmp);
			}
		}
	}
}