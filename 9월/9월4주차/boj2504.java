package algo0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = bfr.readLine();
		String[] st = temp.split("");
		
		//올바른지 아닌지 판단
		int result=isAvailable(st);
		
		System.out.println(result);

	}
	public static int isAvailable(String[] st) {
		Stack<String> stack = new Stack<>();
		int num=1;
		int result=0;
		for(int i=0 ; i< st.length; i++) {
			switch(st[i]) {
				case "(":
					stack.push("(");
					num*=2;
					break;
				
				case "[":
					stack.push("[");
					num*=3;
					break;
					
				case ")":
					if(stack.isEmpty() || stack.peek()!="(") {
						result=0;
						break;
					}
					if(st[i-1].equals("(")) result+=num;
					stack.pop();
					num/=2;
					break;
					
				case "]":
					if(stack.isEmpty() || stack.peek()!="[") {
						result=0;
						break;
					}
					if(st[i-1].equals("[")) result+=num;
					stack.pop();
					num/=3;
					break;	
			}
		}
			
		
		if(!stack.isEmpty()) result=0;
		
		return result;
	}
}
