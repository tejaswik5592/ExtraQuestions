// Time Complexity = O(1)
// Space Complexity = O(n)

// Used a HashMap and a ArrayList, HashMap will help in adding and deleting in O(1) and ArrayList will help in randomizing
// the index and returning in O(1)
import java.util.Random;
class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> li;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        li = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, li.size());
        li.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        swap(index, li.size()-1);
        map.remove(val);
        li.remove(li.size()-1);

        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(li.size());
        return li.get(idx);
    }

    private void swap(int index, int last) {
        // swap in list and map
        int val1 = li.get(index);
        int val2 = li.get(last);

        li.set(index, val2);
        li.set(last, val1);

        map.put(val1, last);
        map.put(val2, index);
    }
}