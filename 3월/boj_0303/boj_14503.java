package boj_0303;

/* 현재 위치를 청소한다.
현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 */
import java.util.*;

import java.io.*;

public class boj_14503 {
	public static int N, M;
	public static int r, c, d;
	public static int[][] map;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		d = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		robotFunc(r,c,d);
		
		System.out.println(answer);
		bfr.close();

	}
	public static void robotFunc(int row, int col, int dir) {
		//1
		if(map[row][col]==0) {
			map[row][col]=-1;
			answer++;
		}
		//2
		int before = dir;
		boolean isCleaned=false;
		for(int i=0; i<4; i++) {
			int fd=(dir+3)%4;
			int fr=row+dy[fd];
			int fc=col+dx[fd];
			
			if(fr>0 && fr<N && fc>0 && fc<M) {
				if(map[fr][fc]==0) {
					robotFunc(fr,fc,fd);
					isCleaned=true;
					break;
				}
			}
			dir=(dir+3)%4;
		}
		if(!isCleaned) {
			int td = (before+2)%4;
			int tr = row+dy[td];
			int tc = col+dx[td];
			
			if(tr>0 && tr<N && tc>0 && tc<M) {
				if(map[tr][tc]!=1) {
					robotFunc(tr, tc, before);
				}
			}
		}
	}
}
