// Tim Berasley - E01476290 - COSC 311 - Fall 2018 - hw1129
public class Main {
	public static void main(String[] args) {
		int[][] pqs = {{1,2,3,4,5},{1,1,0,1,1},{1,5,1,2,5,6},
				{1,2,2,3,2,2,17,4},{1,2,2,0,2,2,17,4}, new int[1023], new int[1023]};
		for (int x = 5; x < pqs.length; x++) 
			for (int i = 0, k = 0; i < 10; i++)
				for (int j = 0; j < Math.pow(2, i); j++, k+=1) 
					pqs[x][k] = (int) Math.pow(2, i); 
		pqs[6][500] = 1;
		for (int i = 0, n = 0; i < pqs.length; i++) {
			n = isPQ(pqs[i],0);
			if (n == 0) System.out.println("valid");
			else if (n == -1) System.out.println("invalid - fails at index 0");
			else System.out.println("invalid - fails at index " + n);
		}
	}
	public static int isPQ(int[] arr, int i) { 
		if (i*2+2 > arr.length - 1) return 0; // true
		if (arr[i] == 0 || arr[i*2+1] < arr[i] || arr[i*2+2] < arr[i])
			if (i == 0) return -1;
			else return i;
		else {
			int k = isPQ(arr,i*2+1);
			if (k != 0) return k;
			k = isPQ(arr,i*2+2);
			if (k != 0) return k;
			return isPQ(arr,i*2+1) + isPQ(arr,i*2+2);
		}
	}
}