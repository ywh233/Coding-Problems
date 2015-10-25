package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin on 15/10/5.
 */
public class AlienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, DoubleLinkedList> linkedListMap = new HashMap<>();

        String lastWord = null;

        for (String word : words) {
            if (lastWord == null) {
                lastWord = word;
                continue;
            }

            OrderPair pair = compareWords(lastWord, word);
            if (pair != null) {
                DoubleLinkedList smaller = linkedListMap.get(pair.smaller);
                DoubleLinkedList larger = linkedListMap.get(pair.larger);
                if (smaller == null) {
                    smaller = new DoubleLinkedList(pair.smaller, null, null);
                    linkedListMap.put(pair.smaller, smaller);
                }
                if (larger == null) {
                    larger = new DoubleLinkedList(pair.larger, null, null);
                    linkedListMap.put(pair.larger, larger);
                }
                smaller.next = larger;
            }
        }
        return null;
    }

    private static OrderPair compareWords(String smaller, String larger) {
        for (int i = 0; i < smaller.length(); i++) {
            if (smaller.charAt(i) != larger.charAt(i)) {
                return new OrderPair(smaller.charAt(i), larger.charAt(i));
            }
        }
        return null;
    }

    private static class DoubleLinkedList {
        char ch;
        DoubleLinkedList next;
        public DoubleLinkedList(char c, DoubleLinkedList p, DoubleLinkedList n) {
            ch = c;
            next = n;
        }
    }

    private static class OrderPair {
        char smaller, larger;
        public OrderPair(char s, char l) {
            smaller = s;
            larger = l;
        }
    }
}
