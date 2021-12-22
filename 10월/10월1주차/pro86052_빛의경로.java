package pro1002;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

class pro86052 {
	public static char[][] map;
	public static boolean[][][] isTrue;
	public static int R;
	public static int C;
	// 아래, 오, 위, 왼
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Queue<Point> q = new LinkedList<>();
	public static ArrayList<Integer> answer1 = new ArrayList<>();

	public static void main(String[] args) {
		String str[] = { "SL", "LR" };
		int[] answer = solution(str);
		for (int temp : answer) {
			System.out.println(temp);
		}
	}

	public static int[] solution(String[] grid) {
		R = grid.length;
		C = grid[0].length();
		map = new char[R][C];
		isTrue = new boolean[R][C][4];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = grid[i].charAt(j);
			}
		}
		bfs();
		int[] answer = new int[answer1.size()];
		int size = 0;
		for (int temp : answer1) {
			answer[size++] = temp;
		}
		Arrays.sort(answer);
		return answer;
	}

	public static void bfs() {
		// 0 아래 1 오 2 위 3 왼
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int d = 0; d < 4; d++) {
					if (isTrue[i][j][d])
						continue;
					q.add(new Point(j, i, d));
					int count = 0;
					while (!q.isEmpty()) {
						Point temp = q.poll();
						// 방문한 방, 방향 일 때
						if (isTrue[temp.y][temp.x][temp.dir]) {
							q.clear();
							break;
						}
						isTrue[temp.y][temp.x][temp.dir] = true;

						int k = temp.dir;

						int hx = temp.x + dx[k];
						int hy = temp.y + dy[k];
						if (hx < 0)
							hx = C - 1;
						else if (hx >= C)
							hx = 0;
						if (hy < 0)
							hy = R - 1;
						else if (hy >= R)
							hy = 0;
						if (map[hy][hx] == 'R') {
							k = temp.dir - 1;
							if (k < 0)
								k += 4;
						}
						if (map[hy][hx] == 'L') {
							k = temp.dir + 1;
							if (k >= 4)
								k -= 4;
						}
						q.add(new Point(hx, hy, k));

						count += 1;
					}
					answer1.add(count);
				}

			}
		}

	}

	static class Point {
		int x;
		int y;
		int dir;

		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

}
