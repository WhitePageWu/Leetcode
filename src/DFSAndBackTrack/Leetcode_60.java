package DFSAndBackTrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_60 {
    /**速度慢
    int k;
    String ret ="";
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder("");
        this.k=k;
        boolean[] used = new boolean[n];
        dfs(n,1,sb,used);
        return ret;
    }
    private boolean dfs(int n,int depth,StringBuilder sb,boolean[] used){
        if (k==1&&sb.length()==n){
            ret=sb.toString();
            return true;
        }
        if (sb.length()==n){
            --k;
            return false;
        }
        for (int i=1;i<=n;i++){
            if (!used[i-1]){
                sb.append(i);
                used[i-1]=true;
                if(dfs(n,i+1,sb,used)){
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
                used[i-1]=false;
            }
        }
        return false;
    }
     */

    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        new Leetcode_60().getPermutation(4,9);
    }
}
