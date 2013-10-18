public class InsertionSort {
	public static void main(String[] args) {
		int[] array = {5, 3, 10, 1, 2, 9, 8, 7, 6, 4}
		bubbleSort(array);
		for(int k : array) {
			System.out.println(k);
		}
	}
	
	public void bubbleSort(int[] array) {
		for(int i = array.length - 1; i > 0; i--) {
			for(int j = 1; j < i; j++) {
				if(array[j-1] > array[j])
					swap(j, j-1, array);
			}
		}
	}
	
	public void swap(int a, int b, int[] array) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
