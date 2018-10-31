/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * pp1016
 * 
 */
public class Server {
	Customer cust;
	int timeRemaining;
	
	public Server() {
		cust = null;
		timeRemaining = 0;
	}
	
	public Server(Customer cust, int timeRemaining) {
		this.cust = cust;
		this.timeRemaining = timeRemaining;
	}
}
