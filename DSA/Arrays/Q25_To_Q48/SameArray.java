package Q25_To_Q48;
public class SameArray {
    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        int[] b = {1,2,3,4};

        boolean flag = true;

        if(a.length != b.length) {
            flag = false;
        }
        else {
            for(int i=0; i<a.length; i++) {
                if(a[i] != b[i]) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
    }
}