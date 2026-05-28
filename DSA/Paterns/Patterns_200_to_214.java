package Paterns;

import java.util.Scanner;

public class Patterns_200_to_214 {

    // Common Logic
    static int lc(int i, int n) {
        return (i <= n / 2 + 1) ? i : n - i + 1;
    }

    static int gc(int i, int n) {
        return n - (2 * lc(i, n));
    }

    // ─────────────────────────────────────────────────────────────
    // Q200
    // *           *
    // * *       * *
    // * * *   * * *
    // * * * * * * *
    // * * *   * * *
    // * *       * *
    // *           *
    static void q200(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print("* ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = 1; j <= l; j++) {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q201
    static void q201(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print(i + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = 1; j <= l; j++) {
                    System.out.print(i + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q202
    static void q202(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            int val = (i % 2 == 0) ? 0 : 1;

            for (int j = 1; j <= l; j++) {
                System.out.print(val + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = 1; j <= l; j++) {
                    System.out.print(val + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q203
    static void q203(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print(j + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = n - l + 1; j <= n; j++) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q204
    static void q204(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print((j % 2 == 0 ? 0 : 1) + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = n - l + 1; j <= n; j++) {
                    System.out.print((j % 2 == 0 ? 0 : 1) + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q205
    static void q205(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print(j + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = l + 1; j <= 2 * l; j++) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q206
    static void q206(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 1; j <= l; j++) {
                System.out.print(j + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {

                for (int j = l; j >= 1; j--) {
                    System.out.print(j + " ");
                }

            } else {

                for (int j = l - 1; j >= 1; j--) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q207
    static void q207(int n) {

        int num = 1;

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            int r = (g > 0) ? l : l - 1;

            for (int j = 1; j <= l; j++) {
                System.out.printf("%-3d", num++);
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= r; j++) {
                System.out.printf("%-3d", num++);
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q208
    static void q208(int n) {

        int total = 0;

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            total += l + ((g > 0) ? l : l - 1);
        }

        int num = total;

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            int r = (g > 0) ? l : l - 1;

            for (int j = 1; j <= l; j++) {
                System.out.printf("%-3d", num--);
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= r; j++) {
                System.out.printf("%-3d", num--);
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q209
    static void q209(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            char ch = (char) ('A' + i - 1);

            for (int j = 1; j <= l; j++) {
                System.out.print(ch + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = 1; j <= l; j++) {
                    System.out.print(ch + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q210
    static void q210(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 0; j < l; j++) {
                System.out.print((char) ('A' + j) + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = n - l; j < n; j++) {
                    System.out.print((char) ('A' + j) + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q211
    static void q211(int n) {

        char ch = 'A';

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            int r = (g > 0) ? l : l - 1;

            for (int j = 1; j <= l; j++) {
                System.out.print(ch++ + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= r; j++) {
                System.out.print(ch++ + " ");
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q212
    static void q212(int n) {

        int total = 0;

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            total += l + ((g > 0) ? l : l - 1);
        }

        char ch = (char) ('A' + total - 1);

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            int r = (g > 0) ? l : l - 1;

            for (int j = 1; j <= l; j++) {
                System.out.print(ch-- + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= r; j++) {
                System.out.print(ch-- + " ");
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q213
    static void q213(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 0; j < l; j++) {
                System.out.print((char) ('A' + j) + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {
                for (int j = l; j < 2 * l; j++) {
                    System.out.print((char) ('A' + j) + " ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Q214
    static void q214(int n) {

        for (int i = 1; i <= n; i++) {

            int l = lc(i, n);
            int g = gc(i, n);

            for (int j = 0; j < l; j++) {
                System.out.print((char) ('A' + j) + " ");
            }

            for (int j = 1; j <= g; j++) {
                System.out.print("  ");
            }

            if (g > 0) {

                for (int j = l - 1; j >= 0; j--) {
                    System.out.print((char) ('A' + j) + " ");
                }

            } else {

                for (int j = l - 2; j >= 0; j--) {
                    System.out.print((char) ('A' + j) + " ");
                }
            }

            System.out.println();
        }
    }

    // Q200
// *           *
// * *       * *
// * * *   * * *
// * * * * * * *
// * * *   * * *
// * *       * *
// *           *
    static void q200_2(int n) {

        int mid = n / 2;

        for (int i = 0; i < n; i++) {

            int stars;

            if (i <= mid) {
                stars = i + 1; 
            }else {
                stars = n - i;
            }

            // Left Stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // Middle Spaces
            int spaces = n - (2 * stars);

            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            // Right Stars
            if (spaces > 0) {

                for (int j = 1; j <= stars; j++) {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        q200_2(5);
        // try (Scanner sc = new Scanner(System.in)) {

        //     System.out.print("Enter Odd Rows: ");
        //     int n = sc.nextInt();

        //     q200(n);
        //     System.out.println();

        //     q201(n);
        //     System.out.println();

        //     q202(n);
        //     System.out.println();

        //     q203(n);
        //     System.out.println();

        //     q204(n);
        //     System.out.println();

        //     q205(n);
        //     System.out.println();

        //     q206(n);
        //     System.out.println();

        //     q207(n);
        //     System.out.println();

        //     q208(n);
        //     System.out.println();

        //     q209(n);
        //     System.out.println();

        //     q210(n);
        //     System.out.println();

        //     q211(n);
        //     System.out.println();

        //     q212(n);
        //     System.out.println();

        //     q213(n);
        //     System.out.println();

        //     q214(n);

        //     sc.close();
        }
    }
}
