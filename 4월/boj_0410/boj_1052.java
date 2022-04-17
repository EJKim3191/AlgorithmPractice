package boj_0410;
import java.util.*;


import java.io.*;

public class boj_1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int answer = 0;
		while(true) {
			int count = 0;
			int temp = N+answer;
			while(temp>0) {
				if(temp%2!=0) {
					count++;
				}
				temp/=2;
			}
			
			
			if(count<=k) break;
			answer++;
		}

		System.out.println(answer);
	}
}
