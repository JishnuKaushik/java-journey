class MyCircularQueue {

    int[] arr;
    int head;
    int count;
    int cap;

    public MyCircularQueue(int k) {
        arr = new int[k];
        cap = k;
        head = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        int tail = (head+count)%cap;
        arr[tail] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head+1)%cap;
        count--;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return arr[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        int tail = (head+count-1)%cap;
        return arr[tail];
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==cap;
    }
}
