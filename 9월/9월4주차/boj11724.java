package algo0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724 {
	public static int N, M;
	public static int[][] arr;
	public static Queue<Integer> q=new LinkedList<>();
	public static int[] isUsed;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		str = new StringTokenizer(bfr.readLine());
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		arr= new int[N+1][N+1];
		isUsed=new int[N+1];
		Arrays.fill(isUsed, 0);
		for(int i=0; i<M; i++) {
			str=new StringTokenizer(bfr.readLine());
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			arr[from][to]=1;
			arr[to][from]=1;
		}
		int count = 0;
		for(int i=1; i<N+1; i++) {
			if(isUsed[i]==0) {
				count+=1;
				q.add(i);
				bfs(count);
			}
		}
		System.out.println(count);
	}
	public static void bfs(int count) {
		while(!q.isEmpty()) {
			int start = q.poll();
			for(int i=1; i<arr.length; i++) {
				if(isUsed[i]==0 && arr[start][i]==1) {
					q.add(i);
					isUsed[i]=count;
				}
			}
		}
	}
}

