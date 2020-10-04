/*
 * @lc app=leetcode id=50 lang=golang
 *
 * [50] Pow(x, n)
 */

// @lc code=start
func myPow(x float64, n int) float64 {
    if n < 0 {
        return 1.0 / pow(x, -n)
    }
    return pow(x, n)
}

func pow(x float64, n int) float64 {
    if n == 0 {
        return 1
    }
    y := pow(x, n / 2)
    if n % 2 == 0 {
        return y * y
    }
    return y * y * x
}
// @lc code=end

