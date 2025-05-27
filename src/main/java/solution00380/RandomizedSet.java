package solution00380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    private final Set<Integer> set = new HashSet<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int[] arr = set.stream().mapToInt(i -> i).toArray();
        var idx = new Random().nextInt(arr.length);
        return arr[idx];
    }
}
