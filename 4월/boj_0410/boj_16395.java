package boj_0410;
import java.util.*;

import java.io.*;
public class boj_16395 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int answer = fibonacci(n,k);
		System.out.println(answer);
	}
	public static int fibonacci(int y, int x) {
		
		if(x==1 || x==y) {
			return 1;
		}
		
		return fibonacci(y-1, x-1)+fibonacci(y-1,x);
	}
}
