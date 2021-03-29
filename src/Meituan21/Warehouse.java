package Meituan21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Warehouse {
   static Map<Integer,Integer> map = new HashMap<>();
    public static void separate(int[] weight,int p){
        int size = map.size();
        int max =0;
        int del=-1;
        for (int i =0;i<size;i++){
            int end = map.getOrDefault(i,-1);
            if (end==-1){
                break;
            }
            if (i<p&&p<end){
                map.put(i,p-1);
                map.put(p+1,end);
            }
        }
        for (int j = 0;j<map.size();j++){
            int end = map.getOrDefault(j,-1);
            if (end!=-1){
                int temp = 0;
                for (int k=j;k<end;k++){
                    temp+=weight[k];
                }
                max=max<temp?temp:max;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        for(int i=0;i<n;i++){
            weight[i]=in.nextInt();
        }
        int[] point=new int[n];
        for(int i=0;i<n;i++){
            point[i]=in.nextInt();
            map.put(i,i);
        }
        for (int i=0;i<n;i++){
            separate(weight,point[i]);
        }
    }
}
