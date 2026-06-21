package leetcode_may;

// Leetcode Problem 1833. Maximum Ice Cream Bars
import java.util.*;
class MaxIceCreamBar {
    public int maxIceCream(int[] costs, int coins) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(a.getKey(),b.getKey()));
        for(int ele : costs){
            hm.put(ele,hm.getOrDefault(ele,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            pq.offer(entry);
        }
        int cnt = 0;
        while(!pq.isEmpty() && coins > 0){
            Map.Entry<Integer,Integer> entry = pq.poll();
            if(coins >= entry.getKey()){
                int iceCnt = Math.min(coins / entry.getKey(),entry.getValue());
                coins -= iceCnt * entry.getKey();
                cnt += iceCnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MaxIceCreamBar obj = new MaxIceCreamBar();
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(obj.maxIceCream(costs,coins));
    }
}