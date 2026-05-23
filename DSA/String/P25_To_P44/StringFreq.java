package String.P25_To_P44;

public class StringFreq {

    // utility method
    public static int[] freqArray(String s){
        int[] freq = new int[256];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c]++ ;
        }
        return freq;
    }

    // 32 - print the frequency of each character of the String
    public static void freq(String s){
        int[] freq = freqArray(s);
        for(int i=0; i<freq.length; i++){
            if(freq[i]>0) System.out.println((char)i +" -> " + freq[i]);
        }
    }
    
    // 33 - print all character of the String that appeared only once
    public static void CharfreqOnce(String s){
        int[] freq = freqArray(s);
        for(int i=0; i<freq.length; i++){
            if(freq[i]==1) System.out.println((char)i +" -> " + freq[i]);
        }
    }
    
    // 34 - print all character of the String that appeared more than once
    public static void CharfreqMorethanOnce(String s){
        int[] freq = freqArray(s);
        for(int i=0; i<freq.length; i++){
            if(freq[i]>1) System.out.println((char)i +" -> " + freq[i]);
        }
    }
    
    // 35 - print the  character of the String that appeared only once
    public static void CharfreqOnce2(String s){
        int[] freq = freqArray(s);
        for(int i=0; i<freq.length; i++){
            if(freq[i]==1) System.out.println((char)i +" -> " + freq[i]);
        }
    }
    // 35
    public static void UniqueChars(String s){
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("Unique Character: " + ch);
                break;
            }
        }
    }

    // 36 - Print character with maximum frequency
    // public static void maxFreq(String s){
    //     int[] freq = freqArray(s);
    //     int max = 0;    char c;
    //     for(int i=0; i<freq.length; i++){
    //         max = Math.max(max, freq[i]);
    //         char c = 
    //     }
    //     System.out.println(max);
    // }

    public static void maxFreq(String s){
        char maxChar = s.charAt(0);
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++)
                if (s.charAt(j) == ch)
                    count++;

            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
            }
        }
        System.out.println("Maximum Frequency Character: " + maxChar);
    }

    public static void maxFreqSmallifTie(String s){
        char result = s.charAt(0);
        int maxCount = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int count = 0;
            for(int j=0; j<s.length(); j++)
                if(s.charAt(j) == ch) count++ ;

            if(count > maxCount || (count == maxCount && ch < result)){
                maxCount = count;       result = ch;
            }
        }System.out.println("Answer: " + result + "");
    }

    public static void maxFreqBigifTie(String s){
        char result = s.charAt(0);
        int maxCount = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int count = 0;
            for(int j=0; j<s.length(); j++)
                if(s.charAt(j) == ch) count++ ;

            if(count > maxCount || (count == maxCount && ch > result)){
                maxCount = count;       result = ch;
            }
        }System.out.println("Answer: " + result + "");
    }

    // q - 39 First non-repeating character index
    public static int firstNonRepeatingCharIndex(String s){
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int count = 0;
            for(int j=0; j<s.length(); j++)
                if(s.charAt(j) == ch)
                    count++;
            if(count == 1){
                return i; 
            }
        }return -1;
    }

    // q - 40 Minimum frequency character
    public static void minFreqChar(String s){
        int min = Integer.MAX_VALUE;
        char result = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch) {
                    count++;
                }
            }

            if (count < min) {
                min = count;
                result = ch;
            }
        }

        System.out.println("Minimum Frequency Character: " + result);
    }

    public static void main(String[] args) {
        String s = "hhuujjhl";
        // System.out.println(firstNonRepeatingCharIndex(s));
        minFreqChar(s);
    }
}
