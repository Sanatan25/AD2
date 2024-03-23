public class power_a_and_n_by_multiplying_a_n_times {
    public static long power(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        long result = power(a, b);
        System.out.println(a + " raised to the power of " + b + " is: " + result);
    }
}
