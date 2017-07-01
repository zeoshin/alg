package inheritance;
import java.util.Arrays;
public class MergeSort {
	public static void main(String[] args) {
		int[] input = {1, 3, 7, 2, 5, 0, 4, 1};
		int[] result = mergeSort(input);
		System.out.print(Arrays.toString(result));

	}
	
	public static int[] mergeSort(int[] array) {
		// corner case
		if (array == null || array.length <= 1) return array;
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
		return array;
	}
	public static void mergeSort(int[] array, int[] helper, int left, int right) {
		// overloading
		if (left == right) return;
		int mid = left + (right - left) / 2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid + 1, right);
		merge(array, helper, left, right, mid);
	}
	public static void merge(int[] array, int[] helper, int left, int right, int mid) {
		for (int i = 0; i <= right; i++) {
			helper[i] = array[i];
		}
		int curr = left;
		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] < helper[rightIndex]) array[curr++] = helper[leftIndex++];
			else array[curr++] = helper[rightIndex++];
		}
		// left side remaining
		while (leftIndex <= mid) {
			array[curr++] = helper[leftIndex++];
		}
		// right side remaining, do nothing
		return;
		
	}

}
