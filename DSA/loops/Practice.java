public class Practice {
    public static void main(String[] args) {
        printPrimeFactors(78);
    }

    public static void printAndCountFactors(int n) {
        int count = 0;
        int i = 1;
        while (i <= n) {
            if (n % i == 0) {
                System.out.println(i);
                count++;
            }
            i++;
        }
        System.out.println("Total Count: " + count);
    }

    public static void printPrimeFactors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
