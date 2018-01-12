//	BOJ - 1463
//	Algorithm - Dynamic Programming

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		int [] wayarray;
		Scanner scn = new Scanner(System.in);
		input = scn.nextInt();
		wayarray = new int [input+1];
		for(int i=0;i<input+1;i++) {
			wayarray[i] = 0;
		}
		checktheway(input,0,wayarray);
//		if(input==1) System.out.println(1);
//		else System.out.print(wayarray[1]);
		System.out.print(wayarray[1]);
	}
	
	public static void checktheway( int num, int count, int [] array ) {
		if(num%3==0) {
			if(array[num/3]==0 || array[num/3] > count+1) {
				array[num/3]=count+1;
				checktheway(num/3,count+1,array);
			}
		}
		if(num%2==0) {
			if(array[num/2]==0 || array[num/2] > count+1) {
				array[num/2] = count +1;
				checktheway(num/2, count+1, array);
			}
		}
		if((array[num-1] == 0 || array[num-1] > count+1 ) && num!=1 ) {
			array[num-1] = count+1;
			checktheway(num-1,count+1, array);
		}
	}
}
