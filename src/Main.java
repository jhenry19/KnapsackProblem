import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Create list of items in knapsack problem (must in in increasing order of value)
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item(1, 1, 1));
		items.add(new Item(2, 6, 2));
		items.add(new Item(3, 18, 5));
		items.add(new Item(4, 22, 6));
		items.add(new Item(5, 28, 7));

		Knapsack knapsack = new Knapsack(items, 10);
	}
}
