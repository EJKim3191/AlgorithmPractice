package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1026 {
	public static int N;
	public static ArrayList<Integer> A = new ArrayList<>();
	public static ArrayList<Integer> B = new ArrayList<>();
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		N=Integer.parseInt(bfr.readLine());
		str = new StringTokenizer(bfr.readLine());
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(str.nextToken()));
		}
		str = new StringTokenizer(bfr.readLine());
		for(int i=0; i<N; i++) {
			B.add(Integer.parseInt(str.nextToken()));
		}
		//B까지 재정렬하면 매우 쉬움----> 정렬 서로 역순으로 하면 답
		//B 정렬 X
		//일단 A정렬
		//원소는 0~99
		Collections.sort(A);

		int answer=0;
		int count=A.size()-1;
		for(int i=0; i<=100 ; i++) {
			if(B.isEmpty()) break;
			while(B.contains(i)) {
				answer+=A.get(count)*i;
				count-=1;
				B.remove((Object)i); //int 값이 들어가면 인덱스로 지워질 우려--->유지하려면 flag 사용하자
			}
		}
		System.out.println(answer);
	}
}
