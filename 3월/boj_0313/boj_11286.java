package boj_0313;

import java.util.*;
import java.io.*;

public class boj_11286 {
	public static int N;
	public static PriorityQueue<Num> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(bfr.readLine());
		pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(bfr.readLine());
			if(input==0 && !pq.isEmpty()) {
				Num temp = pq.poll();
				System.out.println(temp.n);
			}
			else if(input==0 && pq.isEmpty()) {
				System.out.println("0");
			}
			else {
				pq.add(new Num(input));
			}
		}
		
	}
	public static class Num implements Comparable<Num>{
		int n;
		
		public Num(int n) {
			this.n = n;
		}
		@Override
		public int compareTo(Num target) {
			if(Math.abs(this.n)==Math.abs(target.n)) {
				return this.n <= target.n ? -1 : 1;
			}
			else return Math.abs(this.n) <= Math.abs(target.n) ? -1 : 1;
		}
	}
}
