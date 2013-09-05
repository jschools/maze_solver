package com.schooler.maze;

public class CharArrayStack {

	private char[] array;
	private int size;

	public CharArrayStack() {
		this(10);
	}

	public CharArrayStack(int defaultSize) {
		array = new char[defaultSize];
		size = 0;
	}

	public void push(char value) {
		if (size == array.length) {
			char[] extended = new char[array.length * 2];
			System.arraycopy(array, 0, extended, 0, array.length);
			array = extended;
		}

		array[size] = value;
		size++;
	}

	public char pop() {
		size--;
		return array[size];
	}

	public char peek() {
		return array[size - 1];
	}

	public int size() {
		return size;
	}

	public char[] toArray() {
		char[] result = new char[size];

		System.arraycopy(array, 0, result, 0, size);

		return result;
	}
}
