package com.dipanjal.common.trie;

public class Trie {
    public static class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(curr.children[index] == null)
                curr.children[index] = new Node(c);
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = getNode(prefix);
        return node != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(curr.children[index] == null) return null;
            curr = curr.children[index];
        }
        return curr;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("mouse");
        trie.insert("mousepad");
        trie.insert("mouth");

        String prefix = "mou";
        String word = "mouse";
        System.out.printf("Start with %s ==> %s%n", prefix, trie.startsWith(prefix));
        System.out.printf("Search Word %s ==> %s%n", prefix, trie.search(prefix));
        System.out.printf("Search Word %s ==> %s%n", word, trie.search(word));
    }
}
