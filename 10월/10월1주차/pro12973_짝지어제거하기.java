package pro1002;

import java.util.Stack;

public class pro12973 {

	public static Stack<Character> stack = new Stack<>();

	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(temp);
				continue;
			}
			char compare = stack.peek();
			if (compare == temp) {
				stack.pop();
			} else {
				stack.push(temp);
			}
		}
		if (stack.isEmpty())
			answer = 1;
		return answer;
	}

}
