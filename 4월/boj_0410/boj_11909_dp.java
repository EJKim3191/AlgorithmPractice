package boj_0410;

import java.util.*;


import java.io.*;

public class boj_11909_dp {

	public static int[][] map;
	public static int[][] dp;
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		n = Integer.parseInt(bfr.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==n-1 && j==n-1) break;
				if(i!=n-1) {
					if(map[i][j]<=map[i+1][j]) {
						
						dp[i+1][j] = Math.min(dp[i+1][j], map[i+1][j]-map[i][j]+1+dp[i][j]);
					}
					else {
						dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]);
					}
				}
				if(j!=n-1) {
					if(map[i][j]<=map[i][j+1]) {
						dp[i][j+1] = Math.min(dp[i][j+1], map[i][j+1]-map[i][j]+1+dp[i][j]);
					}
					else {
						dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]);
					}
				}
			}
		}

		System.out.println(dp[n-1][n-1]);
	}

}