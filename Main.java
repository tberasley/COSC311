/* Tim Berasley
 * https://drive.google.com/open?id=1mGFGlkeWJvdFlnR_B6BcOoLZ7sM-GShu
 * COSC 311
 * HW 09/21
 * Fall 2018
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int factor = 0, size = 0;
		int[] a;
		Scanner keyb = new Scanner(System.in);
		
		System.out.println("Enter the array size:");
		size = keyb.nextInt();
		a = new int[size];
		
		System.out.println("Enter a series of integers:");
		for (int i = 0; i < size; i++) {
			a[i] = keyb.nextInt();
		}
		
		System.out.println("Enter the repetition factor:");
		factor = keyb.nextInt();
		
		System.out.println("Resulting array:");
		print(repeat(a, factor));
	}
	
	public static int[] repeat(int[] a, int factor) {
		int[] b = new int[0];
		int k = 0;
		
		if (factor <= 0)
			return b;
			
		b = new int[a.length * factor];
		
		for (int i = 0; i < factor; i++) {
			for (int j = 0; j < a.length; j++) {
				b[k] = a[j];
				k++;
			}
		}
		return b;
	}
	public static void print(int[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++)
		System.out.print(" " + a[i] + " ");
		System.out.println("}");
	}

}
