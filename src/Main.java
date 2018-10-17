/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * hw1011
 * Main.java - 
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(10);
		Random rand = new Random(3);
		int x = 0, y = 0, a = 0;

		for (int i = 0; i < 3; i++) {
			x = rand.nextInt(5) + 1;
			for (int j = 0; j < x; j++) {
				a = rand.nextInt(100);
				q.insert(a);
			}
			y = rand.nextInt(5) + 1;
			for (int j = 0; j < y; j++) {
				q.delete();
			}
		}
		q.printQueue();
	}
}
