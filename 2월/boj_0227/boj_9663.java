package boj_0227;

import java.util.*;
import java.io.*;

//일차원 배열을 열과 행으로 생각 -> index 열, 원소 값 행

public class boj_9663 {
	public static int N;
	public static int[] queen;
	public static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bfr.readLine());
		queen = new int[N];
		findQueen(0);
		System.out.println(answer);
	}
	public static void findQueen(int col) {
		if(col == N) {
			answer++;
			return;
		}
		for(int i=0; i<N; i++) {
			queen[col]=i;
			if(isQueen(col)) {
				findQueen(col+1);
			}
		}
	}
	public static boolean isQueen(int col) {
		for(int i=0; i<col; i++) {
			if(queen[col] == queen[i]) return false;
			if(Math.abs(col-i) == Math.abs(queen[col]-queen[i])) return false;
		}
		return true;
	}
}
