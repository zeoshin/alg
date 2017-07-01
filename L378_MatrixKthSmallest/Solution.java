package L378_MatrixKthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public static class Cell {
		public int val;
		public int x;
		public int y;
		public Cell(int x, int y, int val) {
			this.val = val;
			this.x = x;
			this.y = y;
		}
	}
	private static class MyComparator implements Comparator<Cell> {
		public int compare(Cell x, Cell y) {
			if (x.val == y.val) return 0;
			return (x.val > y.val) ? 1 : -1;
		}
	}
	public static int kthSmallest(int[][] matrix, int k) throws Exception {
		try {
			if(k ==0 || matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) throw new IllegalArgumentException();
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];
			PriorityQueue<Cell> heap = new PriorityQueue<Cell>(k, new MyComparator());
			heap.offer(new Cell(0, 0, matrix[0][0]));
			visited[0][0] = true;
			int curr = 0;
			while(curr < k - 1) {
				Cell currCell = heap.poll();
				curr++;
				int newX = currCell.x + 1;
				int newY = currCell.y + 1;
				if (newX < matrix.length && !visited[newX][currCell.y]) {
					heap.offer(new Cell(newX, currCell.y, matrix[newX][currCell.y]));
					visited[newX][currCell.y] = true;
				}
				if (newY < matrix[0].length && !visited[currCell.x][newY]) {
					heap.offer(new Cell(currCell.x, newY, matrix[currCell.x][newY]));
					visited[currCell.x][newY] = true;
				}
			}
			return heap.poll().val;
		} catch(IllegalArgumentException e) {
			return -1;
		}
	}
	public static void main(String[] args) {
		int k = 8;
		int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

		System.out.println("Find " + k +"th smallest in matrix:\n");
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		try {
			System.out.println("The " + k + "th smallest is: " + kthSmallest(matrix,k));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
