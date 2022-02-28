package boj_0220;

import java.util.*;
import java.io.*;

public class boj_1068 {
	public static int N;
	public static int[] parent;
	public static boolean[] isTrue;
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		parent = new int[N];
		isTrue = new boolean[N];
		int rootNode=0;
		str = new StringTokenizer(bfr.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(str.nextToken());
			if(temp==-1) {
				parent[i]=i;
				rootNode = i;
				continue;
			}
			parent[i]=temp;
		}
		
		int deletedNode = Integer.parseInt(bfr.readLine()); 
		deleteNode(deletedNode);
		count(rootNode);
		System.out.println(answer);
		return;
	}
	public static void deleteNode(int index) {
		parent[index]=Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			if(parent[i]==index) {
				deleteNode(i);
			}
		}
	}
	public static void count(int index) {
		boolean isLeaf = true;
		isTrue[index] = true;
		if(parent[index]==Integer.MIN_VALUE) return;
		for(int i=0; i<N; i++) {
			if(parent[i]==index && !isTrue[i]) {
				count(i);
				isLeaf = false;
			}
			
		}
		if(isLeaf) {
			
			answer++;
		}
	}

}
