public class TypesOfOperatorsExample {

       public static void ArithMeticOperators(int a, int b){
                System.out.println("Arithmetic Operators:");
                int add = a+b;
                float div = a/b;
                double mod = a%b;
                long Mul = a*3; 
                int sub = a-b;
                System.out.println("Add: "+add+", Div: "+div+", Mod: "+mod+", Mul: "+Mul+", Sub: "+sub);
                
        }

        public static void AssignmentOperators(int a){
                System.out.println("Assignment Operators:");
                int add, Mul, sub, mod; double div = 2.2;
                add=Mul=sub=mod=2;
                add += a;
                div /= a;
                mod %= a;
                Mul *= a; 
                sub -= a;
                System.out.println("Add: "+add+", Div: "+div+", Mod: "+mod+", Mul: "+Mul+", Sub: "+sub);
        }

        public static void comparisonOperators(int a, int b) {
            System.out.println("Comparison Operators:");
            System.out.println("Comparing a = " + a + " and b = " + b);
            System.out.println("a == b : " + (a == b));     // Equal to
            System.out.println("a != b : " + (a != b));     // Not equal to
            System.out.println("a > b  : " + (a > b));      // Greater than
            System.out.println("a < b  : " + (a < b));      // Less than
            System.out.println("a >= b : " + (a >= b));    // Greater than or equal
            System.out.println("a <= b : " + (a <= b));    // Less than or equal
        }

        public static void BitWiseOperators(int a, int b) {
            System.out.println("Bitwise Operators:");
            System.out.println("a & b : " + (a & b)); // Bitwise AND
            System.out.println("a | b : " + (a | b)); // Bitwise OR
            System.out.println("a ^ b : " + (a ^ b)); // Bitwise XOR
            System.out.println("~a    : " + (~a));    // Bitwise NOT
            System.out.println("a << 1: " + (a << 1)); // Left shift
            System.out.println("b >> 1: " + (b >> 1)); // Right shift
            System.out.println("a >>> 1: " + (a >>> 1)); // Unsigned right shift
            System.out.println("a <<< 1: " + (a >>> 1)); // Unsigned left shift
        }

        public static void logicalOperators(boolean a, boolean b) {
            System.out.println("Logical Operators:");
            System.out.println("a && b : " + (a && b)); // Logical AND
            System.out.println("a || b : " + (a || b)); // Logical OR
            System.out.println("!a     : " + (!a));     // Logical NOT
        }

        public static void TernaryOperator(int a, int b){
            int max = (a > b) ? a : b;
            System.out.println("Ternary Operators : {Max} = "+ max);

        }

    public static void main(String []args){
        ArithMeticOperators(6, 2);
        AssignmentOperators(8);
        comparisonOperators(5, 10);
        logicalOperators(true, false);
        BitWiseOperators(5, 2);
        TernaryOperator(7, 2);
    }
}
