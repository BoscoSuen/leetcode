/*
 * @lc app=leetcode id=753 lang=java
 *
 * [753] Cracking the Safe
 */

// @lc code=start
class Solution {
    /*
    数据规模小，从全是0的初始密码开始dfs
    time: O(k^n) 如果不考虑取substring
    time: O(k^n)
    */
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            sb.append("0");
        }
        visited.add(sb.toString());
        dfs(sb, visited, n, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, Set<String> visited, int n, int k) {
        if (visited.size() == Math.pow(k, n)) return true;
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; ++i) {
            String next = prev + i;
            if (visited.add(next)) {
                sb.append(i);
                if (dfs(sb, visited, n, k)) {
                    return true;
                } else {
                    visited.remove(next);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return false;
    }
}
// @lc code=end

