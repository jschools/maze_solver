package com.schooler.maze;


public class PathReducer {

	public static char[] reducePath(char[] path) {
		final int length = path.length;
		CharArrayStack stack = new CharArrayStack(length);

		for (int i = 0; i < length; i++) {
			processAction(stack, path[i]);
		}

		return stack.toArray();
	}

	private static void processAction(CharArrayStack stack, char action) {
		if (stack.size() == 0 || stack.peek() != Action.U_TURN) {
			stack.push(action);
			return;
		}

		if (stack.peek() == Action.U_TURN) {
			stack.pop();
			char pre = stack.pop();
			char post = action;
			char replacement = reduceUturn(pre, post);
			stack.push(replacement);
		}
	}

	private static char reduceUturn(char pre, char post) {
		switch (pre) {
		case Action.LEFT:
			switch (post) {
			case Action.LEFT:
				return Action.STRAIGHT;
			case Action.STRAIGHT:
				return Action.RIGHT;
			case Action.RIGHT:
				return Action.U_TURN;
			default:
				return Action.NULL;
			}
		case Action.STRAIGHT:
			switch (post) {
			case Action.LEFT:
				return Action.RIGHT;
			case Action.STRAIGHT:
				return Action.U_TURN;
			case Action.RIGHT:
				return Action.LEFT;
			default:
				return Action.NULL;
			}
		case Action.RIGHT:
			switch (post) {
			case Action.LEFT:
				return Action.U_TURN;
			case Action.STRAIGHT:
				return Action.LEFT;
			case Action.RIGHT:
				return Action.STRAIGHT;
			default:
				return Action.NULL;
			}
		default:
			return Action.NULL;
		}
	}

}
