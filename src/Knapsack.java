import java.util.ArrayList;

/**
 * Evaluates the knapsack problem using dynamic programming
 */
public class Knapsack {
	ArrayList<Item> items;
	int weight;

	Knapsack(ArrayList<Item> problemItems, int w) {
		items = problemItems;
		weight = w;
	}
}
