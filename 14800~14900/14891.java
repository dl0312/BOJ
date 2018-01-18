// BOJ - 14891
// Samsung

import java.util.Scanner;

public class Main {
	
	private static class Wheel{
		int [] array = new int [8];
		
		public Wheel(int [] array) {
			this.array = array;
		}
	}
	
	public static Wheel rotate (Wheel wheel, int rotation_dir) {
		int [] tmp = new int [8];
		Wheel rotated = new Wheel(tmp);
		if(rotation_dir==1) {						// clockwise dir
			rotated.array[0] = wheel.array[7];
			for(int i=0;i<7;i++) {
				rotated.array[i+1] = wheel.array[i];
			}
		}
		else if(rotation_dir==-1) {					// counter clockwise dir
			rotated.array[7] = wheel.array[0];
			for(int i=1;i<8;i++) {
				rotated.array[i-1] = wheel.array[i];
			}
		}
		return rotated;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp_n;
		int rotation_num;
		int rotation_wheel;
		int rotation_dir;
		int result=0;
		boolean [] pow_ary = new boolean [3];	//	if it's true S,N or N,S pow_ary[i] => 1,2's
		Wheel [] wheel_ary = new Wheel[4];
		
		Scanner scn = new Scanner(System.in);
		
		for(int j=0;j<4;j++) {
			int [] tmp_ary = new int [8];
			String n_to_string = scn.nextLine();
			for(int i=0;i<8;i++) {
				tmp_ary[i] = n_to_string.charAt(i)-48;
			}
			wheel_ary[j] = new Wheel(tmp_ary);
		}
		
		rotation_num = scn.nextInt();
		for(int i=0;i<rotation_num;i++) {
			for(int j=0;j<3;j++) {
				if(wheel_ary[j].array[2]!=wheel_ary[j+1].array[6]) {
					pow_ary[j] = true;
				}
				else pow_ary[j] = false;
			}
			rotation_wheel = scn.nextInt();
			rotation_dir = scn.nextInt();
			wheel_ary[rotation_wheel-1] = rotate(wheel_ary[rotation_wheel-1],rotation_dir);
			if(rotation_wheel>=2) { // left
				if(pow_ary[rotation_wheel-2]==true) {
					wheel_ary[rotation_wheel-2] = rotate(wheel_ary[rotation_wheel-2],rotation_dir*(-1));
					if(rotation_wheel>=3) { // left
						if(pow_ary[rotation_wheel-3]==true) {
							wheel_ary[rotation_wheel-3] = rotate(wheel_ary[rotation_wheel-3],rotation_dir);
							if(rotation_wheel==4) { // left
								if(pow_ary[rotation_wheel-4]==true) {
									wheel_ary[rotation_wheel-4] = rotate(wheel_ary[rotation_wheel-4],rotation_dir*(-1));
								}
							}
						}
					}
				}
			}
			if(rotation_wheel>=1 && rotation_wheel<=3) { // right
				if(pow_ary[rotation_wheel-1]==true) {
					wheel_ary[rotation_wheel] = rotate(wheel_ary[rotation_wheel],rotation_dir*(-1));
					if(rotation_wheel<=2) { // right
						if(pow_ary[rotation_wheel]==true) {
							wheel_ary[rotation_wheel+1] = rotate(wheel_ary[rotation_wheel+1],rotation_dir);
							if(rotation_wheel==1) { // right
								if(pow_ary[rotation_wheel+1]==true) {
									wheel_ary[rotation_wheel+2] = rotate(wheel_ary[rotation_wheel+2],rotation_dir*(-1));
								}
							}
						}
					}
				}
			}
		}
		for(int i=0;i<4;i++) {
			result += Math.pow(2,i)*wheel_ary[i].array[0];
		}
		System.out.print(result); 
	}
}
