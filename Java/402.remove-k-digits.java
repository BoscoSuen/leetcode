/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    /*
    monotonic stack: eg 1324
    我们维护一个递增栈，只要发现当前的数字小于栈顶元素的话，就将栈顶元素移除，比如点那个遍历到2的时候，栈里面有1和3，
    此时2小于栈顶元素3，那么将3移除即可。为何一定要移除栈顶元素呢，后面说不定有更大的数字呢？这是因为此时栈顶元素在高位上，
    就算后面的数字再大，也是在低位上，我们只有将高位上的数字尽可能的变小，才能使整个剩下的数字尽可能的小
    利用deque来实现stack便于最后输出
    注意去掉开头的0以及k > 0的corner case(eg: 1111)
    time: O(n)
    space: O(n)
    */
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !dq.isEmpty() && dq.peekLast() > c) {
                dq.pollLast();
                k--;
            }
            dq.offerLast(c);
        }
        while (k-- > 0) dq.pollLast();
    
        while (!dq.isEmpty() && dq.peekFirst() == '0') dq.pollFirst();
        if (dq.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.append(dq.pollFirst());
        return sb.toString();
    }
}
// @lc code=end

