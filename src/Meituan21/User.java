package Meituan21;

import java.util.Scanner;

public class User {
    public static String isAvailable(String name){
        if (name==null||name.length()>20){
            return null;
        }
        boolean alpha=false;
        boolean num = false;
        for (int i =0;i<name.length();i++){
            if (i==0){
                char first = name.charAt(0);
                if (first-'A'<0||(first-'Z'>0&&first-'a'<0)||first-'z'>0){
                    return "Wrong";
                }
            }
            char temp = name.charAt(i);
            if (temp-'0'<0||(temp-'9'>0&&temp-'A'<0)||(temp-'Z'>0&&temp-'a'<0)||temp-'z'>0){
                return "Wrong";
            }
            if (temp-'0'>=0&&temp-'9'<=0){
                num=true;
            }
            if ((temp-'A'>=0&&temp-'Z'<=0)||(temp-'a'>=0&&temp-'z'<=0)){
                alpha=true;
            }
        }
        if (alpha&&num){
            return "Accept";
        }else {
            return "Wrong";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        String[] arr = new String[T];
        for (int i=0;i<T;i++){
            arr[i] = in.next();
        }
        for (int j =0;j<T;j++){
            System.out.println(isAvailable(arr[j]));
        }
    }
}
