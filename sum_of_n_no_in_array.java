
public class sum_of_n_no_in_array {
	public static int add(int[] arr) {
		int sum=0;
		for(int i = 0; i< arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		System.out.println(add(arr));
		
		

	}

}
