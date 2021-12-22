package pro1002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class pro42857 {
	public static HashMap<Integer, Integer> map = new HashMap<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		int[] p = { 1, 1, 9, 1, 1, 1 };
		System.out.println(solution(p, 0));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		// location, value
		for (int i = 0; i < priorities.length; i++) {
			map.put(i, priorities[i]);
			q.add(i);
		}
		boolean[] isUsed=new boolean[priorities.length];
		while (!q.isEmpty()) {
			int temp = q.poll();
			//System.out.println(q.size());
			boolean isTrue = false;
			// int prio=map.get(temp);
			for (int i = 0; i < map.size(); i++) {
				// 더크면
				if(i==temp) continue;
				if(isUsed[i]) continue;
				if (map.get(temp) < map.get(i)) {
					q.add(temp);
					isTrue = true;
					break;
				}
			}
			if (!isTrue) {
				arr.add(temp);
				isUsed[temp]=true;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == location) {
				answer = i;
				break;
			}
		}
		return answer+1;
	}
}
