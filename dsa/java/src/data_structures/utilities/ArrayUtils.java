package data_structures.utilities;

public class ArrayUtils {

    /**
     * In-line reverses an array.
     */
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }

    /**
     * Returns the first index of an element in a given array
     */
    public static <T> int firstIndexOf(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (Utils.equals(element, array[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Copies an array and returns a new array. If newSize is larger than the original array, the additional size of the
     * copied array will be padded with the defaultValue. If newSize is smaller, the copied array will only contain the first newSize
     * elements of the array.
     */
    public static int[] copyOf(int[] array, int newSize, int defaultValue) {
        int[] copy = new int[newSize];

        // Copy from original array to the copy. Copy the first newSize values or the entire array (whichever if smaller)
        int indexesToCopy = Math.min(newSize, array.length);

        for (int i = 0; i < indexesToCopy; i++) {
            copy[i] = array[i];
        }

        // Initialize any excess size to defaultValue
        for (int i = array.length; i < newSize; i++) {
            copy[i] = defaultValue;
        }

        return copy;
    }
}
