package String;

public class Leetcode_557 {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str :strs ){
            char[] ch = str.toCharArray();
            int head = 0 ,tail=ch.length-1;
            while (head<tail){
                char temp = ch[head];
                ch[head]=ch[tail];
                ch[tail]=temp;
                head++;
                tail--;
            }
            sb.append(new String(ch));
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
