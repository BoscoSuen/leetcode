# Topic with starred leetcode problems

## Array
| Problem   | Solution   
:-         |   :-: 
[48. Rotate Image](https://leetcode.com/problems/rotate-image/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/48.rotate-image.java)
[54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | [注意半边之后要重新判断](https://github.com/Yukinichi/leetcode/blob/master/Java/54.spiral-matrix.java)
[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [Binary Search(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/287.find-the-duplicate-number.cpp) \| [Cycle Detection(Java)](https://github.com/Yukinichi/leetcode/blob/master/Java/287.find-the-duplicate-number.java)

## Binary Search    
| Problem   | Solution   
:-         |   :-:  
[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)          | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/33.search-in-rotated-sorted-array.java)  
[81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) | [多考虑重复的情况](https://github.com/Yukinichi/leetcode/blob/master/Java/81.search-in-rotated-sorted-array-ii.java)
[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/34.find-first-and-last-position-of-element-in-sorted-array.java)
[1044. Longest Duplicate Substring](https://leetcode.com/problems/longest-duplicate-substring/) | [String Hashing(Rabin Karp's Algorithm) + Binary Search](https://github.com/Yukinichi/leetcode/blob/master/Java/1044.longest-duplicate-substring.java)
[1268. Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | [lower_bound&upper_bound, use emplace_back](https://github.com/Yukinichi/leetcode/blob/master/Cpp/1268.search-suggestions-system.cpp)

## Binary Search Tree(BST)   
| Problem   | Solution   
:-         |   :-: 
[162. Find Peak Element](https://leetcode.com/problems/find-peak-element/) | [binary search找peak](https://github.com/Yukinichi/leetcode/blob/master/Java/162.find-peak-element.java)
[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | [Java Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/315.count-of-smaller-numbers-after-self.java) 
[1008. Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | [递归O(n)解](https://github.com/Yukinichi/leetcode/blob/master/Java/1008.construct-binary-search-tree-from-preorder-traversal.java)

## Bit Manipulation  
| Problem   | Solution   
:-         |   :-: 
[137. Single Number II](https://leetcode.com/problems/single-number-ii/) | [解决n个重复数字找不同问题](https://github.com/Yukinichi/leetcode/blob/master/Java/137.single-number-ii.java)
[260. Single Number III](https://leetcode.com/problems/single-number-iii/) | [xor + lowbit](https://github.com/Yukinichi/leetcode/blob/master/Java/260.single-number-iii.java)
[1239. Maximum Length of a Concatenated String with Unique Characters](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/) | [bit and找intersection优化combination问题](https://github.com/Yukinichi/leetcode/blob/master/Java/1239.maximum-length-of-a-concatenated-string-with-unique-characters.java) \| [C++ bitset](https://github.com/Yukinichi/leetcode/blob/master/Cpp/1239.maximum-length-of-a-concatenated-string-with-unique-characters.cpp)

## Dynamic Programming
| Problem   | Solution   
:-         |   :-: 
[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [Manacher's Algorithm](https://github.com/Yukinichi/leetcode/blob/master/Note/Manacher_Algorithm.md)
[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [字符串匹配类dp](https://github.com/Yukinichi/leetcode/blob/master/Java/10.regular-expression-matching.java)
[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [记录当前结尾的subarray](https://github.com/Yukinichi/leetcode/blob/master/Java/152.maximum-product-subarray.java)
[42. trapping rain water](https://leetcode.com/problems/trapping-rain-water/) | [DP优化为two pointer](https://github.com/Yukinichi/leetcode/blob/master/Java/42.trapping-rain-water.java)
[72. Edit Distance](https://leetcode.com/problems/edit-distance/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/72.edit-distance.java)
[96. Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/96.unique-binary-search-trees.java)
[188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | [局部最优vs全局最优](https://github.com/Yukinichi/leetcode/blob/master/Java/188.best-time-to-buy-and-sell-stock-iv.java)
[300. Longest Increasing Subsequence(LIS)](https://leetcode.com/problems/longest-increasing-subsequence/) | [DP + binary search(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/300.longest-increasing-subsequence.cpp)
[368. Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/) | [LIS问题变种](https://github.com/Yukinichi/leetcode/blob/master/Java/368.largest-divisible-subset.java)
[354. Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)|[Binary Search+DP(思路同lc300)](https://github.com/Yukinichi/leetcode/blob/master/Java/354.russian-doll-envelopes.java)
[518. Coin Change 2](https://leetcode.com/problems/coin-change-2/) | [Unbounded Knapsack Problem(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/518.coin-change-2.cpp) \| [优化为1维数组(Java)](https://github.com/Yukinichi/leetcode/blob/master/Java/518.coin-change-2.java)
[688. Knight Probability in Chessboard](https://leetcode.com/problems/knight-probability-in-chessboard/) | [dfs + memo算概率](https://github.com/Yukinichi/leetcode/blob/master/Java/688.knight-probability-in-chessboard.java)
[741. Cherry Pickup](https://leetcode.com/problems/cherry-pickup/) | [转化为两个同时进行的子问题+ dfs + memo](https://github.com/Yukinichi/leetcode/blob/master/Java/741.cherry-pickup.java)
[1320. Minimum Distance to Type a Word Using Two Fingers](https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/) | [dfs+memorization](https://github.com/Yukinichi/leetcode/blob/master/Java/1320.minimum-distance-to-type-a-word-using-two-fingers.java)
[221. Maximal Square](https://leetcode.com/problems/maximal-square/) | [从对应边长找状态转移方程](https://github.com/Yukinichi/leetcode/blob/master/Java/221.maximal-square.java)
[1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | [LCS问题](https://github.com/Yukinichi/leetcode/blob/master/Java/1143.longest-common-subsequence.java)
[1312. Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | [区间dp(小区间->大区间)](https://github.com/Yukinichi/leetcode/blob/master/Java/1312.minimum-insertion-steps-to-make-a-string-palindrome.java)


## Fenwick Tree / Binary Indexed Tree(BIT)
| Problem   | Solution   
:-         |   :-: 
[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | [C++ Solution](https://github.com/Yukinichi/leetcode/blob/master/Cpp/315.count-of-smaller-numbers-after-self.cpp)

## Graph
| Problem   | Solution   
:-         |   :-: 
[863. All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | [由tree建无向图BFS](https://github.com/Yukinichi/leetcode/blob/master/Java/863.all-nodes-distance-k-in-binary-tree.java)
[207. Course Schedule](https://leetcode.com/problems/course-schedule/) | [Topological Sort](https://github.com/Yukinichi/leetcode/blob/master/Java/207.course-schedule.java)
[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [Topological Sort](https://github.com/Yukinichi/leetcode/blob/master/Java/210.course-schedule-ii.java)
[332. Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) | [Eularian Path & Hierholzer’s Algorithm](https://github.com/Yukinichi/leetcode/blob/master/Java/332.reconstruct-itinerary.java)
[886 Possible Bipartition](https://leetcode.com/problems/possible-bipartition/) | [Graph Coloring](https://github.com/Yukinichi/leetcode/blob/master/Java/886.possible-bipartition.java)
[934.Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | [Graph coloring: dfs + bfs](https://github.com/Yukinichi/leetcode/blob/master/Java/934.shortest-bridge.java)
[743. Network Delay Time](https://leetcode.com/problems/network-delay-time/) | [Dijkstra](https://github.com/Yukinichi/leetcode/blob/master/Java/743.network-delay-time.java)
[787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | [Dijkstra](https://github.com/Yukinichi/leetcode/blob/master/Java/787.cheapest-flights-within-k-stops.java)
[1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | [Dijkstra]()
[1192. Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | [todo]()

## Greedy
| Problem   | Solution   
:-         |   :-: 
[55. Jump Game](https://leetcode.com/problems/jump-game/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/55.jump-game.java)
[45. Jump Game II](https://leetcode.com/problems/jump-game-ii/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/45.jump-game-ii.java)
[135. Candy](https://leetcode.com/problems/candy/) | [一次遍历 spaceO(1)解](https://github.com/Yukinichi/leetcode/blob/master/Java/135.candy.java)
[763. Partition Labels](https://leetcode.com/problems/partition-labels/) | [greedy + two pointer](https://github.com/Yukinichi/leetcode/blob/master/Java/763.partition-labels.java)
[757. Set Intersection Size At Least Two](https://leetcode.com/problems/set-intersection-size-at-least-two/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/757.set-intersection-size-at-least-two.java)
[1029. Two City Scheduling](https://leetcode.com/problems/two-city-scheduling/) | [Greedy](https://github.com/Yukinichi/leetcode/blob/master/Java/1029.two-city-scheduling.java) \| [DP](https://github.com/Yukinichi/leetcode/blob/master/Cpp/1029.two-city-scheduling.cpp)

## Iterator
| Problem   | Solution   
:-         |   :-: 
[341. Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/) | [List Iterator](https://github.com/Yukinichi/leetcode/blob/master/Java/341.flatten-nested-list-iterator.java)

## Linked-List
| Problem   | Solution   
:-         |   :-: 
[148. Sort List](https://leetcode.com/problems/sort-list/) | [merge sort](https://github.com/Yukinichi/leetcode/blob/master/Cpp/148.sort-list.cpp) \| [space O(1) Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/148.sort-list.java)

## Math
| Problem   | Solution   
:-         |   :-: 
[43. Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/43.multiply-strings.java)
[50. Pow(x, n)](https://leetcode.com/problems/powx-n/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/50.pow-x-n.java)
[837. New 21 Game](https://leetcode.com/problems/new-21-game/) | [算累加条件概率](https://github.com/Yukinichi/leetcode/blob/master/Java/837.new-21-game.java)


## Monotonic Queue
| Problem   | Solution   
:-         |   :-: 
[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Monotinic Stack](https://github.com/Yukinichi/leetcode/blob/master/Java/84.largest-rectangle-in-histogram.java)
[85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [思路同84](https://github.com/Yukinichi/leetcode/blob/master/Java/85.maximal-rectangle.java)
[402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [Monotonic Stack](https://github.com/Yukinichi/leetcode/blob/master/Java/402.remove-k-digits.java)
[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Monotic Queue + sliding window](https://github.com/Yukinichi/leetcode/blob/master/Java/239.sliding-window-maximum.java)
[862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | [Monotonic Queue + Sliding Window](https://github.com/Yukinichi/leetcode/blob/master/Java/862.shortest-subarray-with-sum-at-least-k.java)

## OOD 
| Problem   | Solution   
:-         |   :-: 
[146. LRU Cache](https://leetcode.com/problems/lru-cache/) | [HashMap + Doubly Linked List](https://github.com/Yukinichi/leetcode/blob/master/Java/146.lru-cache.java) \| [Java LinkedHashMap](https://github.com/Yukinichi/leetcode/blob/master/Java/146.lru-cache-solution2.java)
[460. LFU Cache](https://leetcode.com/problems/lfu-cache/) | [HashMap + TreeSet(Ologn)](https://github.com/Yukinichi/leetcode/blob/master/Java/460.lfu-cache.java) \| [HashMap + DList(O(1))](https://github.com/Yukinichi/leetcode/blob/master/Java/460.lfu-cache-2.java)
[642. Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system/) | [Trie + PriorityQueue](https://github.com/Yukinichi/leetcode/blob/master/Java/642.design-search-autocomplete-system.java)
[895. Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/) | [思路同LFU Cache](https://github.com/Yukinichi/leetcode/blob/master/Java/895.maximum-frequency-stack.java)
[705. Design HashSet](https://leetcode.com/problems/design-hashset/) | [linkedlist handle hashing collision](https://github.com/Yukinichi/leetcode/blob/master/Java/705.design-hash-set.java)
[706. Design HashMap](https://leetcode.com/problems/design-hashmap/) | [linkedlist handle hashing collision](https://github.com/Yukinichi/leetcode/blob/master/Java/706.design-hash-map.java)
[981. Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/) | [hashMap + binarySearch](https://github.com/Yukinichi/leetcode/blob/master/Java/981.time-based-key-value-store.java)
[1146. Snapshot Array](https://leetcode.com/problems/snapshot-array/) | [list数组 or TreeMap](https://github.com/Yukinichi/leetcode/blob/master/Java/1146.snapshot-array.java)

## Random
| Problem   | Solution   
:-         |   :-: 
[528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/) | [Random + binarySeach](https://github.com/Yukinichi/leetcode/blob/master/Java/528.random-pick-with-weight.java)
[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/) | [inside-out shuffle](https://github.com/Yukinichi/leetcode/blob/master/Java/384.shuffle-an-array.java)
[470. Implement Rand10() Using Rand7()](https://leetcode.com/problems/implement-rand10-using-rand7/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/470.implement-rand-10-using-rand-7.java)

## Search
| Problem   | Solution   
:-         |   :-: 
[60. Permutation Sequence](https://leetcode.com/problems/permutation-sequence/) | [找到确定每个位置的数字的规律](https://github.com/Yukinichi/leetcode/blob/master/Java/60.permutation-sequence.java)
[90.subsets II](https://leetcode.com/problems/subsets-ii/) | [subset去重](https://github.com/Yukinichi/leetcode/blob/master/Java/90.subsets-ii.java)
[127. Word Ladder](https://leetcode.com/problems/word-ladder/) | [双向BFS](https://github.com/Yukinichi/leetcode/blob/master/Java/127.word-ladder.java)
[126. Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) | [双向BFS + DFS + path建图(Java)](https://github.com/Yukinichi/leetcode/blob/master/Java/126.word-ladder-ii.java) \| [单向BFS(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/126.word-ladder-ii.cpp)
[140. Word Break II](https://leetcode.com/problems/word-break-ii/) | [DFS + memo](https://github.com/Yukinichi/leetcode/blob/master/Java/140.word-break-ii.java)
[329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [DFS + memo](https://github.com/Yukinichi/leetcode/blob/master/Java/329.longest-increasing-path-in-a-matrix.java)
[472. Concatenated Words](https://leetcode.com/problems/concatenated-words/) | [DFS + memo Solution(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/472.concatenated-words.cpp) \| [Trie Solution(Java)](https://github.com/Yukinichi/leetcode/blob/master/Java/472.concatenated-words.java)
[489. Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/) | [模拟dfs, 注意当前robot朝向](https://github.com/Yukinichi/leetcode/blob/master/Java/489.robot-room-cleaner.java)


## Sliding Window
| Problem   | Solution   
:-         |   :-: 
[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Java Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/76.minimum-window-substring.java)
[480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/) | [minHeap + maxHeap](https://github.com/Yukinichi/leetcode/blob/master/Java/480.sliding-window-median.java)
[438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Sliding window + hashmap模版](https://github.com/Yukinichi/leetcode/blob/master/Java/438.find-all-anagrams-in-a-string.java)
[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | [有负数不能用two pointer做sliding window, 换成hashmap的变种](https://github.com/Yukinichi/leetcode/blob/master/Java/560.subarray-sum-equals-k.java)


## String
| Problem   | Solution   
:-         |   :-: 
[468.Validate IP Address](https://leetcode.com/problems/validate-ip-address/) | [String split, NumberFormatException](https://github.com/Yukinichi/leetcode/blob/master/Java/468.validate-ip-address.java)

## Quick Select(TopK)
| Problem   | Solution   
:-         |   :-: 
[973 K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [Quick Select](https://github.com/Yukinichi/leetcode/blob/master/Java/973.k-closest-points-to-origin.java)

## Tree   
| Problem   | Solution   
:-         |   :-: 
[662. Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/662.maximum-width-of-binary-tree.java)
[1110. Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Solution](https://github.com/Yukinichi/leetcode/blob/master/Java/1110.delete-nodes-and-return-forest.java)

## TreeMap(Ordered Map)
| Problem   | Solution   
:-         |   :-: 
[846. Hand of Straights](https://leetcode.com/problems/hand-of-straights/) | [注意follow up](https://github.com/Yukinichi/leetcode/blob/master/Java/846.hand-of-straights.java)

## Trie
| Problem   | Solution   
:-         |   :-: 
[208. Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/) | [Trie模版](https://github.com/Yukinichi/leetcode/blob/master/Java/208.implement-trie-prefix-tree.java)
[212. Word Search II](https://leetcode.com/problems/word-search-ii/) | [Dfs + Trie剪枝](https://github.com/Yukinichi/leetcode/blob/master/Java/212.word-search-ii.java)
[472. Concatenated Words](https://leetcode.com/problems/concatenated-words/) | [Trie Solution(Java)](https://github.com/Yukinichi/leetcode/blob/master/Java/472.concatenated-words.java) \| [DFS + memo Solution(C++)](https://github.com/Yukinichi/leetcode/blob/master/Cpp/472.concatenated-words.cpp)
[1268. Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | [Trie](https://github.com/Yukinichi/leetcode/blob/master/Java/1268.search-suggestions-system.java)

## Union Find
| Problem   | Solution   
:-         |   :-: 
[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | [Union Find](https://github.com/Yukinichi/leetcode/blob/master/Java/695.max-area-of-island.java) \| [DFS](https://github.com/Yukinichi/leetcode/blob/master/Cpp/695.max-area-of-island.cpp)
[952. Largest Component Size by Common Factor](https://leetcode.com/problems/largest-component-size-by-common-factor/) | [连接公因数的UF](https://github.com/Yukinichi/leetcode/blob/master/Java/952.largest-component-size-by-common-factor.java)