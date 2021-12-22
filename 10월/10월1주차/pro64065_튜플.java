package pro1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class pro64065 {
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		int[] answer=solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		for(int k: answer) {
			System.out.println(k);
		}
	}

	public static int[] solution(String s) {
		s=s.substring(2,s.length()-2);
		boolean[] isTrue = new boolean[100001];
		isTrue[0]=true;
		String[] temp = s.split("},\\{");
		Arrays.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		int[][] number = new int[temp.length][temp.length];
		for(int i=0; i<temp.length; i++) {
			String[] t=temp[i].split(",");
			for(int j=0; j<t.length; j++) {
				number[i][j]=Integer.parseInt(t[j]);
			}
		}
		for(int i=0; i<number.length; i++) {
			for(int j=0; j<number[i].length; j++) {
				int temp1=number[i][j];
				if(!isTrue[temp1]) {
					arr.add(number[i][j]);
					isTrue[temp1]=true;
				}
			}
		}
		int[] answer=new int[arr.size()];
		
		for(int i=0; i<arr.size(); i++) {
			answer[i]=arr.get(i);
		}
		return answer;
		
	}

}
