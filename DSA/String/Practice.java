// 14, 

package String;

import java.util.HashSet;
import java.util.Set;

public class Practice {

    public static void main(String[] args) {
        // String str = "rank";
        String str = "sshgghdjjdkkllaiwjkkaksj";
        System.out.println(removeDuplicate(str));
    }
    public static String removeDuplicate(String s){
        Set<Character> set = new HashSet<>();
        String str = "";
        for(int i=0; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                str = str+s.charAt(i);
            }
        }
        return str;
    }
}
