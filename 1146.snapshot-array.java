/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start
/*
利用一个array储存对应的数组，然后每一个index储存对应的快照id的值,再利用一个curSnap track current snap id
length 5 [list list list list list]
set(0,5) [ 5                      ]
snap
set(0.6) [5,6                     ]
get(0,0) -> [5,6] -> 5
*/
class SnapshotArray {
    List<Integer>[] arr;
    int curSnapId = 0;
    public SnapshotArray(int length) {
        arr = new List[length];
        for (int i = 0; i < length; ++i) {
            arr[i] = new ArrayList<>();
        }
    }
    
    public void set(int index, int val) {
        List<Integer> curList = arr[index];
        while (curList.size() <= curSnapId) curList.add(null);
        curList.set(curSnapId, val);
    }
    
    public int snap() {
        return curSnapId++;
    }
    
    public int get(int index, int snap_id) {
        List<Integer> curList = arr[index];
        if (curList.size() <= snap_id) {
            snap_id = curList.size() - 1;
        }
        while (snap_id >= 0 && curList.get(snap_id) == null) snap_id--;
        if (snap_id < 0) return 0;  // call get first
        return curList.get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

