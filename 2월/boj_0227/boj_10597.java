package boj_0227;

import java.util.*;
import java.io.*;

public class boj_10597 {
	public static String line;
	public static boolean[] isTrue;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		line = bfr.readLine();
		if(line.length()<=9) {
			N=line.length();
		}
		else {
			N=(line.length()+9)/2;
		}
		isTrue = new boolean[N+1];
		int[] arr = new int[N];
		dfs(0, 0, false, arr);
	}
	public static void dfs(int idx, int depth, boolean skipped, int[] arr) {
//		for(int i=0; i<arr.size(); i++) {
//			System.out.print(arr.get(i)+" ");
//		}
//		System.out.println();
		if(depth==N) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.exit(0);
		}
		if(idx>=line.length()) return;
		int num;
		if(skipped) {
			num=(line.charAt(idx-1)-'0')*10+line.charAt(idx)-'0';
		}
		else {
			num=line.charAt(idx)-'0';
		}
		if(num>N) return;
		if(num==0) return;
		if(isTrue[num] && skipped) return;
		if(isTrue[num] && !skipped) {
			dfs(idx+1, depth, true, arr);
			return;
		}
		isTrue[num]=true;
		arr[depth]=num;
		dfs(idx+1, depth+1, false, arr);
		isTrue[num]=false;
		dfs(idx+1, depth, true, arr);
	}
}
