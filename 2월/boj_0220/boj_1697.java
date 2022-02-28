package boj_0220;

import java.io.*;
import java.util.*;

public class boj_1697 {
	public static int su;
	public static int bro;
	public static boolean[] isTrue = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		su = Integer.parseInt(str.nextToken());
		bro = Integer.parseInt(str.nextToken());
		// 순간이동은 앞으로 밖에 못함-> 수빈이가 뒤로 가야할때는 걷기 밖에 안됨
		if(su==bro) {
			System.out.println("0");
			return;
		}
		if(su>bro) {
			System.out.println(su-bro);
			return;
		}
		bfs();
		return;
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		isTrue[su]=true;
		q.add(new Point(su, 0));
		while(!q.isEmpty()) {
			Point temp = q.poll();
			//3가지 길
			int fx;
			for(int i=0; i<3; i++) {
				if(i==0) {
					fx = temp.value*2;
				}
				else if(i==1) {
					fx = temp.value+1;
				}
				else {
					fx = temp.value-1;
				}
				if(fx>100000 || fx<0) continue;
				if(isTrue[fx]) continue;
				if(fx==bro) {
					System.out.println(temp.depth+1);
					return;
				}
				isTrue[fx]=true;
				q.add(new Point(fx, temp.depth+1));
			}
		}
	}
	static class Point{
		int value, depth;
		public Point(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}
	}
}
