import java.util.ArrayList;

/**
 * Evaluates the knapsack problem using dynamic programming
 */
public class Knapsack {
	ArrayList<Item> items;
	int weight;
	int[][] M; // Memoization table
	int n; // the number of items given in the problem

	Knapsack(ArrayList<Item> problemItems, int w) {
		items = problemItems;
		weight = w;
		n = items.size();
		M = new int[n + 1][w + 1]; // initialize the memoization table for this problem
	}

	int runProblem() {
		for (int z = 0; z <= n; z++) {
			M[0][z] = 0;
		}

		int itemValue, itemWeight;

		for (int i = 1; i <= n; i++) {
			// Information about the item in question is saved for ease of use.
			// (i-1) because item indices start at 1 while the matrix indices start at 0
			itemWeight = items.get(i - 1).weight;
			itemValue = items.get(i - 1).value;
			for (int w = 0; w <= weight; w++) {

				if (itemWeight > w) { // item i is NOT part of the optimal solution
					M[i][w] = M[i-1][w];
				}
				else { // item i IS part of the optimal solution
					M[i][w] = Math.max(M[i-1][w], itemValue + M[i-1][w - itemWeight]);
				}
			}
		}
		printMTable();
		return M[n-1][weight-1];
	}

	void printMTable() {
		for (int i = 0; i <= n; i++){
			for (int z = 0; z <= weight; z++) {
				System.out.print(M[i][z] + " ");
			}
				System.out.println();
		}
	}
}
