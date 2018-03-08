import java.util.Scanner;

public class Main
{
	public static final long INF = Long.MAX_VALUE;
	public static long[] dp = new long[1 << 20];
	public static long[] height = new long[20];
	public static long[] weight = new long[20];
	public static long[] power = new long[20];
	public static long[] sum = new long[1 << 20];
	public static void main(String [] args)
	{
		Scanner scn = new Scanner(System.in);
		int n;
		int h;
		n = scn.nextInt();
		h = scn.nextInt();
		for (int i = 0; i < n; ++i)
		{
			height[i] = scn.nextLong();
			weight[i] = scn.nextLong();
			power[i] = scn.nextLong();
		}
		for (int i = 0; i < (1 << n); ++i)
		{
			dp[i] = -INF;
		}
		for (int i = 0; i < n; ++i)
		{
			dp[1 << i] = power[i];
		}

		for (int i = 0; i < (1 << n); ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				if ((i & 1 << j) != 0)
				{
					sum[i] += height[j];
					continue;
				}
				if (dp[i] >= weight[j])
				{
					dp[i | 1 << j] = Math.max(dp[i | 1 << j], Math.min(dp[i] - weight[j], power[j]));
				}
			}
		}
		long ans = -INF;
		for (int i = 0; i < (1 << n); ++i)
		{
			if (sum[i] >= h)
			{
				ans = Math.max(ans, dp[i]);
			}
		}
		if (ans >= 0)
		{
			System.out.print(ans);
			System.out.print(' ');
		}
		else
		{
			System.out.print("Mark is too tall");
			System.out.print(' ');
		}
	}
}