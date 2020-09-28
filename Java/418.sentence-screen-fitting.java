/*
 * @lc app=leetcode id=418 lang=java
 *
 * [418] Sentence Screen Fitting
 */

// @lc code=start
class Solution {
    /*
    一行一行的加, 如果碰到当前位置不满足末行条件，将count退格代表一部分字符不能加在这一行得加在下一行
    a _ b  c  d _ e _
    0 1 0 -1 -2 1 0 1
    第一次加count = 6, 下一行开始的是e, 所以之前所有的都可以放进这一行(如果是空格就补一个空格)
    第二次count = 12, 下一行开始的是d, 所以要退两格用空格补充，下一行开头的是bcd count = 12 - 2 = 10
    第三次count = 16, 下一行开始是a, 满足
    time: O(len + cols)
    sapce: O(len)
    */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }
}
// @lc code=end

