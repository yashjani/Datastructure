package MiscProb;

import java.util.ArrayList;
import java.util.List;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		System.out.println(reverseWords("a good   example"));

	}

	public static String reverseWords(String s) {

		s = s.trim();
		StringBuilder sb = new StringBuilder();
		int endWord = s.length() - 1;
		while (endWord >= 0) {
			if (s.charAt(endWord) == ' ') {
				while (endWord >= 0 && s.charAt(endWord) == ' ') {
					endWord--;
				}
				sb.append(" ");
			} else {
				int startWord = endWord;
				while (endWord >= 0 && s.charAt(endWord) != ' ') {
					endWord--;
				}
				sb.append(s.substring(endWord + 1, startWord + 1));
			}
		}

		return sb.toString().trim();

	}
}
