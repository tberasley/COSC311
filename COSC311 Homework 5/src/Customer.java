/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * pp1016
 * 
 */
public class Customer {
	int id; // id
	boolean ghost; // flag for identifying if the customer is real or a ghost
	int waitTime; 
	int startQueue, currentQueue;
	int timeRemaining;
	
	
	public Customer() {
		id = -99;
		ghost = false;
		waitTime = 0;
		startQueue = -1;
		currentQueue = startQueue;
		timeRemaining = 0;
	}
	public Customer(int id, int startQueue) {
		this.id = id;
		this.startQueue = startQueue;
		this.currentQueue = startQueue;
		ghost = false;
		waitTime = 0;
		timeRemaining = 0;
	}
	
	public String toString() { // toString for customer data
		return
				"Customer: " + id + 
				"\nStarting Queue: " + startQueue +
				"\nCurrent Queue: " + currentQueue +
				"\nWait Time: " + waitTime + " ticks.";
	}
	
}
