package model;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class Trie<T> extends AbstractCollection<List<T>> {
    // Invar: hasData of last layer TrieNodes (children.isEmpty()) must be true.
    private final MapTrieNode<T> root;
    private int size;

    public Trie() {
        root = new MapTrieNode<>(null);
        size = 0;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new TrieIterator(root);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(List<T> list) {
        TrieNode<T> currentNode = root;

        for (T cur : list) {
            TrieNode<T> nextNode = currentNode.getChild(cur);
            if (nextNode == null) {
                nextNode = new MapTrieNode<>(cur);
                currentNode.setChild(cur, nextNode);
            }
            currentNode = nextNode;
        }
        currentNode.hasContent = true;
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List<T> list = (List<T>) obj;
        TrieNode<T> currentNode = root;

        for (T cur : list) {
            TrieNode<T> nextNode = currentNode.getChild(cur);
            if (nextNode == null) {
                return false;
            }
            currentNode = nextNode;
        }

        return currentNode.hasContent;
    }

    private class TrieIterator implements Iterator<List<T>> {
        private final Queue<QueueNode> queue;

        public TrieIterator(MapTrieNode<T> root) {
            queue = new LinkedBlockingQueue<>();
            queue.addAll(toQueueNodes(root.viewChildrenValues(), null));
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public List<T> next() {
            while (!queue.isEmpty()) {
                QueueNode node = queue.remove();
                if (!node.current.isLeaf()) {
                    queue.addAll(toQueueNodes(node.current.viewChildrenValues(),
                            node));
                }
                if (node.current.hasContent) {
                    return toReversedList(node);
                }
            }
            return null;
        }

        private List<T> toReversedList(QueueNode node) {
            List<T> list = new ArrayList<>();
            while (node != null) {
                list.add(node.current.value);
                node = node.prev;
            }
            Collections.reverse(list);
            return list;
        }

        private List<QueueNode> toQueueNodes(Collection<TrieNode<T>> nodes, QueueNode prev) {
            return nodes
                    .stream()
                    .map((node)->new QueueNode((MapTrieNode<T>)node, prev))
                    .collect(Collectors.toList());
        }

        private class QueueNode {
            public MapTrieNode<T> current;
            public QueueNode prev;

            public QueueNode(MapTrieNode<T> current, QueueNode prev) {
                this.current = current;
                this.prev = prev;
            }
        }
    }
}
