/*
 * @lc app=leetcode id=1044 lang=java
 *
 * [1044] Longest Duplicate Substring
 */

// @lc code=start
class Solution {
    /*
    由于dupsubstring len是单调的(如果len = 8满足dup则len < 8都满足), 所以可以使用binary search
    对于每一个len,判断其是否有dup str时，为防止memory exceed, 求出对应的string hash
    map<long, int> 对应hash -> 当前字符串的起始index
    为了防止collision, 将对应的index用arrayList存储
    利用sliding window遍历时如果找到相同hash, 再判断一次substring是否相等来判断是否是dup substring
    time: O(nlogn)  rolling hash takes O(n)
    space: O(n)
    */
    private static final long p = (1 << 31) - 1;
    private static final long base = 26;
    private int start = -1;
    public String longestDupSubstring(String S) {
        if (S == null || S.length() == 0) return "";
        int left = 2, right = S.length() - 1;   // cannot be one char or entire string
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (find(S, mid)) {
                left = mid + 1;
            }
            else right = mid;
        }
        return start == -1 ? "" : S.substring(start, left + start);
    }

    private boolean find(String s, int len) {
        Map<Long, ArrayList<Integer>> map = new HashMap<>();
        long rm = 1l;
        for (int i = 1; i < len; ++i) rm = (rm * base) % p;     // 最高位的base
        long hash = hashing(s, len);    // first substr hash
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);
        for (int i = 0; i < s.length() - len; ++i) {
            hash = ((hash - rm * s.charAt(i)) % p + p) % p; // ((a-b) % m + m) % m保证结果在[0,m)范围内
            hash = (hash * base + s.charAt(i + len)) % p;
            if (map.containsKey(hash)) {
                for (int j : map.get(hash)) {
                    if (s.substring(i, i + len).equals(s.substring(j, j + len))) {
                        start = i;
                        return true;
                    }
                }
            } else map.put(hash, new ArrayList<>());
            map.get(hash).add(i);
        }
        return false;
    }

    private long hashing(String s, int len) {
        long res = 0;
        for (int i = 0; i < len; ++i) {
            res = (base * res + s.charAt(i)) % p;
        }
        return res;
    }
}
// @lc code=end

