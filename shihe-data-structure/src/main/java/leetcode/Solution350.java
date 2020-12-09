package leetcode;

import java.util.*;

/**
 * @ClassName Solution349
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 14:27
 * @Version 1.0
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i],map2.get(nums2[i]) + 1);
            }else{
                map2.put(nums2[i], 1);
            }
        }
        ArrayList<Integer> keys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if(map2.containsKey(key)){
                Integer v1 = map.get(key);
                Integer v2 = map2.get(key);
                if (v1 >= v2){
                    for (int i = 0; i < v2; i++) {
                        keys.add(key);
                    }
                } else {
                    for (int i = 0; i < v1; i++) {
                        keys.add(key);
                    }
                }
            }
        }

        int[] res = new int[keys.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = keys.get(i);
        }
        return res;*/
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)){
                list.add(i);
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,9,5};
        int[] b = {9,4,9,8,4};
        Solution350 s = new Solution350();
        int[] intersect = s.intersect(a, b);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
