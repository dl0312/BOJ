//	BOJ - 14889
//	Algorithm - ?
//	Samsung SW

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int [][] synergy_ad;
	static int sum_synergy=0;
	static int [] synergy_ary;
	static Stack<Integer> st = new Stack<Integer>();
	static int min_diff;
	static int people_num = 0;


	public static int total_synergy( int [] team) {
		int synergy = 0;
		for(int i=0;i<team.length;i++) {
			for(int j=i+1;j<team.length;j++) {
				synergy += synergy_ad[team[i]][team[j]];
				synergy += synergy_ad[team[j]][team[i]];
			}
		}
		return synergy;
	}
	
	public static void split_team( int [] start){
		int [] link = new int[start.length];
		int cnt=0;
		int diff;
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < synergy_ary.length; i++){
            if(idx2 >= start.length || start[idx2] != i){
               link[idx1] = i;
               idx1++;
            }
            else{
               idx2++;
            }
        }
//        System.out.println("start: " + Arrays.toString(start));
//        System.out.println("link: " + Arrays.toString(link));
		diff = Math.abs(total_synergy(start) - total_synergy(link));
//		System.out.println("diff: " + diff);
		if(diff<min_diff) {
			min_diff = diff;
		}
	}

	static void printPick(Stack<Integer> st){
		for(int i:st)
			System.out.print(synergy_ary[i]+" ");
		System.out.println();
	}
	
	public static int diff_pick(Stack<Integer> st){
		int diff;
		int sum=0;
		for(int i=0;i<people_num/2;i++) {
			
		}
		return Math.abs(sum_synergy/2-sum);
	}

	public static void pick(int n,Stack<Integer> st,int r){
		int diff=0;
		int [] team;
		int cnt=0;
		if(r==0) {
//			printPick(st);
			team = new int [people_num/2];
			cnt=0;
			for(int i:st) {
				team[cnt] = synergy_ary[i];
				cnt++;
			}
			split_team(team);
		}
		int smallest = st.isEmpty() ? 0 : st.lastElement() + 1; 

		for(int next = smallest; next < n; next++){
			st.push(next);
			pick(n,st,r - 1);
			st.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] total;
		int cnt = 0;
		int tmp_sum=0;
		Scanner scn = new Scanner(System.in);
		people_num = scn.nextInt();
		int total_case_num = people_num*(people_num-1)/2;
		synergy_ary = new int[people_num];
		total = new int [people_num+1];
		for(int i=0;i<people_num;i++) {
			total[i] = i;
		}
		synergy_ad = new int [people_num][people_num];
		for(int i=0;i<people_num;i++) {
			for(int j=0;j<people_num;j++) {
				synergy_ad[i][j] = scn.nextInt();
				sum_synergy+=synergy_ad[i][j];
			}
		}
		for(int i=0;i<people_num;i++) {
			synergy_ary[i] = i;
		}
		min_diff = sum_synergy;
		pick(people_num,st,people_num/2);
		System.out.println(min_diff);
	}
}