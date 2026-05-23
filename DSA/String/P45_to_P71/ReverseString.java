package String.P45_to_P71;

import java.util.Stack;

public class ReverseString {

    // q-51) Reverse Characters Except Spaces
    public static String reverseCharExceptSpaces(String s){
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == ' ')
                left++;
            else if (arr[right] == ' ')
                right--;
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;     right--;
            }
        }return new String(arr);
    }
    
    
    // Q52. Reverse Only Letters
    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (!Character.isLetter(arr[left]))
                left++;
            else if (!Character.isLetter(arr[right]))
                right--;
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;     right--;
            }
        }return new String(arr);
    }

    // Q57. Reverse Words in a String
    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Q56. Reverse Each Word
    public static void reverseEachWord(String s) {
        String[] arr = s.split(" ");

        for (String word : arr) {

            for (int i = word.length() - 1; i >= 0; i--) {
                System.out.print(word.charAt(i));
            }

            System.out.print(" ");
        }
    }

    // Q55. Reverse Word Order
    public static void reverseWordOrder(String s) {
        String[] arr = s.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    // Q58. Reverse Every Word with Dot
    public static void reverseEveryWord(String s) {
        String[] arr = s.split(" ");
        for (String word : arr) {
            for (int i = word.length() - 1; i >= 0; i--) {
                System.out.print(word.charAt(i));
            }
            System.out.print(" ");
        }
    }

    // Q59. Reverse Words in a String III
    public static String reverseWords2(String s) {

        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : arr) {

            StringBuilder temp = new StringBuilder(word);

            sb.append(temp.reverse()).append(" ");
        }

        return sb.toString().trim();
    }

    // q-60) Reverse String II
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // Q61. Reverse String II
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1);
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    // Q62. Reverse Prefix of Word
    public static String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(
                word.substring(0, idx + 1));
        sb.reverse();
        sb.append(word.substring(idx + 1));
        return sb.toString();
    }

    // Q63. Expand Compressed String
    public static String expandCompressed(String s){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {

            char ch = s.charAt(i);

            int count = s.charAt(i + 1) - '0';

            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        }
        return new String(sb);
    }

    // Q64. Decode String
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String current = "";
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = "";
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp =
                        new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++)
                    temp.append(current);

                current = temp.toString();
            } else {
                current += ch;
            }
        }return current;
    }

}
