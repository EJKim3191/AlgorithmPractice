package boj_0227;

import java.util.*;
import java.io.*;

public class boj_16987 {
	public static int N, answer;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		N = Integer.parseInt(bfr.readLine());
		arr = new int[N][2];
//		boolean[] isTrue = new boolean[N];
		for(int i=0; i<N; i++) {
			str=new StringTokenizer(bfr.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
		}
		answer=0;
		dfs(0,0);
		System.out.println(answer);
	}
	public static void dfs(int index, int count) {
		if(index==N) {
			answer=Math.max(answer, count);
			return;
		}
		// 더이상 깰것이 없을 때
		if(arr[index][0]<=0 || count==N-1) {
			dfs(index+1, count);
			return;
		}
		int beforeCount = count;
		for(int i=0; i<N; i++) {
			if(i==index) continue;
			if(arr[i][0]<=0) continue;
			arr[i][0]-=arr[index][1];
			arr[index][0]-=arr[i][1];
			if(arr[i][0]<=0) count++;
			if(arr[index][0]<=0) count++;
			dfs(index+1, count);
			
			arr[i][0]+=arr[index][1];
			arr[index][0]+=arr[i][1];
			count=beforeCount;
		}
	}
}
