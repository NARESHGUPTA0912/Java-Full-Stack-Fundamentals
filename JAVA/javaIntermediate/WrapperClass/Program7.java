package javaIntermediate.WrapperClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program7 {
    public static void main(String[] args) {
        Byte a = 10;
        Short b = 20;
        Integer c = 30^20;
        Long d = 40L^30;
        Float e = 50.00F;
        Double f = 60.00;
        Boolean g = !false;
        Character h = 80;
        List<Object> list = new ArrayList<>(Arrays.asList(a,b,c,d,e,f,g,h));
        System.out.println(list);
    }
}
