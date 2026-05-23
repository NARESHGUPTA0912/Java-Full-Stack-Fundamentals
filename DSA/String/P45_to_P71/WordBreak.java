package String.P45_to_P71;

import java.util.Arrays;
import java.util.List;
// Q53. Word Break
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // Q54. Print Each Word in New Line
    public static void printEachWordInNewLine(){
        String s = "mohan and sohan are here.";
        String[] arr = s.split(" ");
        for (String word : arr) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> list = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, list));
    }
}
