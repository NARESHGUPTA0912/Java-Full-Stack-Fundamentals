package String.P45_to_P71;

import java.util.HashSet;

public class Substrings {
    
    // Q45. Check if a String is Substring of Another String
    public static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    // Q46. Longest Substring Without Repeating Characters
     public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }return max;
    }

    // Q47. Longest Palindromic Substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;     right++;
        }
        return right - left - 1;
    }
}
