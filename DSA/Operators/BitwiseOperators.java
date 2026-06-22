public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println(a & b);  // 1 Bitwise AND (Check both bit will be 1)
        System.out.println(a | b);  // 7 Bitwise OR  (Check one bit will be 1)
        System.out.println(a ^ b);  // 6 Bitwise XOR (Check both bit will be different)
        System.out.println(~a + " or " + ~b); // Bitwise NOT (flip the bits [1 -> 0 and 0 -> 1] result can comes in 2`s complement)


        int c = 10, d = 20;
        // (A|B) - (A&B) = A XOR B
        System.out.println("XOR (OR - AND): " + ((c|d) - (c&d)));
        System.out.println("OR " + (c|d));
        System.out.println("AND "+(c&d));
        System.out.println("XOR " + (c^d));

        int e = 4;
        System.out.println(e >> 1);  // Bitwise right shift (preserving sign bit at left)        // 0100 -> 0010
        System.out.println(e<<1);    // Bitwise left shift while adding zero at right            // 0100 -> 1000
        System.out.println(e >>> 1); // Bitwise unsigned right shift while adding zero at left   // 0100 -> 0010

    }
}
