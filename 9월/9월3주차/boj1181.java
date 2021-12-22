package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class boj1181 {
	public static int N;
	public static HashMap<String, Integer> hash = new HashMap<>();
	public static ArrayList<String> tempArr = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System .in));
		StringTokenizer str = null;
		StringBuilder sb = new StringBuilder();
		int length = 0;
		int max_length = 0;
		N = Integer.parseInt(bfr.readLine());
		for(int i=0; i<N; i++) {
			//중복은 한번만 출력-->map,set
			//키값은 고유의 문자열, 길이 비교
			String temp = bfr.readLine();
			length = temp.length();
			hash.put(temp, length);
			//max_length 구하기
			if(length > max_length) max_length=length;
		}
		//1차 생각--> value 길이로 키값을 가져와 비교
		//벨류값이 같을때 키값을 반환해주는 함수 정의
		for(int i=1; i<=max_length; i++) {
			if(hash.containsValue(i)) {
				getKey(i);
			}
			if(!tempArr.isEmpty()) {
				Collections.sort(tempArr);
				for(int n=0; n<tempArr.size(); n++) {
					sb.append(tempArr.get(n)).append("\n");
				}
				
			}
			tempArr.clear();
		}
		
		System.out.println(sb);
		bfr.close();
		
	}
	
	public static void getKey(int value) {
		for(String o: hash.keySet()) {
			if(hash.get(o).equals(value)) {
				tempArr.add(o);
			}
		}
	}
}
//속도가 빠른 아이디어----. 이중 arraylist로 같은 길이를 저장, 비교 and sort
