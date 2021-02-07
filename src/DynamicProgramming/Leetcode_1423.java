package DynamicProgramming;

import java.util.Arrays;

//可获得的最大点数
public class Leetcode_1423 {
    public static void main(String[] args) {
        int[] arr = {1,1000,2,3,4,5};
        System.out.println(maxScore(arr,3));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int window = len-k;
        int sum = 0;
        for (int i=0;i<window;i++){
            sum+=cardPoints[i];
        }
        int minsum = sum;
        for(int i = window;i<len;i++){
            sum += cardPoints[i] - cardPoints[i - window];
            minsum = Math.min(minsum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minsum;
    }
}
