package leetcode;

import queue.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @ClassName Solution347
 * @Description TODO
 * @Author admin
 * @Date 2020-12-15 17:42
 * @Version 1.0
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k){
        // 计算数组中不同元素出现的频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
               map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        // 使用优先队列实现取前i个元素
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (pq.getSize() < k){
                pq.enqueue(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }
    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        Solution347 solution347 = new Solution347();
        List<Integer> integers = solution347.topKFrequent(nums, k);
        System.out.println(integers);
    }
}
