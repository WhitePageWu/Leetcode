package BInarySearch;

public class Leetcode_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles)+1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (canFinish(piles,h,mid)){
                right = mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    public int getMax(int[] piles){
        int max = 0;
        for(int n:piles){
            max = Math.max(n,max);
        }
        return max;
    }
    public boolean canFinish(int[] piles, int h, int speed){
        int time = 0;
        for (int n:piles){
            time+=timeOf(n,speed);
        }
        return time<=h;
    }
    public int timeOf(int n,int speed){
        return n/speed+(n%speed==0?0:1);
    }
}
