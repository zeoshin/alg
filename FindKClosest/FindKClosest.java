package FindKClosest;

public class FindKClosest {
	public static int BinarySearch(int[] arr, int target, int k) {
		//corner case
		if (arr == null || arr.length == 0 || k > arr.length || k < 1) return -1;
		if (arr[0] >= target) return (k - 1);
		if (arr[arr.length - 1] <= target) return (arr.length - k);
		if (arr.length == 1) return 0;
		int left = 0;
		int right = arr.length - 1;
		int mid = left + (right - left) / 2;
		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return findKClosest(arr, k, mid, mid + 1, target);
			}
			else if (arr[mid] > target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		return findKClosest(arr, k, left, right, target);
	}
	public static int findKClosest(int[] arr, int k, int left, int right, int target) {
		int result = 0;
		while(k > 0) {
			if (left >= 0 && right < arr.length) {
				if (Math.abs(target - arr[left]) <= Math.abs(target - arr[right])) {
					result = left;
					left--;
				}
				else {
					result = right;
					right++;
				}
				k--;
			}
			else if (left >= 0 && right == arr.length) {
				result = left;
					left--;	
					k--;
			}
			else if (left < 0 && right < arr.length) {
					result = right;
					right++;
					k--;
			}
			else {}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 2, 5, 10, 16, 19};
		System.out.println(BinarySearch(arr, 1, 5));
	}

}

