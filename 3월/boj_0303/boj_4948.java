package boj_0303;

import java.io.*;
import java.util.*;
// 에라토스테네스의 체
public class boj_4948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(bfr.readLine());
			if(n==0) break;
			int count = 0;
			boolean[] num = new boolean[2*n+1];
			num[0]=false;
			num[1]=false;
			for(int i=2; i<=2*n; i++) num[i]=true;
			for(int i=2; i<=2*n; i++) {
				for(int j=2; j*i<=2*n; j++) {
					num[i*j]=false;
				}
			}
			for(int i=n+1; i<num.length; i++) {
				if(num[i]) count++;
			}
			System.out.println(count);
		}
	}
}
