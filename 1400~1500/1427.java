import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 1427
//	Algorithm - Sorting

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long num = scn.nextLong();
		char[] arr = Long.toString(num).toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();
		for(char c:arr) {
			list.add(c);
		}
		Collections.sort(list);
		Collections.reverse(list);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}
	}
}