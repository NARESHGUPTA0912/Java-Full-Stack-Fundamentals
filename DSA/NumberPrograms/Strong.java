import java.util.Scanner;

class Strong {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number: ");
            int n = sc.nextInt();
            if (isStrong(n)) {
                System.out.println(n + " is a Strong Number.");
            } else {
                System.out.println(n + " is NOT a Strong Number.");
            }
        }
    }

    private static boolean isStrong(int n) {
		int org_num = n, sum = 0;
		while(n>0) {
			sum = sum + getFactorial(n % 10);
			n /= 10;
		}
		return sum == org_num;
    }

	private static int getFactorial(int n) {
		int fact = 1;
		for(int i=1; i<=n; i++) {
			fact *= i;
		} return fact;
	}
}
