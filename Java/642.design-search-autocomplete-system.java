/*
 * @lc app=leetcode id=642 lang=java
 *
 * [642] Design Search Autocomplete System
 */

// @lc code=start

/*
Trie记录前缀搜索的字符
对于每一个字符，利用一个hashmap来记录与之有关的字符串和对应的count
input的时候利用一个PriorityQueue来返回count最大的三个结果
time: O(nl) for building the trie, n = number of sentences and l = avg length of sentence
      O(l + mlogm) m = size of map
space: O(nl) and memory of each map
*/
class AutocompleteSystem {
    class TrieNode {
        TrieNode[] children;
        Map<String, Integer> count;
        public TrieNode() {
            children = new TrieNode[128];
            count = new HashMap<>();
        }
    }
    
    class Pair {
        String key;
        int count;
        public Pair(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    TrieNode root;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (int i = 0; i < sentences.length; ++i) {
            add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb.setLength(0);
            return res;
        }
        sb.append(c);
        TrieNode cur = root;
        for (int i = 0; i < sb.length(); ++i) {
            if (cur.children[sb.charAt(i)] == null) return res;
            cur = cur.children[sb.charAt(i)];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
            a.count == b.count ? a.key.compareTo(b.key) : b.count - a.count);
        for (String key : cur.count.keySet()) {
            pq.add(new Pair(key, cur.count.get(key)));
        }
        for (int i = 0; i < 3 && !pq.isEmpty(); ++i) {
            res.add(pq.poll().key);
        }
        return res;
    }
    
    private void add(String sentence, int times) {
        TrieNode cur = root;
        for (char c : sentence.toCharArray()) {
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
            cur.count.put(sentence, cur.count.getOrDefault(sentence, 0) + times);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
// @lc code=end

