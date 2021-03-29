package LinkList;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_offer_06 {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        while (head!=null){
            list.add(0,head.val);
            head=head.next;
        }
        int[] ret = new int[list.size()];
        for (int i=0;i<ret.length;i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
}
