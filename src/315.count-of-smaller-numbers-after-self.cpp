/*
 * @lc app=leetcode id=315 lang=cpp
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
/*
https://paper.dropbox.com/doc/LC315-Count-of-Smaller-Numbers-After-Self--AyHoWxU6VIidxlBz~LZ_txJ6Ag-0ToMbjV1oQmmYKjHm4sFf
对于找一个数组有多少个元素比某个位置的元素小，可以先将数组倒序排列，然后遍历过程中找多少个元素比之前的大。
将数组排序，然后找到对应元素是第几小的rank(rank从1开始)，然后用map记录对应rank元素的出现次数，然后将0 → rank - 1中所有的频率相加(Prefix Sum)即得到比该rank位置小的元素
对于这种prefix sum的操作，可以利用Fenwick Tree来实现，每次遍历一个元素进行Query(rank - 1)的操作，之后在rank位置更新其频率(+1) 
time: O(nlogn)
space: O(unique nums)
*/
class BITree {
public:
    BITree(int n) : prefixSum(n + 1, 0) {}
    int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += prefixSum[i];
            i -= i & (-i);
        }
        return sum;
    }

    void update(int i, int delta) {
        while (i < prefixSum.size()) {
            prefixSum[i] += delta;
            i += i & (-i);
        }
    }
protected:
    vector<int> prefixSum;
};
class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> res;
        set<int> sorted(nums.begin(), nums.end());
        unordered_map<int, int> rankMap;
        int rank = 1;
        for (int num : sorted) {
            rankMap[num] = rank++;
        }
        BITree bitree(rankMap.size());
        for (int i = nums.size() - 1; i >= 0; --i){
            int query = bitree.query(rankMap[nums[i]] - 1);
            res.push_back(query);
            bitree.update(rankMap[nums[i]], 1);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
// @lc code=end

