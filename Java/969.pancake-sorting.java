/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */

// @lc code=start
class Solution {
    /*
    选取最大的flip到最前面，然后再翻转整个List到最后面
    time: O(n^2)
    space: O(n)
    */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int max = A.length;
        for (int i = 0; i < A.length; ++i) {
            int pos = find(A, max);
            flip(A, 0, pos);
            flip(A, 0, max - 1);
            res.add(pos + 1);
            res.add(max--);
        }
        return res;
    }
    
    private void flip(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }
    
    private int find(int[] A, int target) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

