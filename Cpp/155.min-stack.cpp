/*
 * @lc app=leetcode id=155 lang=cpp
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> data;
    stack<int> min;
    MinStack() {
        
    }
    
    void push(int x) {
        data.push(x);
        if (min.empty() || x <= min.top()) min.push(x);
    }
    
    void pop() {
        int cur = data.top();
        data.pop();
        if (!min.empty() && cur == min.top()) min.pop();
    }
    
    int top() {
        return data.top();
    }
    
    int getMin() {
        return min.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end

