import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 1181
//	Algorithm - sorting

public class Main {
	static int n;
	
	private static class Str{
		String str;
		int len;
		
		public Str(String str) {
			this.str = str;
			this.len = str.length();
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LinkedList<Str> list = new LinkedList<Str>();
		n = scn.nextInt();
		String [] str_ary = new String [n];
		String trash = scn.nextLine();
		for(int i=0;i<n;i++) {
			str_ary[i] = scn.nextLine();
			list.add(new Str(str_ary[i]));
		}
		Collections.sort(list, new Comparator<Str>(){
			@Override
			public int compare(Str str1,Str str2){
				if(str1.len<str2.len) {
					return -1;
				}
				else if(str1.len==str2.len) {
					int i=0;
					while(true) {
						if(i==str1.len) {
							return 0;
						}
						if(str1.str.charAt(i)<str2.str.charAt(i)) {
							return -1;
						}
						else if(str1.str.charAt(i)>str2.str.charAt(i)) {
							return 1;
						}
						else if(str1.str.charAt(i)==str2.str.charAt(i)) {
							i++;
						}
					}
				}
				else return 1;
			}
		});
		System.out.println(list.get(0).str);
		for(int i=1;i<list.size();i++) {
			if(list.get(i).str.equals(list.get(i-1).str)==false) {
				System.out.println(list.get(i).str);
			}
		}
		scn.close();
	}
}