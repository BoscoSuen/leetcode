# Manacher's Algorithm
Example Question: [leetcode 5.Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

- 思路  
维护一个跟原串 str 一样长的数组 lens。lens[i] 表示以 str[i] 为中点的回串其中一边的长度。
- 算法  
首先我们解决下奇数和偶数的问题，在每个字符间插入"#"，并且为了使得扩展的过程中，到边界后自动结束，在两端分别插入 "^" 和 "$"，两个不可能在字符串中出现的字符，这样中心扩展的时候，判断两端字符是否相等的时候，如果到了边界就一定会不相等，从而出了循环。经过处理，字符串的长度永远都是奇数了。
![](./files/manacher_1.jpg)
