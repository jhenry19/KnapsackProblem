/**
 * An object for each item that can be held in the knapsack
 */
public class Item {
	int index;
	int value;
	int weight;

	Item(int i, int v, int w) {
		index = i;
		value = v;
		weight = w;
	}
}
