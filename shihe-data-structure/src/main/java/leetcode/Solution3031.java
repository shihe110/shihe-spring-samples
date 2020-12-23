package leetcode;

import segment.SegmentTree;

/**
 * @ClassName Solution349
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 14:27
 * @Version 1.0
 */
public class Solution3031 {
    private int[] sum;

    public Solution3031(int[] nums){
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i -1] + nums[i -1];
        }
    }

    public int sumRange(int i, int j){
       return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, -1, 5};
        Solution3031 solution303 = new Solution3031(nums);
        int i = solution303.sumRange(0, 3);
        System.out.println(i);
    }
}
