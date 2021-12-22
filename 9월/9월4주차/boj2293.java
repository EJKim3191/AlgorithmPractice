package algo0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2293 {
	public static int n, k;
	public static int[] worth;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		str=new StringTokenizer(bfr.readLine());
		n=Integer.parseInt(str.nextToken());
		k=Integer.parseInt(str.nextToken());
		worth=new int[n+1];
		dp=new int[k+1];
		for(int i=1; i<n+1; i++) {
			worth[i]=Integer.parseInt(bfr.readLine());
		}
		dp[0]=1;
		Arrays.sort(worth);
		for(int i=1; i<worth.length; i++) {
			for(int j=worth[i]; j<k+1; j++) {
				dp[j] += dp[j-worth[i]];
			}
		}
		System.out.println(dp[k]);
		
	}
}
