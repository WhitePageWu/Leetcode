import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        String c = new String("!");
        String a = "1";
        String b ="1";
        String d = a;
        String e = c;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(c==e);
        System.out.println(a==e);
        System.out.println();
        String[] strings = {"aaa","bb","c"};
        Arrays.sort(strings,new LengthCompare());
        System.out.println(Arrays.toString(strings));
    }
    public static int get(){
        try {
            return 0;
        }finally {
            return 1;
        }
    }
}

class LengthCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}