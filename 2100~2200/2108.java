import java.math.BigInteger;
import java.util.Scanner;

//	BOJ - 2108
//	Algorithm - Sorting

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int [] arr = new int [num];
		int [] all_integer = new int [8001];
		int cnt=0;
		int tmp_mode_num=0;
		int tmp_mode_cnt=0;
		int first_num=0;
		int last_num=0;
		boolean first_flag = false;
		boolean mode_dup = false;
		BigInteger sum = new BigInteger("0");
		for(int i=0;i<num;i++) {
			arr[i] = scn.nextInt();
			sum = sum.add(BigInteger.valueOf(arr[i]));
			all_integer[arr[i]+4000]++;
		}
		if(sum.intValue()>=0) {
			if( sum.remainder(BigInteger.valueOf(num)).multiply(BigInteger.valueOf(2)).intValue() >= BigInteger.valueOf(num).intValue()) {
				System.out.println(sum.divide(BigInteger.valueOf(num)).add(BigInteger.valueOf(1)));
			}
			else System.out.println(sum.divide(BigInteger.valueOf(num)));
		}
		else {
			if( sum.multiply(BigInteger.valueOf(-1)).remainder(BigInteger.valueOf(num)).multiply(BigInteger.valueOf(2)).intValue() >= BigInteger.valueOf(num).intValue()) {
				System.out.println(sum.divide(BigInteger.valueOf(num)).add(BigInteger.valueOf(-1)));
			}
			else System.out.println(sum.divide(BigInteger.valueOf(num)));
		}
		for(int i=0;i<8001;i++) {
			cnt+=all_integer[i];
			if(cnt>=num/2+1) {
				System.out.println((i-4000));
				break;
			}
		}
		for(int i=0;i<8001;i++) {
			if(all_integer[i]>0 && first_flag == false) {
				first_num = i-4000;
				last_num = i-4000;
				first_flag=true;
//				System.out.println(" first_num: " + first_num);
			}
			if(all_integer[i]>0) {
				last_num = i-4000;
			}
			if(all_integer[i] == tmp_mode_cnt && mode_dup == false) {
				tmp_mode_num = i-4000;
				mode_dup = true;
			}
			else if(all_integer[i]>tmp_mode_cnt) {
				tmp_mode_cnt = all_integer[i];
				tmp_mode_num = i-4000;
				mode_dup = false;
			}
		}
		System.out.println(tmp_mode_num);
		System.out.println((last_num-first_num));
	}

}