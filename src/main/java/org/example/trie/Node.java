package org.example.trie;

public class Node {
    String word;
    Node[] nodes;
    boolean end;

    public Node(int size) {
        this.nodes = new Node[256];
    }


    public Node(int size, String word) {
        this.nodes = new Node[256];
        this.word = word;
    }
}
