package boj_0417;
import java.util.*;

import java.io.*;

public class boj_3190 {
	public static int N;
	public static int K; //����� ����
	public static int L; // ������ȯ ��
	public static int[][] map; // ��� = 2, ��= 1
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static Queue<Info> info = new LinkedList<>();
	public static Queue<Tail> tail = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		N = Integer.parseInt(bfr.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(bfr.readLine());
		for(int i=0; i<K; i++) {
			str = new StringTokenizer(bfr.readLine());
			int y = Integer.parseInt(str.nextToken());
			int x = Integer.parseInt(str.nextToken());
			map[y-1][x-1] = 2;
		}
		L = Integer.parseInt(bfr.readLine());
		for(int i=0; i<L; i++) {
			str = new StringTokenizer(bfr.readLine());
			int time = Integer.parseInt(str.nextToken());
			char direction = str.nextToken().charAt(0);
			info.add(new Info(time, direction));
		}
		int answer = simulate();
		System.out.println(answer);
	}
	public static int simulate() {
		int time = 0;
		int dir = 0;
		int x = 0;
		int y = 0;
		map[y][x]=1;
		tail.add(new Tail(y,x));
		while(true) {
			time+=1;
			//���� �Ӹ� �̵�
			int fx = x+dx[dir];
			int fy = y+dy[dir];

			//���̸� ��... ���� �΋H���� ��...
			if(fx<0 || fx>=N || fy<0 || fy>=N) { 
				break;
				}
			if(map[fy][fx]==1) { 
				break;
				}
			tail.add(new Tail(fx, fy));
			//����� �ִ°�?
			if(map[fy][fx]==2) {
				map[fy][fx]=1;
			}
			// ����� ���ٸ�
			else {
				Tail tempTail = tail.poll();
				map[fy][fx]=1;
				map[tempTail.y][tempTail.x]=0;
			}
			if(!info.isEmpty() && info.peek().time==time) {
				Info tempInfo = info.poll();
				if(tempInfo.direction=='D') {
					// ������
					dir=(dir+1)%4;
				}
				else {
					//����
					dir=(dir+3)%4;
				}
			}
			x=fx;
			y=fy;
			
		}
		
		return time;
		
	}
	public static class Info{
		int time;
		char direction;
		public Info(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}
	public static class Tail{
		int x;
		int y;
		public Tail(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
}
