/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {
    /*
    Segment Tree
    time: O(n) for build O(h) or O(logn) for update/query
    space: O(n)
    */
    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    SegmentTreeNode root;
    
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
    
    private int query(SegmentTreeNode root, int start, int end) {
        if (root.start == root.end) {
            return root.sum;
        }
        int mid = (root.end - root.start) / 2 + root.start;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
    
    private SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
        } else {
            int mid = (end - start) / 2 + start;
            root.left = build(nums, start, mid);
            root.right = build(nums, mid + 1, end);
            root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
        }
        return root;
    }
    
    private void update(SegmentTreeNode root, int pos, int val) {
        if (root == null || pos < root.start || pos > root.end) {
            return;
        }
        if (root.start == root.end && root.start == pos) {
            root.sum = val;
        } else {
            int mid = (root.end - root.start) / 2 + root.start;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

