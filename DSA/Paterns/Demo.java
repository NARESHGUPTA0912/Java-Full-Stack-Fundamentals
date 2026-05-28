package Paterns;

package Paterns;

import java.util.Scanner;

public class Demo {

    // public static void butterfly(int n) {
    //     for (int i = 1; i < 2 * n; i++) {
    //         int stars = (i <= n) ? i : (2 * n - i);
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print("* ");
    //         for (int j = 1; j <= 2 * (n - stars); j++)
    //             System.out.print("  ");
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print("* ");
    //         System.out.println();
    //     }
    // }
    // public static void pattern201(int n) {
    //     for (int i = 1; i < 2 * n; i++) {
    //         int stars = (i <= n) ? i : (2 * n - i);
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print(i+" ");
    //         for (int j = 1; j <= 2 * (n - stars); j++)
    //             System.out.print("  ");
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print(i+" ");
    //         System.out.println();
    //     }
    // }
    public static void butterfly(int n) {

        int mid = n / 2;

        for (int i = 0; i < n; i++) {

            int stars;

            if (i <= mid) {
                stars = i + 1;
            } else {
                stars = n - i;
            }

            // Left Stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // Spaces
            for (int j = 1; j <= 2 * (mid - stars + 1); j++) {
                System.out.print("  ");
            }

            // Right Stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    //     import java.util.Scanner;



    // public class Patterns_200_to_214 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // ─────────────────────────────────────────────
            // Q200 – Diamond of stars (hollow X / hourglass-diamond)
            // Row i (1-based): stars at columns i and (2n - i), middle row full
            // Pattern (n=7):
            // *           *
            // * *       * *
            // * * *   * * *
            // * * * * * * *
            // * * *   * * *
            // * *       * *
            // *           *
            // ─────────────────────────────────────────────
            System.out.println("=== Q200 ===");
            System.out.print("Enter the Number of Rows: ");
            int n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i); // mirrors at middle
                for (int j = 1; j <= 2 * n - 1; j++) {
                    if (j <= row || j >= (2 * n - row)) {
                        System.out.print("* "); 
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q201 – Row number printed at left & right edges (hollow diamond shape)
            // Row 1: 1 (spaces) 1
            // Row 2: 2 2 (spaces) 2 2
            // ...middle row: full row of row-number
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q201 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                for (int j = 1; j <= 2 * n - 1; j++) {
                    if (j <= row || j >= (2 * n - row)) {
                        System.out.print(row + " "); 
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q202 – 0/1 alternating at edges (like Q201 but values alternate 1,0,1,0…)
            // Row 1 → value 1, Row 2 → value 0, Row 3 → 1, etc.
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q202 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                int val = (row % 2 == 1) ? 1 : 0;
                for (int j = 1; j <= 2 * n - 1; j++) {
                    if (j <= row || j >= (2 * n - row)) {
                        System.out.print(val + " "); 
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q203 – Left side: 1,2,3…col;  Right side: (n-col+1)…n
            // Row 1: 1 (spaces) n
            // Row 2: 1 2 (spaces) n-1 n
            // Middle: 1 2 3 4 … n
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q203 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left part: 1 to row
                for (int j = 1; j <= row; j++) {
                    System.out.print(j + " ");
                }
                // spaces in between (gap = 2*(n - row) - 1 positions)
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right part: (n - row + 1) to n
                if (row < n) {
                    for (int j = n - row + 1; j <= n; j++) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q204 – Left edge always 1, right edge always 1; inner: alternates 0,1,0,1
            // Row 1: 1 (spaces) 1
            // Row 2: 1 0 (spaces) 0 1
            // Row 3: 1 0 1 (spaces) 1 0 1
            // Middle: 1 0 1 0 1 0 1
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q204 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                for (int j = 1; j <= 2 * n - 1; j++) {
                    if (j <= row || j >= (2 * n - row)) {
                        // value: 1 if j is odd, 0 if j is even
                        System.out.print((j % 2 == 1 ? 1 : 0) + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q205 – Left side: 1,2,3…; Right side: (n+1),(n+2)… in ascending per row
            // Row 1: 1 (spaces) 2
            // Row 2: 1 2 (spaces) 3 4
            // Row 3: 1 2 3 (spaces) 4 5 6
            // Middle row: 1 2 3 4 5 6 7
            // (right col values = n-row+2 … n+row-1 then 2*(row) downward on mirror)
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q205 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left: 1 to row
                for (int j = 1; j <= row; j++) {
                    System.out.print(j + " ");
                }
                // gap
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right: row+1 to 2*row  (mirrors counting from 1)
                if (row < n) {
                    for (int j = row + 1; j <= 2 * row; j++) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q206 – Left side: 1,2,3…row; Right side: …3,2,1 (mirror back to 1)
            // Row 1: 1 (spaces) 1
            // Row 2: 1 2 (spaces) 2 1
            // Middle: 1 2 3 4 3 2 1
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q206 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left: 1 to row
                for (int j = 1; j <= row; j++) {
                    System.out.print(j + " ");
                }
                // gap
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right: row-1 down to 1
                if (row < n) {
                    for (int j = row; j >= 1; j--) {
                        System.out.print(j + " ");
                    }
                } else {
                    // middle row: already printed 1..n, now print n-1 down to 1
                    for (int j = n - 1; j >= 1; j--) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q207 – Sequential numbers, left & right edges (continuous count)
            // Row 1: 1  (gap)  2
            // Row 2: 3 4 (gap) 5 6
            // Row 3: 7 8 9 (gap) 10 11 12
            // Middle: 13 14 15 16 17 18 19
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q207 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            int num = 1;
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                int leftCount = row;
                int rightCount = (row < n) ? row : 0;
                int gapCount = 2 * (n - row) - 1;

                // left
                for (int j = 0; j < leftCount; j++) {
                    System.out.printf("%-3d", num++);
                }
                // gap
                for (int s = 0; s < gapCount; s++) {
                    System.out.print("   ");
                }
                // right
                for (int j = 0; j < rightCount; j++) {
                    System.out.printf("%-3d", num++);
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q208 – Like Q207 but numbers go in reverse (descending) from max to 1
            // Row 1: 31 (gap) 30
            // Row 2: 29 28 (gap) 27 26
            // ...
            // Row 7 (bottom): 2 (gap) 1
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q208 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            // total numbers = same as Q207 = sum of 2*row for row=1..n-1 + n (middle)
            int total = 0;
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                total += row + (row < n ? row : 0);
            }
            num = total;
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                int leftCount = row;
                int rightCount = (row < n) ? row : 0;
                int gapCount = 2 * (n - row) - 1;

                for (int j = 0; j < leftCount; j++) {
                    System.out.printf("%-3d", num--);
                }
                for (int s = 0; s < gapCount; s++) {
                    System.out.print("   ");
                }
                for (int j = 0; j < rightCount; j++) {
                    System.out.printf("%-3d", num--);
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q209 – Characters at left and right edges (same letter per row)
            // Row 1 (A): A (gap) A
            // Row 2 (B): B B (gap) B B
            // Middle (D): D D D D D D D
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q209 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                char ch = (char) ('A' + row - 1);
                for (int j = 1; j <= 2 * n - 1; j++) {
                    if (j <= row || j >= (2 * n - row)) {
                        System.out.print(ch + " "); 
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q210 – Left edge always 'A', right side descends from last char
            // Row 1: A (gap) G
            // Row 2: A B (gap) F G
            // Row 3: A B C (gap) E F G
            // Middle: A B C D E F G
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q210 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left: A to A+row-1
                for (int j = 0; j < row; j++) {
                    System.out.print((char) ('A' + j) + " ");
                }
                // gap
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right: A+n-row to A+n-1  (the last 'row' letters up to last)
                if (row < n) {
                    for (int j = n - row; j < n; j++) {
                        System.out.print((char) ('A' + j) + " ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q211 – Continuous alphabet, hollow diamond (n=5)
            // Row 1: A (gap) B
            // Row 2: C D (gap) E F
            // Row 3: G H I J K
            // Row 4: L M (gap) N O
            // Row 5: P (gap) Q
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q211 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            char c = 'A';
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                int leftCount = row;
                int rightCount = (row < n) ? row : 0;
                int gapCount = 2 * (n - row) - 1;

                for (int j = 0; j < leftCount; j++) {
                    System.out.print(c++ + " ");
                }
                for (int s = 0; s < gapCount; s++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < rightCount; j++) {
                    System.out.print(c++ + " ");
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q212 – Reverse of Q211: letters count DOWN from Z (or last letter)
            // Row 1: Q (gap) P
            // Row 2: O N (gap) M L
            // Row 3: K J I H G
            // Row 4: F E (gap) D C
            // Row 5: B (gap) A
            // (n=5, starts from letter at position total-1 down to A)
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q212 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            // Count total chars needed (same calc as Q211)
            int totalChars = 0;
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                totalChars += row + (row < n ? row : 0);
            }
            c = (char) ('A' + totalChars - 1); // start from last letter
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                int leftCount = row;
                int rightCount = (row < n) ? row : 0;
                int gapCount = 2 * (n - row) - 1;

                for (int j = 0; j < leftCount; j++) {
                    System.out.print(c-- + " ");
                }
                for (int s = 0; s < gapCount; s++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < rightCount; j++) {
                    System.out.print(c-- + " ");
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q213 – Left side: A,B,C…; Right side: D,E,F… (two separate ascending seqs)
            // Row 1: A (gap) B
            // Row 2: A B (gap) C D
            // Row 3: A B C (gap) D E F
            // Middle: A B C D E F G
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q213 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left: A to A+row-1
                for (int j = 0; j < row; j++) {
                    System.out.print((char) ('A' + j) + " ");
                }
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right: A+row to A+2*row-1
                if (row < n) {
                    for (int j = row; j < 2 * row; j++) {
                        System.out.print((char) ('A' + j) + " ");
                    }
                }
                System.out.println();
            }

            // ─────────────────────────────────────────────
            // Q214 – Left side: A,B,C…row; Right side: …C,B,A (mirror of left)
            // Row 1: A (gap) A
            // Row 2: A B (gap) B A
            // Row 3: A B C (gap) C B A
            // Middle: A B C D C B A
            // ─────────────────────────────────────────────
            System.out.println("\n=== Q214 ===");
            System.out.print("Enter the Number of Rows: ");
            n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                int row = (i <= n) ? i : (2 * n - i);
                // left: A to A+row-1
                for (int j = 0; j < row; j++) {
                    System.out.print((char) ('A' + j) + " ");
                }
                int gap = 2 * (n - row) - 1;
                for (int s = 0; s < gap; s++) {
                    System.out.print("  ");
                }
                // right: A+row-1 down to A  (mirror)
                if (row < n) {
                    for (int j = row - 1; j >= 0; j--) {
                        System.out.print((char) ('A' + j) + " ");
                    }
                } else {
                    // middle: already printed A..D, now print C..A
                    for (int j = n - 2; j >= 0; j--) {
                        System.out.print((char) ('A' + j) + " ");
                    }
                }
                System.out.println();
            }

            sc.close();
    }

    // public static void pattern201(int n) {
    //     int mid = n / 2;
    //     for (int i = 0; i < n; i++) {
    //         int stars;
    //         if (i <= mid)
    //             stars = i + 1;
    //         else
    //             stars = n - i;
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print("* ");     // Left Stars
    //         for (int j = 1; j <= 2 * (mid - stars + 1); j++)
    //             System.out.print("  ");     // Spaces
    //         for (int j = 1; j <= stars; j++)
    //             System.out.print("* ");     // Right Stars
    //         System.out.println();
    //     }
    // }
    // public static void main(String[] args) {
    //     pattern203(5);
    // }
}

