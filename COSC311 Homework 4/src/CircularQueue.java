/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * hw1011
 * CircularQueue.java - Based off of pseudo-code provided
 * by Susan Haynes: https://emunix.emich.edu
 * /~haynes/CommonCourseMaterial/311/circularQueue.txt
 */
public class CircularQueue {
	int[] q;
	int head, tail, size;

	public CircularQueue() {
		head = tail = 0;
		size = 10;
	}

	public CircularQueue(int n) {
		head = tail = 0;
		size = n;
		q = new int[size];
	}
	
	public boolean isFull() {
		return head == tail + 1;
	}
	
	public boolean isEmpty() {
		return head % size == tail % size;
	}
	
	public void insert(int x) {
		if (!isFull()) {
			q[tail] = x;
			tail = (tail + 1) % size;
		}
	}
	
	public int delete() {
		int x = 0;
		if (!isEmpty()) {
			x = q[head];
			head = (head + 1) % size;
			return x;
		} 
		else {
			return -99;
		}
	}
	
	public void printQueue() { 
		if (!isEmpty()) {
			for (int i = head % size; i != (tail) % size; i = (i + 1) % size) 
				System.out.print(q[i] + " ");
			System.out.println();
		}
		else
			System.out.println("Empty queue");
	}
}