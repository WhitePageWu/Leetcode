package DFSAndBackTrack;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_93 {
    static final int SEG_COUNT = 4;
    List<String> res = new LinkedList<>();
    int[] segments=new int[SEG_COUNT];
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len<4||len>12){
            return res;
        }
        dfs(s,0,0);
        return res;
    }
    private void dfs(String s, int segId, int segStart){
        if (segId==SEG_COUNT){
            if (segStart==s.length()){
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<4;i++){
                    sb.append(segments[i]);
                    if (i!=3){
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }
        int c =s.charAt(segStart)-'0';
        if (c==0){
            segments[segId]=c;
            dfs(s,segId+1,segStart+1);
        }
        int addr=0;
        for (int i=segStart;i<s.length();i++){
            addr=addr*10+(s.charAt(i)-'0');
            if (addr>0&&addr<=255){
                segments[segId]=addr;
                dfs(s,segId+1,i+1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Leetcode_93().restoreIpAddresses("010010");
    }
}
