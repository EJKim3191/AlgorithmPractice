package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11052_dp {
	public static int N;
	public static int[] p;
	public static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		N=Integer.parseInt(bfr.readLine());
		p = new int[N+1];
		d = new int[N+1];
		str = new StringTokenizer(bfr.readLine());
		for(int i=1; i<=N; i++) {
			int temp=Integer.parseInt(str.nextToken());
			p[i]=temp;
		}
		/*dp 이해하기---> 동적 프로그래밍, 쉽게 말해, 이전 과정들을 다 기억한다
		 * 	문제 적용---> 점화식 세우기 , d[i]=p[j]+d[i-j]
		 */
		d[0]=0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<=i; j++) {
				d[i]=Math.max(d[i],p[j]+d[i-j]);
			}
		}
		System.out.println(d[N]);
	}
}
