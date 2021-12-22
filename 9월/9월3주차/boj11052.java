package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj11052 {
	public static int N;
	public static ArrayList<Integer> keyArr = new ArrayList<>();
	public static HashMap<Integer, Double> hash = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		N=Integer.parseInt(bfr.readLine());
		str = new StringTokenizer(bfr.readLine());
		for(int i=1; i<=N; i++) {
			int temp=Integer.parseInt(str.nextToken());
			hash.put(i,(double)temp/i);
			keyArr.add(i);
		}
		Collections.sort(keyArr, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
		int num=N;
		int sum=0;
		for(int i=0; i<N; i++) {
			int key = keyArr.get(i);
			if(num>=key) {
				int temp=num/key;
				num%=key;
				sum+=temp*hash.get(key)*key;
				if(num==0) break;
			}
				
		}
		System.out.println(sum);
	}
}
