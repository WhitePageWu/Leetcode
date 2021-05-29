package String;

/**
 * @className: Leetcode_415
 * @description: TODO 字符串相加
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_415 {
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //num1的长度大于等于num2
        StringBuilder sb = new StringBuilder();
        int ans = 0;//进位
        int k = 0;
        for (int i = num1.length()-1;i>=0;i--,k++){
            if (k<num2.length()){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(num2.length()-1-k)-'0';
                int c = (a+b+ans)%10;
                ans = (a+b+ans)/10;
                sb.append(c);
            }else {
                int temp = num1.charAt(i)-'0';
                if (ans!=0){
                    int a  = (temp+1)%10;
                    ans=(temp+1)/10;
                    temp = a;
                }
                sb.append(temp);
            }
        }
        if (ans!=0){
            sb.append(ans);
        }
        char[] ch = sb.toString().toCharArray();
        int left = 0,right = ch.length-1;
        while (left<right){
            char temp = ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;right--;
        }
        return new String(ch);
    }
    /**
     *@描述 经典方法，学习
     *@参数 [java.lang.String, java.lang.String]
     *@返回值 java.lang.String
     *@创建人 wuyurong
     *@创建时间 2021/5/28
     */
    public static String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings2("6994","36"));
    }
}
