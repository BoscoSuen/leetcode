/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    讲字符串转为char-count的key
    aabbcc -> a2b2c2,然后放进map中
    time: Time Complexity: O(NK)
    where N is the length of strs, and K is the maximum length of a string in strs. 
    space: O(NK)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = new char[26];
            for (char c : str.toCharArray()) {
                chs[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; ++i) {
                if (chs[i] != 0) {
                    sb.append(i + 'a').append(chs[i]);
                }
            }
            String cur = sb.toString();
            List<String> curList = map.getOrDefault(cur, new ArrayList<>());
            curList.add(str);
            map.put(cur, curList);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

