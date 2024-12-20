package test;

import java.util.Arrays;

public class Test4 {
    private static int shortestDistance(int[] array) {
        // IMPLEMENT HERE
    	Arrays.sort(array);
    	int distance = array[1] - array[0];
    	for (int i = 1; i < array.length -1; i++) {
			
			int currentDistance = array[i+1] - array[i];
			if (currentDistance != distance ) {
				distance = Math.min(currentDistance, distance);
			}
			
		}
        return distance;
    }

    public static void main(String[] args) {
        int[] array = {12, 32, 11, 56, 64, 9, 107, 8};
       // int[] array = {2, 4, 10, 6, 5};
      //  int[] array = {2, 4, 10, 6, 5, 2};
        int result = shortestDistance(array);
        System.out.println(result);
    }
}
