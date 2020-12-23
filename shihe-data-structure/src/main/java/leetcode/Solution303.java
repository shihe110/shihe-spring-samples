package leetcode;

import segment.SegmentTree;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @ClassName Solution349
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 14:27
 * @Version 1.0
 */
public class Solution303 {
    private SegmentTree<Integer> segTree;

    public Solution303(int[] nums){
        if (nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data,(a, b)->a + b);
        }
    }

    public int sumRange(int i, int j){
        if (segTree == null)
            throw new IllegalArgumentException("SegmentTree is null");
        return segTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, -1, 5};
        Solution303 solution303 = new Solution303(nums);
        int i = solution303.sumRange(0, 3);
        System.out.println(i);
    }
}
