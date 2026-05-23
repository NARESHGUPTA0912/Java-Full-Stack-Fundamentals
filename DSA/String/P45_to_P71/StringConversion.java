package String.P45_to_P71;

public class StringConversion {

    // Q65. Sum of All Numbers in String
    public static int sumOfAllNum(String s){
        int sum = 0;
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num += ch;
            } else {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        if (!num.isEmpty())
            sum += Integer.parseInt(num);
        return sum;
    }

    // Q66. Print and Count Even Length Words
    public static void printAndCountEvenLength(String s){
        String[] arr = s.split(" ");
        int count = 0;
        for (String word : arr)
            if (word.length() % 2 == 0) 
                System.out.println(word);
                count++;
        System.out.println("Total = " + count);
    }
    
    // Q67. Print and Count Odd Length Words
    public static void printAndCountOddLength(String s){
        String[] arr = s.split(" ");
        int count = 0;
        for (String word : arr)
            if (word.length() % 2 != 0) 
                System.out.println(word);
                count++;
        System.out.println("Total = " + count);
    }

    // Q68. Largest Word in String
    public static String largestWord(String s){
        String[] arr = s.split(" ");
        String largest = "";
        for (String word : arr)
            if (word.length() > largest.length()) 
                largest = word;

        return largest;
    }


    // Q69. Convert First Character of Each Word to Uppercase
    public static String pascalCase(String s){
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : arr) {

            char first = Character.toUpperCase(word.charAt(0));

            sb.append(first)
              .append(word.substring(1))
              .append(" ");
        }return sb.toString().trim();
    }

    //q-70) Convert First Character of Each Sentence to Uppercase
    public static String firstCapitalizeInSentence(String s){
        char[] arr = s.toCharArray();

        boolean capitalize = true;

        for (int i = 0; i < arr.length; i++) {

            if (capitalize && Character.isLetter(arr[i])) {

                arr[i] = Character.toUpperCase(arr[i]);

                capitalize = false;
            }

            if (arr[i] == '.') {
                capitalize = true;
            }
        }return new String(arr);
    }
    
    // q-71) convert  upper to lower
    public static String upperToLower(String s){
        String result = "" ;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }return result;
    }
    
    // q-71) convert lower to upper
    public static String lowerToUpper(String s){
         String result = "" ;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }return result;
    }

    public static void main(String[] args) {
        
    }
}
