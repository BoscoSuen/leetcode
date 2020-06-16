/*
 * @lc app=leetcode id=468 lang=java
 *
 * [468] Validate IP Address
 */

// @lc code=start
class Solution {
    /*
    注意字符串的分割(转义字符&末尾还有分隔符)
    分割后每个token的输入形式不正确要抛出 "NumberFormatException"
    排除带有负号的数字
    time: O(n) for split
    space: O(n)
    */
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) return "IPv4";
        else if (isValidIPv6(IP)) return "IPv6";
        else return "Neither";
    }
    
    private boolean isValidIPv4(String IP) {
        if (IP.length() < 7 || IP.length() > 15) return false;
        String[] tokens = IP.split("\\.", -1);  // 最后是分隔符会继续切分
        if (tokens.length != 4) return false;
        for (String token : tokens) {
            if (!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    
    private boolean isValidIPv4Token(String token) {
        if ((token.startsWith("0") && token.length() > 1) || token.length() == 0) return false;
        try {
            return token.charAt(0) != '-' && Integer.parseInt(token) >= 0 && Integer.parseInt(token) <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isValidIPv6(String IP) {
        String[] tokens = IP.split(":", -1);    // 最后是分隔符会继续切分
        if (tokens.length != 8) return false;
        for (String token : tokens) {
            if (!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    
    private boolean isValidIPv6Token(String token) {
        if (token.length() == 0 || token.length() > 4) return false;
        try {
            return !token.startsWith("-") && Integer.parseInt(token, 16) >= 0; 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
// @lc code=end

