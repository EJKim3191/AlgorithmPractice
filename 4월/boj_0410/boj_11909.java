package boj_0410;

import java.util.*;


import java.io.*;

public class boj_11909 {

	public static int[][] map;

	public static int[] dx = {0,1};
	public static int[] dy = {1,0};
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		n = Integer.parseInt(bfr.readLine());
		map = new int[n][n];


		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		int answer;
		answer = bfs(0,0);
		System.out.println(answer);
	}
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0));
		int answer = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node tempNode = q.poll();
			int px = tempNode.x;
			int py = tempNode.y;
			int tempCost = tempNode.cost;
			if(px==n-1 && py ==n-1) {
				answer = answer > tempCost ? tempCost: answer; 
			}
			
			for(int i=0; i<2; i++) {
				int kx = px+dx[i];
				int ky = py+dy[i];
				if(kx<0 || kx>=n || ky<0 || ky>=n) continue;
				if(map[py][px]<=map[ky][kx]) {
					tempCost+=map[ky][kx]-map[py][px]+1;
				}
				q.add(new Node(kx, ky, tempCost));
			}
		}
		return answer;
	}
	public static class Node{
		int x, y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
	}
}
