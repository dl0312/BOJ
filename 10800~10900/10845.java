
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 1016
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		LinkedList<Integer> q = new LinkedList<>();
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		String trash = scn.nextLine();
		String command;
		while(t-->0) {
			command = new String(scn.next());
			if(command.equals("push")) {
				q.add(scn.nextInt());
			}
			else if(command.equals("pop")) {
				if(q.isEmpty()==true) {
					System.out.println(-1);
				}
				else {
					System.out.println(q.poll().intValue());
				}
			}
			else if(command.equals("size")) {
				System.out.println(q.size());
			}
			else if(command.equals("empty")) {
				if(q.isEmpty()==true) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(command.equals("front")) {
				if(q.isEmpty()==true) {
					System.out.println(-1);
				}
				else {
					System.out.println(q.getFirst().intValue());
				}
			}
			else if(command.equals("back")) {
				if(q.isEmpty()==true) {
					System.out.println(-1);
				}
				else {
					System.out.println(q.getLast().intValue());
				}
			}
		}
		scn.close();
	}
}