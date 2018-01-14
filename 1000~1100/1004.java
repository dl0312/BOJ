//	BOJ - 1004
//	Algorithm - ?

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	private static class planet{
		
		int x,y,r;
		public planet(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int str_x,str_y,end_x,end_y;
		int t_num = scn.nextInt();
		int planet_num;
		int tmp_x,tmp_y,tmp_r;
		int cnt=0;
		planet [] planet_array;
		int [] planet_state;		// -1 : str only in the planet, 1 : end only in the planet, 0 : str, end both in the planet or out of the planet
		for(int i=0;i<t_num;i++) {
			cnt =0;
			str_x = scn.nextInt();
			str_y = scn.nextInt();
			end_x = scn.nextInt();
			end_y = scn.nextInt();
			planet_num = scn.nextInt();
			planet_array = new planet [planet_num];
			planet_state = new int [planet_num];
			for(int j=0;j<planet_num;j++) {
				tmp_x = scn.nextInt();
				tmp_y = scn.nextInt();
				tmp_r = scn.nextInt();
				planet_array[j] = new planet(tmp_x,tmp_y,tmp_r);
				if(Math.pow((str_x-planet_array[j].x),2)+Math.pow((str_y-planet_array[j].y),2)<Math.pow(planet_array[j].r, 2) 
						&& Math.pow((end_x-planet_array[j].x),2)+Math.pow((end_y-planet_array[j].y),2)>Math.pow(planet_array[j].r, 2)) {
					planet_state[j] = -1;
					cnt++;
				}
				else if(Math.pow((str_x-planet_array[j].x),2)+Math.pow((str_y-planet_array[j].y),2)>Math.pow(planet_array[j].r, 2)
						&& Math.pow((end_x-planet_array[j].x),2)+Math.pow((end_y-planet_array[j].y),2)<Math.pow(planet_array[j].r, 2)) {
					planet_state[j] = 1;
					cnt++;
				}
				else planet_state[j] = 0;
			}
			System.out.println(cnt);
		}
		
	}
}
