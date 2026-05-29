package Paterns;

class PascalTriangle {

    public static void pattern(int n){
        for(int i=0; i<n; i++){
            int num = 1;

            // Spaces
            for(int j=0; j<n-i; j++){
                System.out.print("  ");
            }

            // Numbers
            for(int k=0; k<=i; k++){
                System.out.printf(" %2d ",num);

                // Formula the next number
                num = num * (i-k) / (k+1);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        pattern(7);
    }
}