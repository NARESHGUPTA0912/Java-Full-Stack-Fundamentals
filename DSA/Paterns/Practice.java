package Paterns;

public class Practice {

    public static void printPattern(int n) {
        // int no = n;
        // // for(int i=1; i<=n; i++){

        // //     for(int k=1; k<=i; k++){
        // //         System.out.printf("");
        // //     }
        // // }
        // for (int i = 1; i <= n; i++) {
        //     // no = n;
        //     for (int j = 1; j <= n - i; j++) {
        //         System.out.print("  ");
        //     }
        //     for (int k = 1; k <= i; k++) {
        //         System.out.print("  "+no +" ");
        //     }no--;
        //     System.out.println();
        // }

        for(int i=1; i<=n; i++){
            for(int j=n; j>=i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    // print the thor hammer 'mjolnir'
    // public static void printPattern(int n){
    //     int mid = n/2 + 1;
    //     for(int i=1; i<=n; i++){
    //         for(int j=1; j<=n; j++){
    //            if(i<=mid || i==mid || j==mid){
    //             System.out.print("* ");
    //            }else{
    //             System.out.print("  ");
    //            }
    //         }System.out.println();
    //     }
    // }

    public static void printPattern2(int n){
		int space=0;	int star=n;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=space;j++) System.out.print("  ");
			for(int j=1;j<=star;j++) System.out.print("* ");
		space++;	star--;
		System.out.println();
		}
	}
    public static void main(String[] args) {
        printPattern2(5);
    }
}
