/*
 * @lc app=leetcode id=949 lang=java
 *
 * [949] Largest Time for Given Digits
 */

// @lc code=start
class Solution {
    /*
    permutation列举所有可能，再一一利用string compareTo比较
    time: O(1)
    space: O(1)
    */
    public String largestTimeFromDigits(int[] A) {
        List<String> list = permutation(A);
        String res = "";
        for (String s : list) {
            String HH = s.substring(0, 2);
            String MM = s.substring(2, 4);
            if (Integer.parseInt(HH) < 24 && Integer.parseInt(MM) < 60 && (HH + ":" + MM).compareTo(res) > 0) {
                res = HH + ":" + MM;
            }
        }
        return res;
    }
    
    private List<String> permutation(int[] A) {
        List<String> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        helper(res, A, visited, 0, new StringBuilder());
        return res;
    }
    
    private void helper(List<String> res, int[] A, Set<Integer> visited, int pos, StringBuilder sb) {
        if (pos == A.length) {
            res.add(sb.toString());
        }
        int len = sb.length();
        for (int i = 0; i < A.length; ++i) {
            if (visited.add(i)) {
                sb.append(A[i]);
                helper(res, A, visited, pos + 1, sb);
                visited.remove(i);
                sb.setLength(len);
            }
        }
    }
}
// @lc code=end

