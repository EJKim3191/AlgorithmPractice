package boj_0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_2178 {
	public static int N;
	public static int M;
	public static int[][] map;
	public static boolean[][] isTrue;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int[N][M];
		isTrue = new boolean[N][M];
		// ¸Ê ÇÒ´ç
		for(int i=0; i<N; i++) {
			String temp = bfr.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		bfs();
		return;
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int answer = Integer.MAX_VALUE;
		q.add(new Point(0,0,0));
		isTrue[0][0] = true;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i=0; i<4; i++) {
				int fx = temp.x+dx[i];
				int fy = temp.y+dy[i];
				// exception
				if(fx>=M || fx<0 || fy>=N || fy<0) continue;
				if(isTrue[fy][fx]) continue;
				if(map[fy][fx]==0) continue;
				if(fy==N-1 && fx==M-1) {
					answer = answer > temp.distance+1 ? temp.distance+1 : answer;
				}
				if(map[fy][fx]==1) {
					q.add(new Point(fy,fx,temp.distance+1));
					isTrue[fy][fx]=true;
				}
			}
		}
		System.out.println(answer+1);
	}
	static class Point{
		int x, y, distance;

		public Point(int y, int x, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
	}
}
