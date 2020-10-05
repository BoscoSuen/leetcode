/*
 * @lc app=leetcode id=3 lang=golang
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
func lengthOfLongestSubstring(s string) int {
    // location[s[i]] = j : 上一次出现位置是j
    location := [256]int{}
    for i:= range location {
        location[i] = -1
    }
    maxLen, left := 0, 0
    for i := 0; i < len(s); i++ {
        if location[s[i]] >= left {
            left = location[s[i]] + 1
        } else if i - left + 1 > maxLen {
            maxLen = i - left + 1
        }
        location[s[i]] = i
    }
    return maxLen
}
// @lc code=end

