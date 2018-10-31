/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * pp1016
 * Main.java - Drives the 2 queue simulation.
 * 
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		CircularQueue q1 = new CircularQueue(50);
		CircularQueue q2 = new CircularQueue(50);
		Server serv1 = new Server(null, 0);
		Server serv2 = new Server(null, 0);
		Random servTime = new Random();
		Random chooseQueue = new Random();
		int customerId = 1;

		for (int tick = 0, serviced = 0; serviced < 5; tick++) {
			System.out.println("********* Tick " + tick + " *********");
			// remove customer(s) who have had service completed;
			if (serv1.cust != null) {
				if (serv1.timeRemaining <= 0) {
					System.out.println("Tick " + tick + ": Server 1 ends service " 
										+ "on customer " + serv1.cust.id);
					serv1.cust = null;
				} else
					serv1.timeRemaining--;
			}
			if (serv2.cust != null) {
				if (serv2.timeRemaining <= 0) {
					System.out.println("Tick " + tick + ": Server 2 ends service "
										+ "on customer " + serv2.cust.id);
					serv2.cust = null;
				} else
					serv2.timeRemaining--;
			}
			// update any measurements of those in queue;
			q1.incrementTicks();
			q2.incrementTicks();

			// compute number of arrivals and insert to queue
			// Queue 1
			for (int i = 0; i < getPoissonRandom(0.25); i++) {
				q1.insert(new Customer(customerId++, 1));
				if (chooseQueue.nextInt(2) == 1) { // 50/50 customer switches queue
					Customer temp = q1.deleteTail();
					q2.insert(temp); // moves last customer to queue 2
					temp.ghost = true; 
					q1.insert(temp); // insert ghost into queue 1
					System.out.println("Customer " + temp.id + " switched queues");
				}
			}
			// Queue 2
			for (int i = 0; i < getPoissonRandom(0.25); i++) {
				q2.insert(new Customer(customerId++, 2));
			}

			// assign customer(s) to idle server(s);
			if (serv1.cust == null) { // if server has no customer assign one
				Customer nextCust = q1.delete();
				if (nextCust != null) {
					serv1 = new Server(nextCust, servTime.nextInt(5) + 1);
					if (!nextCust.ghost) {
					System.out.println("Tick " + tick + ": Server 1 starts service " 
										+ "on customer " + serv1.cust.id);
					System.out.println("Customer " + serv1.cust.id + " waited "
										+ serv1.cust.waitTime + " ticks to be serviced");
					}
					else {
						System.out.println("Customer " + serv1.cust.id 
						+ " would have waited " + serv1.cust.waitTime 
						+ " ticks to be serviced if they had not switched queues");
						serv1.cust = null; // remove ghost
					}
				}
			}
			if (serv2.cust == null) { // if server has no customer assign one
				Customer nextCust = q2.delete();
				if (nextCust != null) {
					serv2 = new Server(nextCust, servTime.nextInt(5) + 1);
					System.out.println("Tick " + tick + ": Server 2 starts service " 
										+ "on customer " + serv2.cust.id);
					System.out.println("Customer " + serv2.cust.id + " waited "
							+ serv2.cust.waitTime + " ticks to be serviced");
					if (nextCust.startQueue == 1)
						serviced++;
				}
			}
			System.out.println("Queue 1");
			q1.printQueue();

			System.out.println();

			System.out.println("Queue 2");
			q2.printQueue();
		}
	}
	
	// based on https://stackoverflow.com/questions/
	// 9832919/generate-poisson-arrival-in-java
	public static int getPoissonRandom(double mean) {
		Random r = new Random();
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do {
			p = p * r.nextDouble();
			k++;
		} while (p > L);
		return k - 1;
	}
}
