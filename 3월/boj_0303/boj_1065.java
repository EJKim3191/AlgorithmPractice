package boj_0303;

import java.io.*;
import java.util.*;

public class boj_1065 {
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bfr.readLine());
		int answer=0;
		for(int i=1; i<=N; i++) {
			if(isAva(i)) answer++; 
		}
		System.out.println(answer);
	}
	public static boolean isAva(int n) {
		if(n<100) {
			return true;
		}
		String num = Integer.toString(n);
		int dif=0;
		boolean start = false;
		for(int i=0; i<num.length()-1; i++) {
			if(start) {
				if(dif!=(num.charAt(i+1)-'0')-(num.charAt(i)-'0')) {
					return false;
				}
			}
			dif=(num.charAt(i+1)-'0')-(num.charAt(i)-'0');
			start=true;
		}
		return true;
	}
}
