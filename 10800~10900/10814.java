import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// BOJ - 10814 

public class Main{
	
	public static class Saram{
		int age;
		String name;
		
		public Saram(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public int compare(Saram s1, Saram s2) {
		if(s1.age>s2.age) return 1;
		else if(s1.age<s2.age) return -1;
		else return 0;
	}
	
	public static void main(String [] args)
	{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Saram [] s_ary = new Saram [n];
		for (int i = 0; i < n; ++i)
		{
			s_ary[i] = new Saram(scn.nextInt(),scn.nextLine());
		}
		scn.close();
		Arrays.sort(s_ary, new Comparator<Saram>() {
			@Override
			public int compare(Saram s1, Saram s2) {
				if(s1.age>s2.age) return 1;
				else if(s1.age<s2.age) return -1;
				else return 0;
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(s_ary[i].age + s_ary[i].name);
		}
	}
}