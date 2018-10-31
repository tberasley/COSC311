/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * pp1016
 * CircularQueue.java - Based off of pseudo-code provided
 * by Susan Haynes: https://emunix.emich.edu
 * /~haynes/CommonCourseMaterial/311/circularQueue.txt
 * Has additional method for tail deletion
 */
public class CircularQueue {
	Customer[] q;
	int head, tail, size;

	public CircularQueue() { // default constructor
		head = tail = 0;
		size = 10;
	}

	public CircularQueue(int n) { // overloaded constructor
		head = tail = 0;
		size = n;
		q = new Customer[size];
	}
	
	public boolean isFull() { // returns true if full
		return head == tail + 1;
	}
	
	public boolean isEmpty() { // returns true if empty
		return head % size == tail % size;
	}
	
	public void insert(Customer cust) { // inserts at tail
		if (!isFull()) {
			q[tail] = cust;
			tail = (tail + 1) % size;
		}
	}
	
	public Customer delete() { // deletes from head
		Customer cust;
		if (!isEmpty()) {
			cust = q[head];
			head = (head + 1) % size;
			return cust;
		} 
		else {
			return null;
		}
	}
	
	public Customer deleteTail() { // deletes from tail
		Customer cust;
		if (!isEmpty()) {
			cust = q[(tail-1) % size];
			tail = (tail - 1) % size;
			return cust;
		} 
		else {
			return (new Customer(-1,-1));
		}
	}
	
	public void printQueue() { // prints contacts of queue
		if (!isEmpty()) {
			for (int i = head % size; i != (tail) % size; i = (i + 1) % size) 
				System.out.println(q[i] + " ");
		}
		else
			System.out.println("Empty");
	}
	
	public int countQueue() { // returns the number of elements in the queue
		if (!isEmpty()) {
			int count = 0;
			for (int i = head % size; i != (tail) % size; i = (i + 1) % size) 
				count++;
			return count;
		}
		else
			return 0;
	}
	public void incrementTicks() { // increments wait time of customers
		if (!isEmpty()) {
			for (int i = head % size; i != (tail) % size; i = (i + 1) % size) 
				q[i].waitTime++;
		}
	}
}