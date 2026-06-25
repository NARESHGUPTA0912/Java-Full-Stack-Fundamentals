package javaIntermediate.Strings;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Anushka");
        System.out.println(sb);

        // methods
        System.out.println(sb.charAt(0));
        sb.setCharAt(1, 'r');
        System.out.println(sb);
        sb.deleteCharAt(1);
        sb.setCharAt(1, 'n');
        sb.insert(2, 'u');
        System.out.println(sb.capacity());
        System.out.println(sb);
        sb.append(" Pal");
        System.out.println(sb);

        sb.delete(7,11);
        System.out.println(sb.length());
        System.out.println(sb.reverse());
        System.out.println(sb.isEmpty());
        System.out.println(sb.hashCode());
        System.out.println(sb.repeat(sb, 2));
        System.out.println(sb.insert(11, 0.2));
        System.out.println(sb);
        System.out.println(sb.reverse());
        // sb.trimToSize();
        CharSequence ch = sb.subSequence(0, 7);
        System.out.println(ch);
        System.out.println(sb.substring(0, 7));
    }
}
