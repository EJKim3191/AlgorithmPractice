package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//주석은 ArrayList를 활용 but----> 메모리 초과
public class boj2606 {
	public static int N;
	public static int nodeNum;
	//public static ArrayList<Node> arr=new ArrayList<>();
	public static int[][] arr;
	public static Queue<Integer> q = new LinkedList<>();
	public static boolean[] isInfected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		N= Integer.parseInt(bfr.readLine());
		isInfected = new boolean[N+1];
		arr = new int[N+1][N+1];
		nodeNum=Integer.parseInt(bfr.readLine());
		
		for(int i=0 ; i<nodeNum; i++) {
			str=new StringTokenizer(bfr.readLine());
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			//arr.add(new Node(from, to));
			arr[from][to]=1;
			arr[to][from]=1;
		}
		q.add(1);
		isInfected[1]=true;
		
		bfs();
		int result=0;
		for(int i=1; i<N+1; i++) {
			if(isInfected[i]==true) result+=1;
		}
		//1번컴퓨터를 제외한
		System.out.println(result-1);
	}
	//항상 1
	public static void bfs() {
		while(!q.isEmpty()) {
			int start = q.poll();
//			for(int i=0; i<arr.size(); i++) {
//				if(arr.get(i).from==start) {
//					q.add(arr.get(i).to);
//					isInfected[arr.get(i).to]=true;
//				}
//			}
			for(int i=1; i<arr.length; i++) {
				if(isInfected[i]!=true && arr[start][i]==1) {
					isInfected[i]=true;
					q.add(i);
				}
			}
		}
	}
}
class Node{
	int from; int to;
	public Node(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}
}
