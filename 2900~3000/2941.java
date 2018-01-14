//	BOJ - 2941
//	Algorithm - String Process

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int str_length = 0;
		int tmp_length = 0;
		int alpha_num = 0;
		str_length = str.length();
		if(str.contains("c=")) {
			tmp_length = str.length();
			str = str.replace("c=", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("c-")) {
			tmp_length = str.length();
			str = str.replace("c-", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("dz=")) {
			tmp_length = str.length();
			str = str.replace("dz=", " ");
			alpha_num += (tmp_length-str.length())/2;
		}
		if(str.contains("d-")) {
			tmp_length = str.length();
			str = str.replace("d-", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("lj")) {
			tmp_length = str.length();
			str = str.replace("lj", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("nj")) {
			tmp_length = str.length();
			str = str.replace("nj", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("s=")) {
			tmp_length = str.length();
			str = str.replace("s=", " ");
			alpha_num += (tmp_length-str.length());
		}
		if(str.contains("z=")) {
			tmp_length = str.length();
			str = str.replace("z=", " ");
			alpha_num += (tmp_length-str.length());
		}
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=' ') alpha_num++;
		}
		System.out.print(alpha_num);
	}
}
