package switchcase;

class Table {
    
    public static void generateTable(int n){
        for(int i=1; i<=10; i++){
            System.out.print(n+" X "+i+" = "+n*i+"\t");
        }System.out.println();
    }

    public static void generateTableUptoNNumber(int n){
        for(int i=1; i<=n; i++){
            generateTable(i);
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        generateTableUptoNNumber(25);
    }
}
