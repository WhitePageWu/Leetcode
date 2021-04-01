package BackTrack;

public class Leetcode_494 {
    int res =0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null||nums.length==0){return -1;}
        dfs(nums,S,0);
        System.out.println(res);
        return res;
    }
    public void dfs(int[] nums,int S,int depth){
        if (depth==nums.length&&S==0){
            res++;
        }
        if (depth==nums.length){
            return;
        }
        S+=nums[depth];
        dfs(nums,S,depth+1);
        S=S-nums[depth];
        S-=nums[depth];
        dfs(nums,S,depth+1);
        S=S+nums[depth];
    }

    public static void main(String[] args) {
        new Leetcode_494().findTargetSumWays(new int[]{1,1,1,1,1},3);
    }
}
