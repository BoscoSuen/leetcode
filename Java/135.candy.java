/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start

/*
straight:从左向右，从右向左遍历两遍数组
第一遍从左向右遍历，如果右边的小盆友的等级高，等加一个糖果，这样保证了一个方向上高等级的糖果多。然后再从右向左遍历一遍，
如果相邻两个左边的等级高，而左边的糖果又少的话，则左边糖果数为右边糖果数加一
优化空间复杂度：
首先我们给第一个同学一个糖果，那么对于接下来的一个同学就有三种情况：

- 1. 接下来的同学的rating等于前一个同学，那么给接下来的同学一个糖果就行。
- 2. 接下来的同学的rating大于前一个同学，那么给接下来的同学的糖果数要比前一个同学糖果数加1。
- 3.接下来的同学的rating小于前一个同学，那么我们此时不知道应该给这个同学多少个糖果，需要看后面的情况。

对于第三种情况，我们不确定要给几个，因为要是只给1个的话，那么有可能接下来还有rating更小的同学，总不能一个都不给吧。也不能直接给前一个同学的糖果数减1，有可能给多了，因为如果后面再没人了的话，其实只要给一个就行了。还有就是，如果后面好几个rating越来越小的同学，那么前一个同学的糖果数可能还得追加，以保证最后面的同学至少能有1个糖果。来一个例子吧，四个同学，他们的rating如下：
1 3 2 1
先给第一个rating为1的同学一个糖果，然后从第二个同学开始遍历，第二个同学rating为3，比1大，所以多给一个糖果，第二个同学得到两个糖果。
下面第三个同学，他的rating为2，比前一个同学的rating小，如果我们此时给1个糖果的话
，那么rating更小的第四个同学就得不到糖果了，所以我们要给第四个同学1个糖果，而给第
三个同学2个糖果，此时要给第二个同学追加1个糖果，使其能够比第三个同学的糖果数多至少
一个。那么我们就需要统计出多有个连着的同学的rating变小，用变量cnt来记录，找出了最
后一个减小的同学，那么就可以往前推，每往前一个加一个糖果，这就是个等差数列，我们可以
直接利用求和公式算出这些rating减小的同学的糖果之和。然后我们还要看第一个开始减小的
同学的前一个同学需不需要追加糖果，只要比较cnt和pre的大小，pre是之前同学得到的最大
糖果数，二者做差加1就是需要追加的糖果数，加到结果res中即可
eg: 3 2 1 4
一开始给3发一个糖果(prev = 1)，遍历到4的时候，countDown(cnt) = 2, 结算 2 和 1的糖果, (cnt + 1) * cnt /2
然后2得到了cnt的糖果,3要比2多,3补上cnt - prev + 1

time: O(n)
space: O(1)
*/

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int res = 1;
        int prev = 1;
        int countDown = 0;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] < ratings[i - 1]) {
                ++countDown;
            } else {
                // i-1位的得到一个糖果,之前的为prev -> 1的等差数列
                if (countDown > 0) {
                    res += (countDown + 1) * countDown / 2;
                    if (countDown >= prev) res += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                // countDown = 0
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;  // 3 2 1 1 or 3 2 1 2
                res += prev;
            }
        }   
        if (countDown > 0) {
            res += (countDown + 1) * countDown / 2;
            if (countDown >= prev) res += countDown - prev + 1;
        }
        return res;
    }
}
// @lc code=end

