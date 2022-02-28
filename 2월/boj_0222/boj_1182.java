package boj_0222;

import java.io.*;
import java.util.*;

public class boj_1182 {
	public static int N;
	public static int S;
	public static int[] map;
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		map = new int[N];
		
		str = new StringTokenizer(bfr.readLine());
		for(int i=0; i<N; i++) {
			map[i]=Integer.parseInt(str.nextToken());
		}
		Arrays.sort(map);
		permu(0, 0, 0);	
		System.out.println(answer);
	}
	public static void permu(int index, int result, int count) {
		if(index==N) {
			if(result==S && count!=0) {
		
			answer++;
			}
			return;
		}
		
		permu(index+1, map[index]+result, count+1);
		permu(index+1, result, count);
	}
}
