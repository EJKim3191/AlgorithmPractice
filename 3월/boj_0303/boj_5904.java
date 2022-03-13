package boj_0303;

import java.io.*;
import java.util.*;

public class boj_5904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bfr.readLine());
		int s = 0;
		if (n <= 3) {
			if (n == 1)
				System.out.println("m");
			else
				System.out.println("o");
			System.exit(0);
		}
		int len = 3;
		while (len < n) {
			s += 1;
			len = len * 2 + s + 3;
		}
		// 범위 3가지
		while (true) {

			if (n <= (len - s - 3) / 2) {
				len = (len - s - 3) / 2;
				s -= 1;
			} else if (n > (len - s - 3) / 2 && n <= (len - s - 3) / 2 + s + 3) {
				if (n == (len - s - 3) / 2 + 1) {
					System.out.println("m");
					break;
				} else {
					System.out.println("o");
					break;
				}
			} else {
				len = (len - s - 3) / 2;
				n = n - len - s - 3;
				s -= 1;
			}
			if (s == 0) {
				if (n == 1)
					System.out.println("m");
				else
					System.out.println("o");
				break;
			}
		}
	}
}
