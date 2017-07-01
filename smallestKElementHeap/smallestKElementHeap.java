package smallestKElementHeap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class smallestKElementHeap {
	
	private static class MyComparator implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			if (x.intValue() == y.intValue()) return 0;
			return (x.intValue() < y.intValue()) ? 1 : -1;
		}
	}
	
	public static int[] smallestKElementHeapm(int[] array, int k) {
		if (array == null || array.length == 0 || k < 1 || k > array.length) return null;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MyComparator());
		for(int i = 0; i < array.length; i++) {
			if (i < k) heap.offer(array[i]);
			else {
				if (array[i] < heap.peek()) {
					heap.poll();
					heap.offer(array[i]);
				}
			}
		}
		//int[] result = new int[k];
		//for(int i = 0; i < k; i++) result[i] = heap.poll();
		//return result;
		return toArray(heap);
	}

	private static int[] toArray(Queue<Integer> queue) {
		int[] result = new int[queue.size()];
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			result[i] = queue.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 30, 4, -5, 6, 7, 8, 10};
		for(int ele : array) {
			System.out.print(ele + " ");
		}
		System.out.println();
		int[] result = smallestKElementHeapm(array, 5);
		for(int ele : result) {
			System.out.print(ele + " ");
		}
	}
}
