/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 */

// @lc code=start

/*
先dfs找到所有的解，再一个一个pop
time: O(C(n, k))
space: O(C(n, k))
*/
class CombinationIterator {
    Queue<String> q;
    public CombinationIterator(String characters, int combinationLength) {
        q = new LinkedList<>();
        combination(q, characters, combinationLength, 0, new StringBuilder());
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
    
    private void combination(Queue<String> q, String str, int length, int pos, StringBuilder sb) {
        if (sb.length() == length) {
            q.offer(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = pos; i < str.length(); ++i) {
            sb.append(str.charAt(i));
            combination(q, str, length, i + 1, sb);
            sb.setLength(len);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

