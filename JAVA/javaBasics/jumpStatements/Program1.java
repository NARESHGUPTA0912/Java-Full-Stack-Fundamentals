package javaBasics.jumpStatements;

/** Important Points:
 * 1) break only used in loops and switch and continue only used in loops
 * 2) label is just an identifier followed by ':'
 * 3) labelled break can used in if blocks as well as in normal blocks
 * 4) label can access inside their scope only.
 * 5) we can label a code blocks
   6) label can only works on executable statements not on declarative statements.
   7) Best practices: 
        -> avoid overuse, infinite loop, unreachable code.
        -> use sparingly, clear comments, consistent labelling

 */



public class Program1 {
    public static void main(String[] args) {
        // labelBreak();
        // labelContinue();
        labelBreakInIf();

        labelBlock:
        {
            System.out.println("This is labelled block");
            break labelBlock;       // allowed
            // System.out.println("This is labelled Statement"); // can cause unreachable compilation error
        }

      // allowed 
        int a = 5;      // executable statement or expression statement allowed
        labelVar: a = 7;
        System.out.println(a);

      // not allowed
    //   labelVar2: int b = 6;      declaration statement cause compilation error

    }

    public static void labelBreak(){
        outer:
        for(int i=1; i<3; i++){
            for(int j=1; j<3; j++){
                if(j==2){
                    break outer;    // if we dont use label then break only innermost loop
                }
                System.out.println("i: " + i + " " + "j: " + j);
            }
        } System.out.println("Comes out from block");
    }

    public static void labelContinue(){
        outer:
        for(int i=1; i<3; i++){
            for(int j=1; j<3; j++){
                if(j==2){
                    continue outer;    // // if we dont use label then continue skip only innermost loop iteration
                }
                System.out.println("i: " + i + " " + "j: " + j);
            }
        } System.out.println("Comes out from block");
    }

    public static void labelBreakInIf(){
        int n=3;
        outer:
        if (n > 0){
            System.out.println("Number is Positive");
            if (n % 2 == 0) {
                System.out.println("Number is Even");
            } else {
                System.out.println("Number is Odd");
                break outer;    // Exiting the labelled block
            }
            System.out.println("This will only print if number is even");
        } System.out.println("This is outside the labelled block");
    }

    public static void print(){
        int num=0;
        while(num<20){
            num++;
            if(num<=7){
                continue;
            }System.out.println("Number: " + num);
            if(num >= 15 ){
                break;
            }
        }
    }
}
