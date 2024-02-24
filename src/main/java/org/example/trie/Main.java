package org.example.trie;

public class Main {
    public static void main(String[] args) {
        TrieInsertAndSearchImplementation trieInsertAndSearchImplementation = new TrieInsertAndSearchImplementation();
        trieInsertAndSearchImplementation.insert("appl");
        trieInsertAndSearchImplementation.insert("apple");
        trieInsertAndSearchImplementation.insert("prajjwal");
        System.out.println(trieInsertAndSearchImplementation.search("app"));
        System.out.println(trieInsertAndSearchImplementation.startsWith("app"));
        System.out.println(trieInsertAndSearchImplementation.search("app"));
        System.out.println(trieInsertAndSearchImplementation.search("apple"));
        System.out.println(trieInsertAndSearchImplementation.search("prajjwal"));

    }
}
