/*
 * @lc app=leetcode id=20 lang=golang
 *
 * [20] Valid Parentheses
 */

// @lc code=start
func isValid(s string) bool {
    if len(s) == 0 {
        return true
    }
    m := map[rune]rune {
        '}' : '{',
        ']' : '[',
        ')' : '(',      // 最后一行也要加逗号
    }
    var stack []rune

    for _, ch := range s {
        if ch == '(' || ch == '[' || ch == '{' {
            stack = append(stack, rune(ch))   // s[i]要转化为rune
        } else if len(stack) == 0 || m[rune(ch)] != stack[len(stack) - 1] {
            return false
        } else {
            stack = stack[:len(stack) - 1]
        }
    }
    return len(stack) == 0
}
// @lc code=end

