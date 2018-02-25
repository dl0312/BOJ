import java.math.BigInteger;
import java.util.Scanner;

//	BOJ - 1016
//	Algorithm - prime number

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long f = scn.nextLong();
		long s = scn.nextLong();
		long max = (long)Math.pow(s, 0.5);
		int cnt=0;
		boolean [] ary = new boolean [1000002];
		boolean [] ary2 = new boolean [1000002];
		for(int i=0;i<s-f+1;i++) {
			ary[i] = false;
		}
		for(int i=0;i<1000002;i++) {
			ary2[i] = false;
		}
		for(long i=2;i<=max;i++) {
			if(ary2[(int)i] == false) {
				//System.out.println(i);
				for(int j=1;j<1000002/(i*i);j++) {
					ary2[(int)(i*i)*j] = true;
				}
				long tmp_f=f/(long)(i*i);
				int div_f=(int)(f%(long)(i*i));
				long tmp_s=s/(long)(i*i);
				if(div_f==0) {
					for(long j=tmp_f;j<=tmp_s;j++) {
						//System.out.println((int) ((j-tmp_f)*Math.pow(i,2)));
						ary[(int) ((j-tmp_f)*(i*i))-div_f] = true;
					}
				}
				else {
					for(long j=tmp_f+1;j<=tmp_s;j++) {
						ary[(int) ((j-tmp_f)*(i*i))-div_f] = true;
					}
				}
			}
		}
		for(int i=0;i<s-f+1;i++) {
			if(ary[i] == false) {
				//System.out.println(i+f);
				cnt++;
			}
		}
		System.out.println(cnt);
		scn.close();
	}
}