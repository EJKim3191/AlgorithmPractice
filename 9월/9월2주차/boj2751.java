package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class boj2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bfr.readLine());
		//인티져
		//primitive data type 이아닌 객체의 배열
		Integer[] sort = new Integer[N];
		for(int i=0; i<N; i++) {
			sort[i]=Integer.parseInt(bfr.readLine());
		}
		Arrays.sort(sort);
		
		//내림차순
		//Arrays.sort(sort, Collections.reverseOrder());
		for(int i=0; i<sort.length; i++) {
			sb.append(sort[i]+"\n");			
		}
		System.out.print(sb.toString());
	}
}
