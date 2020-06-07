/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    /*
    从高到低排序(相同高度按照index排序)
    eg -> [7,0] [7,1] [6,1] [5, 0] [5,2] [4,4]
    从大到小插入数字到index对应位置
    -> [7,0] [7,1] insert at 1
    -> [7,0] [6,1] [7,1]
    time: O(nlogn)
    space: O(n)
    */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] arr : people) {
            res.add(arr[1], arr);
        }
        return res.toArray(new int[people.length][2]);
    }
}
// @lc code=end

