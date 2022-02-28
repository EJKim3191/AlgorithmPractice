package boj_0227;

import java.util.*;
import java.io.*;

public class boj_7490 {
	public static int caseNum, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		caseNum = Integer.parseInt(bfr.readLine());
		for(int i=0;i<caseNum; i++) {
			N = Integer.parseInt(bfr.readLine());
			dfs(N, 1, 1, 1, 0, "1");
			System.out.println();
		}
		
	}
	public static void dfs(int k, int index, int num, int sign, int sum, String str) {
		if(k==index) {
			sum+=sign*num;
			if(sum==0) {
				System.out.println(str);
			}
			return;
		}

		dfs(k, index+1, num*10+(index+1), sign, sum, str+" "+Integer.toString(index+1));
		dfs(k, index+1, index+1, 1, sum+(num*sign), str+"+"+Integer.toString(index+1));
		dfs(k, index+1, index+1, -1, sum+(num*sign), str+"-"+Integer.toString(index+1));
	}

}
