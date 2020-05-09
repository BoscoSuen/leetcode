/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
/*
    Binary Search Tree, Node{val, count of dup, count of element less than node val}
    先将数组倒序，然后在倒序插入每个元素的过程中，向右边children遍历则加上该node的count + lessCount, 
    代表其比这些元素都要大，可以得到该位置node比其小的元素数目；如果是向左边，则更新lessCount(+1)
    time: O(nlogn) ~ O(n^2)
    time: O(n unique elements)
*/
class Solution {
    class BSTNode {
        int val;
        int count;
        int lessCount;
        BSTNode left;
        BSTNode right;

        public BSTNode(int val) {
            this.val = val;
            count = 1;
        }

        public int smallerSum() {
            return this.count + this.lessCount;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(0);
        BSTNode root = new BSTNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; --i) {
            res.add(insert(root, nums[i]));
        }
        Collections.reverse(res);
        return res;
    }

    private int insert(BSTNode root, int num) {
        if (num == root.val) {
            root.count++;
            return root.lessCount;
        } else if (num < root.val) {
            ++root.lessCount;
            if (root.left == null) {
                root.left = new BSTNode(num);
                return 0;
            } else {
                return insert(root.left, num);
            }
        } else {
            if (root.right == null) {
                root.right = new BSTNode(num);
                return root.smallerSum();
            } else {
                return insert(root.right, num) + root.smallerSum();
            }
        }
    }
}
// @lc code=end

