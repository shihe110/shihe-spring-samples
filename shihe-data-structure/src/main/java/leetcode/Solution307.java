package leetcode;

/**
 * @ClassName Solution349
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 14:27
 * @Version 1.0
 */
public class Solution307 {
    public int firstUniqChar(String s){
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution307 solution307 = new Solution307();
        String s = "lleet";
        int leet = solution307.firstUniqChar(s);
        System.out.println(s.charAt(leet));
    }
}
