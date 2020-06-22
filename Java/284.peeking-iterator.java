/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

/*
利用一个next变量提前cache iterator的next, 调用next时返回cache中的next
为了防止list中有null,就不用一个null来标记next不存在的next, 用bool end来代替
*/

import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> it;
    boolean end;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
        if (it.hasNext()) next = it.next();
        else end = true;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (end) throw new NoSuchElementException();
        Integer res = next;
        if (it.hasNext()) next = it.next();
        else end = true;
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !end;
	}
}
// @lc code=end

