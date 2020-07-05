/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start

/*
思路同lc 460. LFU cache
比LFU cache简单的是，此题的freq是连续的(freq增加不会改变低freq的stack结构)
对于每一个freq, 用一个stack来track当前freq的值
eg: 5 7 5 7 4 5push进stack中
freq 1: 5 7 4
freq 2: 5 7
freq 3: 5
pop的时候从freq 3开始依次pop就行
为了判断新来的数stack中是不是存在，利用一个hashMap来存储<num, freq>的关系
time: push & pop O(1)
space: O(n)
*/
class FreqStack {
    List<Stack<Integer>> freqs;
    Map<Integer, Integer> map;
    public FreqStack() {
        map = new HashMap<>();
        freqs = new ArrayList<>();
    }
    
    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        int freq = map.get(x);
        if (freqs.size() < freq) freqs.add(new Stack<>());
        freqs.get(freq - 1).push(x);
    }
    
    public int pop() {
        if (freqs.isEmpty()) return -1;
        int num = freqs.get(freqs.size() - 1).pop();
        if (freqs.get(freqs.size() - 1).isEmpty()) {
            freqs.remove(freqs.size() - 1);
        }
        map.put(num, map.get(num) - 1);
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

