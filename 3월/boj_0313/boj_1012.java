package boj_0313;

import java.util.*;
import java.io.*;

public class boj_1012 {
	public static int T, M, N, K;
	public static int[][] map;
	public static boolean[][] isTrue;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		T = Integer.parseInt(bfr.readLine());
		for(int t=0; t<T; t++) {
			int answer = 0;
			str = new StringTokenizer(bfr.readLine());
			M = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			map = new int[N][M];
			isTrue = new boolean[N][M];
			
			for(int k=0; k<K; k++) {
				str = new StringTokenizer(bfr.readLine());
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				
				map[y][x] = 1;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if (map[i][j]==1 && !isTrue[i][j]) {
						bfs(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
	public static void bfs(int y, int x) {
		Queue<Cord> q = new LinkedList<>();
		q.add(new Cord(x,y));
		while(!q.isEmpty()) {
			Cord tempC = q.poll();
			int tempX = tempC.x;
			int tempY = tempC.y;
			for(int i=0; i<4; i++) {
				int fx = tempX+dx[i];
				int fy = tempY+dy[i];
				if(fx<0 || fx>=M || fy<0 || fy>=N) continue;
				if(map[fy][fx]!=1 || isTrue[fy][fx]) continue;
				isTrue[fy][fx]=true;
				q.add(new Cord(fx, fy));
			}
		}
	}
	public static class Cord{
		int x, y;
		public Cord(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
