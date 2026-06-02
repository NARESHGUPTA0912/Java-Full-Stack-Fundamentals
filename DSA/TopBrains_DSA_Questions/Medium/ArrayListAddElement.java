package Medium;

import java.util.ArrayList;

public class ArrayListAddElement {
    public static int addToList(String s){
        String[] words = s.trim().split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        return list.size();
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5";
        int result = addToList(input);
        System.out.println("Number of elements added to the list: " + result);
    }
}
