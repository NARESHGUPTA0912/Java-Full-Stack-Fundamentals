package Paterns;

public class pattern200To214 {
    
    public static void pattern200(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern201(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(i+"  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern202(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(i%2 +"  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern203(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(j +"  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern204(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(j%2 +"  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern205(int n){
        for (int i = 1; i <= n; i++) {
            int num=1;
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(num++ +"  ");
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern206(int n){
        for (int i = 1; i <= n; i++) {
            int num=1, mid = (n/2) +1;
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.print(num +"  ");
                    if(j<mid) num++;
                    else      num--;
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern207(int n){
        int num=1;
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%-3d",num++);
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern208(int n){
        int num=(n*n)/2 + n;
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%-3d",num--);
                } else {
                    System.out.print("   ");
                }
            }System.out.println();            
        }
    }

    public static void pattern209(int n){
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch);
                } else {
                    System.out.print("   ");
                }
            }System.out.println();      ch++;           
        }
    }

    public static void pattern210(int n){
        for (int i = 1; i <= n; i++) {
            char ch = 'A';
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch);
                } else {
                    System.out.print("   ");
                }ch++;
            }System.out.println();      //ch++;           
        }
    }

    public static void pattern211(int n){
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch++);
                } else {
                    System.out.print("   ");
                }//ch++;
            }System.out.println();      //ch++;           
        }
    }

    public static void pattern212(int n){
        char ch = (char) (64 + n*n/2 +5);
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch--);
                } else {
                    System.out.print("   ");
                }//ch++;
            }System.out.println();      //ch++;           
        }
    }

    public static void pattern213(int n){
        for (int i = 1; i <= n; i++) {
            char ch = 'A';
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch++);   
                } else {
                    System.out.print("   ");
                }
            }System.out.println();           
        }
    }

    public static void pattern214(int n){
        int mid = n/2+1;
        for (int i = 1; i <= n; i++) {
            char ch = 'A';
            for(int j=1;j<=n; j++){
                if((j<=i && j<=n-i+1) || (j>=i && j>=n-i+1)){
                    System.out.printf("%3c",ch);
                } else {
                    System.out.print("   ");
                }if(j<mid) ch++;
                    else      ch--;
            }System.out.println();      //ch++;           
        }
    }

    public static void main(String[] args) {
        pattern214(7);
    }
}
