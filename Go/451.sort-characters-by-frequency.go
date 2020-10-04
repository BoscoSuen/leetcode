/*
 * @lc app=leetcode id=451 lang=golang
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
func frequencySort(s string) string {
    freq := make(map[rune]int)
    maxFreq := 0
    for _, ch := range s {
        freq[ch]++
        if freq[ch] > maxFreq {
            maxFreq = freq[ch]
        }
    }
    freqMap := make(map[int][]rune)
    // k: ch, v: freq
    for k, v := range freq {
        freqMap[v] = append(freqMap[v], k)
    }
    var res string
    for maxFreq > 0 {
        if chars, ok := freqMap[maxFreq]; ok {
            for _, ch := range chars {
                for i := maxFreq - 1; i >= 0; i--  {
                    res += string(ch)
                }
            }
        }
        maxFreq--
    }
    return res
}
// @lc code=end

