# String Hashing

## 多项式Hashing方法:
假设一个字符串的前缀hash值记为h[i]，我们hash时使用的进制数为 base，那么显然  
h[i] = base * hash[i] + s[i]

## Rabin-Karp's Algorithm
滚动哈希：O（n+m）时间内完成字符串匹配；

实现：选取两个合适的互素常数b和h(l<b<p），假设字符串C=c1c2c3...cm，定义哈希函数：H(C)=（c1*b^(m-1)+c2*b^(m-2)+...+cm*b^0）mod p

其中b是基数，相当于把字符串看作b进制数。这样，字符串S=s1s2s3...sn从位置k+1开始长度为m的字符串子串S[k+1...k+m]的哈希值，就可以利用从位置k开始的字符串子串S[k...k+m-1]的哈希值，直接进行如下计算：H(S[k+1...k+m])=（H(S[k...k+m-1]）* b - sk*b^m + s(k+m)） mod p

在实际操作的过程中，为了保证哈希值在[0,p) 之间, 可以做这样的处理:
hash = ((hash - 高位hash) % p + p) % p
因为((a - b) % m + m) % m保证结果在[0,m)之间

于是，只要不断这样计算开始位置右移一位后的字符串子串的哈希值，就可以在O（n）时间内得到所有位置对应的哈希值，从而可以在O（n+m）时间内完成字符串匹配。在实现时，可以用256位作为base计算哈希值，并取p等于2^32 - 1(prime number)，通过自然溢出省去求模运算。

eg: [1044 Longest Duplicate Substring](https://leetcode.com/problems/longest-duplicate-substring/)

Solution:
```java
class Solution {
    private static final long p = (1 << 31) - 1;
    private static final long base = 256;
    private int start = -1;
    public String longestDupSubstring(String S) {
        if (S == null || S.length() == 0) return "";
        int left = 2, right = S.length() - 1;   // cannot be one char
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (find(S, mid)) {
                left = mid + 1;
            }
            else right = mid;
        }
        // also cannot be entire string, which will fail 1 test case
        return start == -1 ? "" : S.substring(start, left + start);
    }

    private boolean find(String s, int len) {
        Map<Long, ArrayList<Integer>> map = new HashMap<>();
        long rm = 1l;
        for (int i = 1; i < len; ++i) rm = (rm * base) % p;
        long hash = hashing(s, len);    // first substr hash
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);
        for (int i = 0; i < s.length() - len; ++i) {
            hash = ((hash - rm * s.charAt(i)) % p + p) % p;
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
```

