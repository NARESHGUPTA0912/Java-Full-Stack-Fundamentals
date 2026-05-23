package String.P25_To_P44;

import java.util.Scanner;

public class Panagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.nextLine().toLowerCase();

        boolean[] arr = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a'] = true;
            }
        }

        boolean pangram = true;

        for (int i = 0; i < 26; i++) {
            if (!arr[i]) {
                pangram = false;
                break;
            }
        }

        if (pangram) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}
