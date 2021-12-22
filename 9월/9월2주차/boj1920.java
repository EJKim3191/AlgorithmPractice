package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		StringBuilder sb= new StringBuilder();
		//입력부: 빈칸 존재 시 stringtokenizer, 없을 시 charAt으로 가능
		
		int N = Integer.parseInt(bfr.readLine());
		//변수 선언
		int[] A= new int[N];
		Queue<Integer> queue= new LinkedList<>();
		boolean loop=true;
		str= new StringTokenizer(bfr.readLine());
		//A[N]
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(str.nextToken());
		}
		int M = Integer.parseInt(bfr.readLine());
		
		str= new StringTokenizer(bfr.readLine());
		
		for(int i=0; i<M; i++) {
			queue.add(Integer.parseInt(str.nextToken()));
		}
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			loop=true;
			for(int i=0; i<N; i++) {
				if(A[i]==temp) {
					sb.append("1").append("\n");
					loop=false;
					break;
				}
			}
			if(loop) {
				sb.append("0").append("\n");
			}
		}
		
		System.out.print(sb);
		bfr.close();
		
	}
}
