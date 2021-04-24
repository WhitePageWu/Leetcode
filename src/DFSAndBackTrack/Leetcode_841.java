package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] res = new boolean[rooms.size()];
        res[0]=true;
        dfs(rooms,res,0);
        for (boolean b:res){
            if (b==false){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] res,int roomId){
        if (roomId!=0&&res[roomId]==true){
            return;
        }
        res[roomId]=true;
        List<Integer> keys = rooms.get(roomId);
        for (int i=0;i<keys.size();i++){
            dfs(rooms,res,keys.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list1.add(2);
        List<Integer> list3 = new ArrayList<>();
        list1.add(3);
        List<Integer> list4 = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        new Leetcode_841().canVisitAllRooms(list);
    }
}
