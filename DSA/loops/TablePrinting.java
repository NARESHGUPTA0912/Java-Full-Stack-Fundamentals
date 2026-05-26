public class TablePrinting {
    public static void main(String[] args) {
        int num = 20;
        printTable(num);
    }
    
    public static void printTable(int num){
        // one box 1*8(-)
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=1; i<=10; i++){
            for(int j=1; j<=num; j++){
                System.out.printf("|  %d\t",i*j);
                // System.out.printf("|\t%dX%d = %d\t",i,j,i*j);
            }System.out.println("|");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
