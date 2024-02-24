package org.example.trie;


import java.util.Stack;

//We have solved this problem by two approach
//One is using Trie data structure
//One is normal approach using hashset

public class LongestWordInDictionary {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"a", "ap", "app", "appl", "apply", "apple"}));
    }

    //without trie approach
//    public static String longestWord(String[] words) {
//        Arrays.sort(words);
//        String res = "";
//        HashSet<String> buildWord = new HashSet<>();
//        for (String word : words) {
//            if (word.length() == 1 || buildWord.contains(word.substring(0, word.length() - 1))) {
//                buildWord.add(word);
//                if (res.length() < word.length()) {
//                    res = word;
//                }
//            }
//        }
//        return res;
//    }

    public static String longestWord(String[] words) {
        Node root = new Node(256);
        root.end = true;
        insertWord(root, words);
        return dfs(root);
    }

    private static String dfs(Node root) {
        String res = "";
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null && node.end) {
                if (node.word != null && node.word.length() >= res.length()) {
                    res = node.word;
                }
                for (int i = 0; i < node.nodes.length; i++) {
                    if (node.nodes[i] != null) {
                        stack.push(node.nodes[i]);
                    }
                }
            }
        }
        return res;
    }


    public static void insertWord(Node root, String[] products) {
        Node curr = root;
        for (String product : products) {
            for (int i = 0; i < product.length(); i++) {
                Node childNode;
                if (curr.nodes[product.charAt(i) - 'a'] == null) {
                    childNode = new Node(26, product.substring(0, i + 1));
                    curr.nodes[product.charAt(i) - 'a'] = childNode;
                } else {
                    childNode = curr.nodes[product.charAt(i) - 'a'];
                }
                curr = childNode;
            }
            curr.end = true;

            //Again set root so next word start inserting from top again
            curr = root;
        }
    }
}
