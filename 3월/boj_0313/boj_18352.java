package boj_0313;

import java.io.*;
import java.util.*;

public class boj_18352 {
	public static int N, M, K, X;
	public static int[] distance;
	public static ArrayList<Node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		X = Integer.parseInt(str.nextToken());
		
		distance = new int[N+1];
		arr = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			distance[i]=Integer.MAX_VALUE;
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(bfr.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			arr[start].add(new Node(end, 1));
		}
		distance[X] = 0;
		dj();
		boolean isTrue=false;
		for(int i=0; i<distance.length; i++) {
			if(distance[i]==K) {
				isTrue=true;
				System.out.println(i);
			}
		}
		if(!isTrue) {
			System.out.println(-1);
		}
	}
	public static void dj() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X,0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int ver = temp.ver;
			int dis = temp.dis;
			if(distance[ver]<dis) continue;
			for(int i=0; i<arr[ver].size(); i++) {
				int tempVer = arr[ver].get(i).ver;
				int tempDis = arr[ver].get(i).dis+dis;
				if(distance[tempVer]>tempDis) {
					distance[tempVer] = tempDis;
					pq.add(new Node(tempVer, tempDis));
				}
			}
		}
	}
	public static class Node implements Comparable<Node>{
		int ver, dis;
		public Node(int ver, int dis) {
			this.ver = ver;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node o) {
			return dis-o.dis;
		}
	}

}
