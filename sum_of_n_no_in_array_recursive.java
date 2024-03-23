
public class sum_of_n_no_in_array_recursive {
	public static int sum(int[] arr, int index) {
		if(index == -1) {
			return 0;
		}
		return arr[index]+sum(arr,index-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		System.out.println(sum(arr,arr.length-1));

	}

}
