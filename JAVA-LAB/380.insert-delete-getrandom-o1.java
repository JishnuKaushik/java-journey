class RandomizedSet {

    List<Integer> nums;
    Map<Integer,Integer> idx;
    Random rnd;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idx = new HashMap<>();
        rnd = new Random();
    }

    public boolean insert(int val) {
        if(idx.containsKey(val)) return false;
        idx.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!idx.containsKey(val)) return false;
        int i = idx.get(val);
        int lastVal = nums.get(nums.size()-1);
        nums.set(i, lastVal);
        idx.put(lastVal, i);
        nums.remove(nums.size()-1);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        int r = rnd.nextInt(nums.size());
        return nums.get(r);
    }
}
