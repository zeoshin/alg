package Quick_Sort;

import java.util.Random;

public class QuickSort {
	public static void quickSort(int[] array) {
		if (array == null || array.length == 0) return;
		quickSort(array, 0, array.length - 1);
	}
	public static void quickSort(int[] array, int left, int right) {
		if (left > right) return;
		Random rand = new Random();
		int mid = left + rand.nextInt(right - left + 1);
		int currLeft = left;
		int currRight = right;
		swap(array, mid, currRight--);
		while (currLeft <= currRight) {
			if (array[currLeft] <= array[right]) currLeft++;
			else if (array[currRight] > array[right]) currRight--;
			else swap(array, currLeft, currRight);
		}
		swap(array, currLeft, right);
		quickSort(array, currLeft + 1, right);
		quickSort(array, left, currLeft - 1);
	}
	public static void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	public static void main(String[] args){
		int[] input = {50, 1, 2, 4, 0, 2, 5, 3, 0, 9};
		//int[] input = {10, 4};
		quickSort(input);
		for (int e : input) {
			System.out.print(e + " ");
		}
	}
}

