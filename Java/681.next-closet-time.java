/*
 * @lc app=leetcode id=681 lang=java
 *
 * [681] Next Closest Time
 */

// @lc code=start
class Solution {
    /*
    利用TreeSet来将所有数字进行排序，然后从最小的数字开始找符合条件的数
    findNext找到当前位的下一个值，如果没有返回set中的最小数，当作前一位进位
    eg: 23:19 -> 23:21
    如果当前日没有就找下一天的最小的，也可以返回最小值
    */
    public String nextClosestTime(String time) {
        Character[] digits = new Character[]{time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(digits));
        char[] res = time.toCharArray();
        res[2] = ':';
        
        res[4] = findNext(set, time.charAt(4), '9');
        if (res[4] > time.charAt(4)) return new String(res);
        
        res[3] = findNext(set, time.charAt(3), '5');
        if (res[3] > time.charAt(3)) return new String(res);
        
        res[1] = findNext(set, time.charAt(1), time.charAt(0) == '1' ? '9' : '3');
        if (res[1] > time.charAt(1)) return new String(res);
        
        res[0] = findNext(set, time.charAt(0), '2');
        return new String(res);
    }
    
    private char findNext(TreeSet<Character> set, char cur, char limit) {
        Character next = set.higher(cur);  // ceiling是大于等于
        if (next == null || next > limit) {
            return set.first();
        } else {
            return next;
        }
    }
}
// @lc code=end

