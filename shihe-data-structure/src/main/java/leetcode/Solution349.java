package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @ClassName Solution349
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 14:27
 * @Version 1.0
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
           if (set1.contains(nums2[i])){
               list.add(nums2[i]);
               set1.remove(nums2[i]);
           }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
