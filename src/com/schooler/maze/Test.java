package com.schooler.maze;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			char[] reduced = PathReducer.reducePath(line.toCharArray());
			System.out.println(reduced);
		}
	}

}
