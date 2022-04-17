package boj_0313;

import java.io.*;
import java.util.*;

public class boj_15900 {
	public static int N, a, b;
	public static ArrayList<ArrayList<Integer>> arr;
	public static boolean[] isTrue;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		N = Integer.parseInt(str.nextToken());
		arr = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<N-1; i++) {
			str = new StringTokenizer(bfr.readLine());
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		answer = 0;
		isTrue = new boolean[N+1];
		dfs(1,0);
		if(answer%2==0) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
	}
	public static void dfs(int node, int depth) {
		isTrue[node] = true;
		
		for(int next : arr.get(node)) {
			if(!isTrue[next]) {
				dfs(next, depth+1);
			}
		}
		if(node!=1 && arr.get(node).size() == 1) {
			answer+=depth;
		}
		
	}
}
