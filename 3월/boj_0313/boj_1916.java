package boj_0313;

import java.util.*;
import java.io.*;

public class boj_1916 {
	public static int N, M;
	public static ArrayList<Node>[] arr;
	public static int[] distance;
	public static PriorityQueue<Node> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		N = Integer.parseInt(bfr.readLine());
		M = Integer.parseInt(bfr.readLine());
		
		arr = new ArrayList[N+1];
		distance = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(bfr.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			arr[start].add(new Node(end, cost));
		}
		int start, end;
		str=new StringTokenizer(bfr.readLine());
		start = Integer.parseInt(str.nextToken());
		end = Integer.parseInt(str.nextToken());
		
		distance[start] = 0;
		dij(start);
		int answer = distance[end];
		System.out.println(answer);

	}
	public static void dij(int start) {
		pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int vertex = temp.vertex;
			int cost = temp.cost;
			if(distance[vertex]<cost)continue;
			for(int i=0; i<arr[vertex].size(); i++) {
				int tempVertex = arr[vertex].get(i).vertex;
				int tempCost = arr[vertex].get(i).cost+cost;
				if(distance[tempVertex]>tempCost) {
					distance[tempVertex]=tempCost;
					pq.add(new Node(tempVertex, tempCost));
				}
			}
		}
	}
	public static class Node implements Comparable<Node>{
		int vertex, cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost-o.cost;
		}
	}
}
