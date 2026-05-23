package Q25_To_Q48;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int []a = {0,1,0,3,12};
        int count = 0;
        for(int i=0; i<a.length; i++)
            if(a[i]!=0)
                a[count++] = a[i];

        while(count < a.length)
            a[count++] = 0;

        for(int x: a)
            System.out.print(x+" ");
    }
}