package RemoveAdjacentDuplicateKRemain;

public class Solution {
	public static String RemoveDuplicateKRemain(String input, int k) {
		if (input == null) return null;
		if (k == 0) return new String();
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		int curr = 0;
		int counter = 0;
		while(fast < input.length()){
			if (array[fast] != array[slow]) {
				array[curr++] = array[fast];
				slow = fast++;
				counter = 1;
			}
			else {
				if (counter < k) {
					array[curr++] = array[fast++];
					counter++;
				}
				else fast++;
			}
		}
		return new String(array, 0, curr);
	}
	public static void main(String[] args) {
		String input0 = "aaabccdddefggggh";
		String input1 = "a";
		String input2 = "";
		int k = 2;
		System.out.println("Test case0:\n\tinput = " + input0 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input0, k));
		System.out.println("Test case1:\n\tinput = " + input1 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input1, k));
		System.out.println("Test case2:\n\tinput = " + input2 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input2, k));
		k = 4;
		System.out.println("Test case3:\n\tinput = " + input0 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input0, k));
		k = 0;
		System.out.println("Test case4:\n\tinput = " + input0 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input0, k));
		k = 1;
		System.out.println("Test case6:\n\tinput = " + input0 + "\n\tk = " + k + "\n\toutput = " + RemoveDuplicateKRemain(input0, k));

	}
}
