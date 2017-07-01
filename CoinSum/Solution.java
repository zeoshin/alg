package CoinSum;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void DFS2(int[] coins, int level, int left_balance, int[]sol, List<int[]> result) {
		if (level == coins.length - 1) {
			sol[coins.length - 1] = left_balance;
			int[] newSol = new int[coins.length];
			for (int i = 0; i < coins.length; i++) {
				newSol[i] = sol[i];
			}
			result.add(newSol);
			return;
		}
		for (int i = 0; i < left_balance / coins[level] + 1; i++) {
			sol[level] = i;
			DFS2(coins, level + 1, left_balance - i * coins[level], sol, result);
		}
	}
	
	public static void DFS1(int[] coins, int level, int left_balance, int[]sol, List<int[]> result) {
		if (left_balance == 0) {
			int[] newSol = new int[coins.length];
			for (int i = 0; i < coins.length; i++) {
				newSol[i] = sol[i];
			}
			result.add(newSol);
			return;
		}
		for (int i = level; i < coins.length; i++) {
			if (left_balance - coins[i] >= 0) {
				sol[i]++;
				DFS1(coins, i, left_balance - coins[i], sol, result);
				sol[i]--;
			}
		}
	}
	
	public static void main(String[] args) {
		List<int[]> result = new LinkedList<int[]>();
		int[] coins = {100, 50, 20, 10, 5, 1};
		int[] sol = new int[coins.length];
		int left_balance = 999;
		int counter = 0;
		//DFS2(coins, 0, left_balance, sol, result);
		DFS1(coins, 0, left_balance, sol, result);
		for (int[] arr : result) {
			int sum = 0;
			for (int i = 0; i < coins.length; i++) {
				System.out.print(arr[i] + " ");
				sum += arr[i] * coins[i];
			}
			if (sum == 999)	System.out.println("\tSum is 999");
			counter++;
		}
		System.out.println("Total: " + counter + " results");
	}
}
