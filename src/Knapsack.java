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
		M = new int[n][w]; // initialize the memoization table for this problem
	}

	int runProblem() {
		for (int i = 0; i < n; i++) {
			M[0][i] = 0;
		}
		printMTable();
		return 1;
	}

	void printMTable() {
		for (int i = 0; i < n; i++){
			for (int z = 0; z < weight; z++) {
				System.out.print(M[i][z] + " ");
			}
				System.out.println();
		}
	}
}
