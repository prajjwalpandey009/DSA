package org.example.trie;

import java.util.*;


public class SearchSuggestionsSystem {


    public static void main(String[] args) {
        suggestedProducts(new String[]{"havana"},
                "tatiana");
    }

    static class TrieNode {
        TrieNode[] trieNodes;
        LinkedList<String> list;
        boolean end;

        public TrieNode(TrieNode[] trieNodes, LinkedList<String> list) {
            this.trieNodes = trieNodes;
            this.list = list;
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode(new TrieNode[26], null);
        insertWord(root, products);
        return dfs(root, searchWord);
    }

    private static List<List<String>> dfs(TrieNode root, String searchWord) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root.trieNodes[searchWord.charAt(0) - 'a']);
        List<List<String>> listOfList = new LinkedList<>();

        int indexCounter = 1;
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            if (node != null) {
                listOfList.add(node.list);
                if (indexCounter > searchWord.length() - 1) {
                    break;
                }
                if (node.end)
                    stack.push(node.trieNodes[searchWord.charAt(indexCounter) - 'a']);
            }
            indexCounter++;
        }
        int length = searchWord.length() - listOfList.size() - 1;
        while (length >= 0) {
            listOfList.add(Collections.emptyList());
            length--;
        }
        return listOfList;
    }

    public static void insertWord(TrieNode root, String[] products) {
        TrieNode curr = root;
        for (String product : products) {
            for (char ch : product.toCharArray()) {
                if (curr.trieNodes[ch - 'a'] == null) {
                    LinkedList<String> list = new LinkedList<>();
                    list.add(product);
                    curr.trieNodes[ch - 'a'] = new TrieNode(new TrieNode[26], list);
                } else {
                    LinkedList<String> list = curr.trieNodes[ch - 'a'].list;
                    list.add(product);
                    Collections.sort(list);
                    if (list.size() > 3) {
                        list.pollLast();
                    }
                }
                curr = curr.trieNodes[ch - 'a'];
            }

            //marking end of word
            curr.end = true;

            //Again set to root
            curr = root;
        }
    }

    //without trie approach
    /*public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> listOfList = new ArrayList<>();
        Node root = new Node(256);
        //To word element in lexo-geographical order
        Arrays.sort(products);
        insertWord(root, products);
        String prefix = "";
        for (int i = 0; i < searchWord.length(); i++) {
            prefix = prefix + searchWord.charAt(i);
            List<String> list = searchWordByPrefix(prefix, root);
            listOfList.add(list);
        }
        return listOfList;
    }*/
}
