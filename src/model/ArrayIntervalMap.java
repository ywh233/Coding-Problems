package model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yuwei on 15/9/23.
 * Project: CodingProblems
 *
 * Use Case: LRC lyrics structure
 */
public class ArrayIntervalMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<Entry<K, V>> array;

    public ArrayIntervalMap() {
        array = new ArrayList<>();
    }

    @Override
    public V put(K key, V value) {
        int position = binarySearch(key);
        Entry<K,V> newEntry = new SimpleEntry<>(key, value);
        if (array.isEmpty()) {
            array.add(newEntry);
        } else if (position == -1) {
            array.add(0, newEntry);
        } else {
            Entry<K, V> entry = array.get(position);
            V oldValue = entry.getValue();
            int compareResult = entry.getKey().compareTo(key);
            assert compareResult <= 0;
            if (compareResult == 0) {
                // replacement
                array.set(position, newEntry);
                return oldValue;
            } else if (position + 1 < array.size()) {
                // insert before
                array.add(position + 1, newEntry);
            } else {
                array.add(newEntry);
            }
        }
        return null;
    }

    @Override
    public V get(Object obj) {
        int position = binarySearch((K) obj);
        if (position == -1) {
            return null;
        } else {
            return array.get(position).getValue();
        }
    }

    @Override
    public int size() {
        return array.size();
    }

    /**
     *
     * @return Index of the last entry with key <= parameter key
     */
    private int binarySearch(K key) {
        int begin = 0;
        int end = array.size();

        while (end > begin + 1) {
            int mid = (begin + end) / 2;
            if (array.get(mid).getKey().compareTo(key) <= 0) {
                begin = mid;
            } else {
                end = mid;
            }
        }

        if (begin < array.size() && array.get(begin).getKey().compareTo(key) <= 0) {
            return begin;
        } else {
            return -1;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return array.stream()
                .collect(Collectors.toSet());
    }
}
