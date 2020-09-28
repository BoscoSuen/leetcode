/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

// @lc code=start
class ProductOfNumbers {
    /*
    prefix array
    如果有0，则将之前的清空
    如果k > size,说明这部分有0
    */
    List<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }
    
    public void add(int num) {
        if (num > 0) {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        } else {
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProduct.size();
        return size > k ? prefixProduct.get(size - 1) / prefixProduct.get(size - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

