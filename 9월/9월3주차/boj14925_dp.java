package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14925_dp {
	public static int M, N;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		str = new StringTokenizer(bfr.readLine());
		M = Integer.parseInt(str.nextToken()); // 세로
		N = Integer.parseInt(str.nextToken()); // 가로

		map = new int[M][N];
		int temp_max = 0;
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(str.nextToken());
				if(temp==0)
					map[i][j] = 1;
				else map[i][j] = 0;
				
				if(map[i][j]==1 && i!=0 && j!=0) {
					map[i][j]=Math.min(map[i][j-1], Math.min(map[i-1][j], map[i-1][j-1]))+1;
				}
				temp_max=Math.max(temp_max, map[i][j]);					
			}
		}

		System.out.println(temp_max);
	}
		
}
