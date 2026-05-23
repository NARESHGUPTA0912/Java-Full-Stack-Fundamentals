package String.P25_To_P44;

import java.util.HashSet;
import java.util.Set;

public class PrintDigitFromString {

    // question - 27
    public static int biggestNumeric(String s){
        int max = 0;
        for (int i = 0; i < s.length(); i++) 
            if(Character.isDigit(s.charAt(i)) && max < s.charAt(i))
                max = s.charAt(i);
        return max>0 ? max-'0' : -1;
    }

    // question - 28
    public static int secondBiggestNumeric(String s){
        int max = 0, secMax=0;
        for (int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) && max < s.charAt(i))
                max = s.charAt(i);
            if(Character.isDigit(i) && secMax < s.charAt(i) && s.charAt(i) != max)
                secMax = s.charAt(i);
        }return secMax>0 ? secMax-'0' : -1;
    }

    // q - 29 ( print all Uppercase character of the String exactly once
    public static String printAllUCOnce(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(Character.isUpperCase(c)){
                set.add(c);
            }
        }
        return set.toString();
    }

    // q - 30 ( print all Lowercase character of the String exactly once
    public static String printAllLCOnce(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                set.add(c);
            }
        }
        return set.toString();
    }

    // q - 31 ( print all the character of the String exactly once
    public static String printAllCharsOnce(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                set.add(c);
            }
        }
        return set.toString();
    }

    // q - 31
    public static void printAllCharsExactlyOnce(String s){
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println(ch);
            }
        }
    }


    public static void main(String[] args) {
        String s = "sdSFFJWsjsSSJkkK39798792jdhhdsDDFSA";
        System.out.println(printAllCharsOnce(s));
        printAllCharsExactlyOnce(s);
    }
}
