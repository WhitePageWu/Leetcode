import java.io.Console;

public class Test {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 =s1;
        String s4 = s2;
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3);
        System.out.println(s1==s2);
        System.out.println("hello"==s1);
        System.out.println("--------");
    }

}
