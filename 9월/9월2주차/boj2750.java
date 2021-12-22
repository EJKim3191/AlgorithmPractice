package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class boj2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bfr.readLine());
		int[] sort = new int[N];
		for(int i=0; i<N; i++) {
			sort[i]=Integer.parseInt(bfr.readLine());
		}
		Arrays.sort(sort);
		for(int i=0; i<sort.length; i++) {
			sb.append(sort[i]+"\n");			
		}
		System.out.print(sb.toString());
	}
}
//ArrayList,collection sort-->172, array sort---->160 차이 무의미
