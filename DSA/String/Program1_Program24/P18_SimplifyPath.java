package String.Program1_Program24;

import java.util.Stack;

public class P18_SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            switch (part) {
                case "", "." -> {
                }
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.pop(); // Go back to parent directory
                    }
                }
                default -> stack.push(part); // Add directory to stack
            }
            // Skip empty and current directory
                    }
        return "/" + String.join("/", stack); // Join stack to form simplified path
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/demo.txt";
        System.out.println("Simplified Path: " + simplifyPath(path));
    }
}
