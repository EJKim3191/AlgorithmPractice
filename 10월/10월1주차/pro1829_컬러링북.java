package pro1002;

import java.util.Queue;
import java.util.LinkedList;

public class pro1829 {

	public static Queue<Point> q = new LinkedList<>();
	public static boolean[][] isUsed;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int land;
	public static int R, C;
	public static void main(String[] args) {
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int[] k = solution(6, 4, picture);
		for(int i : k) {
			System.out.println(i);
		}
	}
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		R = m;
		C = n;
		isUsed = new boolean[R][C];
		land = 0;
		int count = 0;                    
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(isUsed[i][j]) continue;
				if (bfs(picture, i, j)) {
					count += 1;
				}
			}
		}

		numberOfArea = count;
		maxSizeOfOneArea = land;
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static boolean bfs(int[][] picture, int r, int c) {
		boolean result = false;
		if (!isUsed[r][c] && picture[r][c] != 0) {
			q.add(new Point(r, c));
			isUsed[r][c]=true;
			result = true;
			int tempLand = 1;
			while (!q.isEmpty()) {
				Point temp = q.poll();
				int beforeValue = picture[temp.y][temp.x];
				for (int i = 0; i < 4; i++) {
					
					int hx = temp.x + dx[i];
					int hy = temp.y + dy[i];
					// 범위밖
		
					if (hx < 0 || hx >= C || hy < 0 || hy >= R)
						continue;
					//사용된 것이면
					if (isUsed[hy][hx]) continue;
					// 0이면
					if (picture[hy][hx] == 0) continue;
					// 값이 다르면
					int afterValue = picture[hy][hx];
					if (afterValue != beforeValue) continue;
					
					// 조건 완성시
					q.add(new Point(hy, hx));
					isUsed[hy][hx] = true;
					tempLand += 1;
				}
			}
			land = Math.max(tempLand, land);
		}



		return result;
	}

	public static class Point {
		int x;
		int y;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
