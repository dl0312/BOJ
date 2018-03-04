import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 10025
//	Algorithm - Segment tree

public class Main {
	
	static int [] arr = new int [4000000];
	static int [] node = new int [20000000];
	
	private static int sumNode(int nodeNum, int start, int end, int x, int y) {
		int result = 0;
		if(y<start || x>end) return result;
		if(start>=x && end<=y) return node[nodeNum]; 
		result += sumNode(nodeNum*2, start, (start+end)/2, x, y);
		result += sumNode(nodeNum*2+1, (start+end)/2 +1, end, x, y);
		return result;
	}
	
	private static void updateNode(int nodeNum, int start, int end, int x, int diff) {
		if(x < start || x > end) return;
		if(x>=start && x<=end){
			node[nodeNum] += diff;
			if(start == end) return;
		} 
		updateNode(nodeNum*2, start, (start+end)/2, x, diff);
		updateNode(nodeNum*2+1, (start+end)/2 +1, end, x, diff);
	} 
	private static int initNode(int nodeNum, int start, int end) {
		double result = 0; 
		if(start == end){
			node[nodeNum] = arr[start];
			return node[nodeNum];
		} 
		node[nodeNum] = initNode(nodeNum*2, start, (start+end)/2) + initNode(nodeNum*2+1, (start+end)/2 +1, end);
		return node[nodeNum];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int bucket_num = scn.nextInt();
		int range = scn.nextInt();
		int max_pos = 0;
		int max_ice = 0;
		int pos;
		int ice;
		for(int i=0;i<4000000;i++) {
			arr[i] = 0;
		}
		for(int i=0;i<bucket_num;i++) {
			ice = scn.nextInt();
			pos = scn.nextInt();
			arr[pos] = ice;
			if(pos>max_pos) {
				max_pos = pos;
			}
		}
		initNode(1,0,max_pos);
		for(int i=0;i<range;i++) {
			int ice_amount = sumNode(1,0,max_pos,0,i+range);
			if(max_ice<ice_amount) {
				max_ice = ice_amount;
			}
		}
		for(int i=range;i<=max_pos-range;i++) {
			int ice_amount = sumNode(1,0,max_pos,i-range,i+range);
			if(max_ice<ice_amount) {
				max_ice = ice_amount;
			}
		}
		System.out.println(max_ice);
		scn.close();
	}
}