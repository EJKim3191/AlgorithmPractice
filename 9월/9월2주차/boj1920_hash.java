package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1920_hash {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		StringBuilder sb= new StringBuilder();
		//입력부: 빈칸 존재 시 stringtokenizer, 없을 시 charAt으로 가능
		
		//hash를 쓰면 좋은점---> 중복값 제거?
		int N = Integer.parseInt(bfr.readLine());
		//변수 선언
		HashSet<Integer> hash = new HashSet<>();

		str= new StringTokenizer(bfr.readLine());
		//A[N]
		for(int i=0; i<N; i++) {
			int k=Integer.parseInt(str.nextToken());
			hash.add(k);
		}
		int M = Integer.parseInt(bfr.readLine());
		
		str= new StringTokenizer(bfr.readLine());
		
		for(int i=0; i<M; i++) {
			int temp=Integer.parseInt(str.nextToken());
			if(hash.contains(temp)) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}

		
		
		System.out.print(sb);
		bfr.close();
		
		
		//404ms , -->3등 코드랑 다른게 무엇일까? string을 써서 한 점?
		//2000-> 700ms
	}
}
