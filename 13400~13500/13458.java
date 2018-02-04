import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 13458
//	Algorithm - ?

public class Main {
	static int b_direct;
	static int c_direct;
	
	public static int exam_direct(int examinee_num) {
		int direct_num=0;
		examinee_num-=b_direct;
		direct_num++;
		if(examinee_num>0) {
			direct_num+=examinee_num/c_direct;
			if(examinee_num%c_direct>0) {
				direct_num++;
			}
		}
		return direct_num; 
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int exam_room_num = scn.nextInt();
		int [] examinee_num = new int [exam_room_num];
		for(int i=0;i<exam_room_num;i++) {
			examinee_num[i] = scn.nextInt();
		}
		long direct_num=0;
		b_direct = scn.nextInt();
		c_direct = scn.nextInt();
		for(int i=0;i<exam_room_num;i++) {
			direct_num += exam_direct(examinee_num[i]);
		}
		System.out.println(direct_num);
		scn.close();
	}
}