import javax.sound.midi.SysexMessage;
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

		runProblem();
		System.out.print("The following items are included in the optimal solution: ");
		findSolution(n, w);
		System.out.println("The total value of the Knapsack is " + M[n][weight]);
	}

	int runProblem() {
		for (int z = 0; z <= n; z++) {
			M[0][z] = 0;
		}
		printMTable(0);

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
			printMTable(i);
		}
		return M[n-1][weight-1];
	}

	void findSolution(int j, int recursiveWeight) {
		if (j == 0 || recursiveWeight == 0) System.out.println("");
		else {
			int itemValue = items.get(j - 1).value;
			int itemWeight = items.get(j - 1).weight;

			if (recursiveWeight - itemWeight < 0) findSolution(j - 1, recursiveWeight);
			else if (itemValue + M[j - 1][recursiveWeight - itemWeight] >= M[j - 1][weight]) {
				System.out.print("item " + Integer.toString(j) + " ");
				findSolution(j - 1, recursiveWeight - itemWeight);
			} else
				findSolution(j - 1, recursiveWeight);
		}
	}

	void printMTable() {
		for (int i = 0; i <= n; i++){
			for (int z = 0; z <= weight; z++) {
				System.out.print(M[i][z] + " ");
			}
				System.out.println();
		}
	}

	/**
	 * Prints the the Ith row od Memoization table
	 */
	void printMTable(int row) {
		for (int i = 0; i <= weight; i++){
			System.out.print(M[row][i] + " ");
		}
		System.out.println();
	}
}
