/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {

    class Node {
        int key, val;
        Node next;
        Node(int key, int val) { this.key = key; this.val = val; }
    }

    Node[] buckets;
    static final int CAP = 1000;

    public MyHashMap() {
        buckets = new Node[CAP];
    }

    int hash(int key) {
        return key % CAP;
    }

    public void put(int key, int value) {
        int h = hash(key);
        if(buckets[h] == null){
            buckets[h] = new Node(key, value);
            return;
        }
        Node cur = buckets[h];
        while(true){
            if(cur.key == key){
                cur.val = value;
                return;
            }
            if(cur.next == null) break;
            cur = cur.next;
        }
        cur.next = new Node(key, value);
    }

    public int get(int key) {
        Node cur = buckets[hash(key)];
        while(cur != null){
            if(cur.key == key) return cur.val;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Node cur = buckets[h];
        if(cur == null) return;
        if(cur.key == key){
            buckets[h] = cur.next;
            return;
        }
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end
