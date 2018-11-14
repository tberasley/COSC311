/* Tim Berasley - E01476290
 * COSC 311 - Fall 2018
 * hw1108
 * Main.java
 * Source:
 */
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		Random rand = new Random(97);
		int count = 0, size = 8, key = 0, index = 0, max = 40, x = 0;
		int[] hashTable = new int[size];
		int[] inputArr = new int[20];
		int[] values = new int[41];
		
		for (int i = 0; i < values.length; i++) {
			values[i] = 10 + i;
		}
				
		for (int i = 0; i < inputArr.length; i++) {
			x = rand.nextInt(max + 1);
			inputArr[i] = values[x];
			values[x] = values[max];
			max--;
		}
		
		for (int i = 0; i < inputArr.length; i++) {
			key = inputArr[i];
			index = key % size;
			while (hashTable[index] != 0) {
				index = (index + 1) % size;
			}
			hashTable[index] = key;
			count++;
			if (count / size >= .75) {
				size *= 2;
				hashTable = rehash(hashTable, size, count);
			}
		}
		
		System.out.println("index" + "\t" + "data value");
		for (int i = 0; i < hashTable.length; i++) {
			System.out.println(i + "\t" + hashTable[i]);
		}
	}

	public static int[] rehash(int[] table, int size, int count) {
		int[] newTable = new int[size];
		int key = 0, index = 0;
		
		for (int i = 0; i < table.length; i++) {
			if (table[i] != 0) {
				key = table[i];
				index = key % size;
				while (newTable[index] != 0) {
					index = (index + 1) % size;
				}
				newTable[index] = key;
			}
		}
		return newTable;
	}
}
