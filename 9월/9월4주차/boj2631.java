package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2631 {
	public static int N;
	public static int[] arr;
	public static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bfr.readLine());
		answer= new int[N];
		arr=new int[N];
		for(int i =0 ; i<N; i++) {
			arr[i]=Integer.parseInt(bfr.readLine());
			answer[i]=1;
		}
		int result=0;
		//오름차순이 아닌걸 이동--> 길이 -오름차순 길이=answer
		for (int k = 0; k < N; k++){
		    for (int i = 0; i < k; i++){
		        if(arr[i] < arr[k]){
		            answer[k] = Math.max(answer[k], answer[i] + 1);
		        }        
		        result=Math.max(result, answer[k]);
		    }
		}
		
		
		System.out.println(N-result);
	}
}
