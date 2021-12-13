package interviewing.datastructures;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private Map<Integer, Integer> values;

    public DisjointSet() {
        values = new HashMap<>();
    }

    public void makeSet(int value) {
        values.putIfAbsent(value, value);
    }

    public void mergeSets(int v1, int v2) {
        assert values.containsKey(v1) && values.containsKey(v2);
        values.put(v2, v1);
        for (Map.Entry<Integer, Integer> kv : values.entrySet()) {
            if (kv.getValue() == v2) {
                values.put(kv.getKey(), v1);
            }
        }
    }

    public int find(int value) {
        if (!values.containsKey(value)) {
            return -1;
        }

        int parent = values.get(value);
        if (parent == value) {
            return value;
        }
        return find(parent);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
