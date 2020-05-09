/*
 * @lc app=leetcode id=862 lang=cpp
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
public:
    int shortestSubarray(vector<int>& A, int K) {
        vector<int> prefix(A.size() + 1, 0);
        for (int i = 0; i < A.size(); ++i) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        deque<int> dq;
        int res = INT_MAX;
        for (int i = 0; i <= A.size(); ++i) {
            while (!dq.empty() && prefix[i] - prefix[dq.front()] >= K) {
                res = min(res, i - dq.front());
                dq.pop_front();
            }
            while (!dq.empty() && prefix[i] <= prefix[dq.back()]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }
        return res == INT_MAX ? -1 : res;
    }
};
// @lc code=end

