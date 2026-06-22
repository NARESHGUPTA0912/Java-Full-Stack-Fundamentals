
public class TypesOfOperatorsExample {

    public static void ArithMeticOperators(int a, int b) {
        System.out.println("1) Arithmetic Operators:");
        int add = a + b;
        float div = a / b;
        double mod = a % b;
        long Mul = a * 3;
        int sub = a - b;
        System.out.println("Add: " + add + ", Div: " + div + ", Mod: " + mod + ", Mul: " + Mul + ", Sub: " + sub);

    }

    public static void AssignmentOperators(int a) {
        System.out.println("2) Assignment Operators:");
        int add, Mul, sub, mod;
        double div = 2.2;
        add = Mul = sub = mod = 2; // assignment operator
        add += a; // aka Compound Operators OR Shorthand Operators
        div /= a;
        mod %= a;
        Mul *= a;
        sub -= a;
        System.out.println("Add: " + add + ", Div: " + div + ", Mod: " + mod + ", Mul: " + Mul + ", Sub: " + sub);
    }

    public static void comparisonOperators(int a, int b) {
        System.out.println("3) Comparison Operators OR Relational Operators:");
        System.out.println("Comparing a = " + a + " and b = " + b);
        System.out.println("a == b : " + (a == b));     // Equal to
        System.out.println("a != b : " + (a != b));     // Not equal to
        System.out.println("a > b  : " + (a > b));      // Greater than
        System.out.println("a < b  : " + (a < b));      // Less than
        System.out.println("a >= b : " + (a >= b));    // Greater than or equal
        System.out.println("a <= b : " + (a <= b));    // Less than or equal
    }

    public static void BitWiseOperators(int a, int b) {
        System.out.println("4) Bitwise Operators:");
        System.out.println("a & b : " + (a & b)); // Bitwise AND
        System.out.println("a | b : " + (a | b)); // Bitwise OR
        System.out.println("a ^ b : " + (a ^ b)); // Bitwise XOR
        System.out.println("~a    : " + (~a));    // Bitwise NOT
        System.out.println("a << 1: " + (a << 1)); // Left shift
        System.out.println("b >> 1: " + (b >> 1)); // Right shift
        System.out.println("a >>> 1: " + (a >>> 1)); // Unsigned right shift
        // System.out.println("a <<< 1: " + (a >>> 1)); // Unsigned left shift
    }

    public static void logicalOperators(boolean a, boolean b) {
        System.out.println("5) Logical Operators:");
        System.out.println("a && b : " + (a && b)); // Logical AND
        System.out.println("a || b : " + (a || b)); // Logical OR
        System.out.println("!a     : " + (!a));     // Logical NOT
    }

    public static void TernaryOperator(int a, int b) {
        int max = (a > b) ? a : b;
        System.out.println("6) Ternary Operators OR Conditional Operators: {Max} = " + max);

    }

    public static void UnaryOperators(int a) {
        System.out.println("7) Unary Operators OR Increment/Decrement Operators:");
        System.out.println("PreIncrement: " + ++a);
        System.out.println("PostIncrement: " + a++);
        System.out.println("PostDecrement: " + a--);
        System.out.println("PreDecrement: " + --a);
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        ArithMeticOperators(6, 2);
        System.out.println("----------------------------------------------------");
        AssignmentOperators(8);
        System.out.println("----------------------------------------------------");
        comparisonOperators(5, 10);
        System.out.println("----------------------------------------------------");
        logicalOperators(true, false);
        System.out.println("----------------------------------------------------");
        BitWiseOperators(5, 2);
        System.out.println("----------------------------------------------------");
        TernaryOperator(7, 2);
        System.out.println("----------------------------------------------------");
        UnaryOperators(7);
        System.out.println("----------------------------------------------------");
    }
}
