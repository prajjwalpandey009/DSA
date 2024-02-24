package org.example.trie;

public class TrieInsertAndSearchImplementation {
    Node root;

    public TrieInsertAndSearchImplementation() {
        root = new Node(256);
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Node node;
            if (curr.nodes[word.charAt(i)] == null) {
                node = new Node(256);
                curr.nodes[word.charAt(i)] = node;
            } else {
                node = curr.nodes[word.charAt(i)];
            }
            curr = node;
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.nodes[word.charAt(i)] != null) {
                curr = curr.nodes[word.charAt(i)];
            } else {
                return false;
            }
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.nodes[prefix.charAt(i)] != null) {
                curr = curr.nodes[prefix.charAt(i)];
            } else {
                return false;
            }
        }
        return true;
    }
}
