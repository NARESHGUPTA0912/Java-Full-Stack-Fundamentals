package String.P25_To_P44;

public class MissingDigit {
    public static void main(String[] args) {
        int actual = 0;
        String s = "45210";
        int total = s.length()*((s.length()+1)/2);
        for(int i=0; i<s.length(); i++){
            actual = actual + s.charAt(i) - '0';
        }System.out.println("Missing Digit: " + (total - actual));
        
    }
}
