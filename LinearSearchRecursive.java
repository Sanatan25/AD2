public class LinearSearchRecursive {

    public static int linearSearch(int[] arr, int key, int index) {
        if (index >= arr.length) {
            return -1; 
        }
        if (arr[index] == key) {
            return index; 
        }
   
        return linearSearch(arr, key, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int key = 40;

        int result = linearSearch(arr, key, 0);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
