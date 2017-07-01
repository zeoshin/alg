package LongestSubStrNoDup;

import java.util.HashSet;

public class Solution {
	static int resL = 0;
	static int resR = 0;
	public static int longestSubStr(String input) {
		if (input == null) return -1;
		int slow = 0;
		int fast = 0;
		int result = 0;

		HashSet<Character> hash = new HashSet<>();
		while(fast < input.length()) {
			if(hash.add(input.charAt(fast))) {
				if (fast - slow + 1 > result) {
					result = fast - slow + 1;
					resL = slow;
					resR = fast;
				}
				fast++;
			}
			else {
				while(input.charAt(slow) != input.charAt(fast)) {
					hash.remove(input.charAt(slow));
					slow++;
				}
				hash.remove(input.charAt(slow));
				slow++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String input = "abcdfhurieowmcbvzshjkriuryewiopef";
		System.out.println(longestSubStr(input));
		System.out.println(input.substring(resL, resR + 1));
	}
}
