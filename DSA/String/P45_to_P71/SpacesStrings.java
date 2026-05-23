package String.P45_to_P71;

public class SpacesStrings {
    // Q48. Backspace String Compare
    public static String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    // Q49. Adding Spaces to a String
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(' ');
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Q50. Rearrange Spaces Between Words
    public static String reorderSpaces(String text) {
        int spaces = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ')
                spaces++;
        }
        String[] words = text.trim().split("\\s+");
        if (words.length == 1) {
            StringBuilder sb = new StringBuilder(words[0]);
            while (spaces-- > 0)
                sb.append(" ");
            return sb.toString();
        }
        int evenSpaces = spaces / (words.length - 1);
        int extra = spaces % (words.length - 1);
        String gap = " ".repeat(evenSpaces);
        String result = String.join(gap, words);
        result += " ".repeat(extra);
        return result;
    }
}
