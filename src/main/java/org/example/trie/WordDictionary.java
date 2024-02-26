package org.example.trie;

import java.util.Stack;

public class WordDictionary {

    TrieNode root;

    static class TrieNode {
        TrieNode[] trieNodes;
        boolean end;

        public TrieNode(TrieNode[] trieNodes) {
            this.trieNodes = trieNodes;
        }
    }

    public WordDictionary() {
        root = new TrieNode(new TrieNode[26]);
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.trieNodes[ch - 'a'] == null) {
                TrieNode trieNode = new TrieNode(new TrieNode[26]);
                curr.trieNodes[ch - 'a'] = trieNode;
                curr = trieNode;
            } else {
                curr = curr.trieNodes[ch - 'a'];
            }
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, TrieNode root) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        int index = 0;
        while (!stack.isEmpty()) {
            TrieNode trieNode = stack.pop();
            if (index > word.length() - 1 && trieNode.end) {
                //If reached the end
                return true;
            } else if (index > word.length() - 1) {
                return false;
            }
            if (word.charAt(index) == '.') {
                for (TrieNode node : trieNode.trieNodes) {
                    if (node != null) {
                        stack.push(node);


                    }
                }
            } else {
                if (trieNode.trieNodes[word.charAt(index) - 'a'] != null) {
                    //If previous macthed then push for the next character check
                    stack.push(trieNode.trieNodes[word.charAt(index) - 'a']);
                } else {
                    //if any of the character is mismatched from the given word the return
                    return false;
                }
            }
            index++;
        }
        return false;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("prajjwal");
        wordDictionary.addWord("prajjwalm");
        System.out.println(wordDictionary.search(".rajjwal"));
        System.out.println("hii");
    }
}
