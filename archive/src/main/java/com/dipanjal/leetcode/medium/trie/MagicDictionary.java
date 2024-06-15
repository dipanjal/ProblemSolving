package com.dipanjal.leetcode.medium.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * problem: 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * medium
 */

public class MagicDictionary {

    /*public static class Node {
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

    public MagicDictionary() {
        this.root = new Node('\0');
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary)
            insert(word);
    }

    private void insert(String word) {
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

    public boolean search(String searchWord) {
        Node node = getNode(searchWord);
        return (node != null && node.isWord);
    }

    private Node getNode(String word) {
        Node curr = root;
        boolean isReplaced = false;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null && !isReplaced) {
                index = curr.children[]
            }

            curr = curr.children[index];
        }
        return curr;
    }*/

    Map<Integer, Set<String>> map;
    public MagicDictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            Integer key = word.length();

            /*if(!map.containsKey(key))
                map.put(key, new HashSet<>());
            map.get(key).add(word);*/

            map.computeIfAbsent(key, k -> new HashSet<>()).add(word);
        }
    }

    public boolean search(String searchWord) {

        if(!map.containsKey(searchWord.length())) return false;

        for(String word: map.get(searchWord.length())){
            int misMatch = 0;
            for(int i=0; i<word.length(); i++) {
                if(word.charAt(i) != searchWord.charAt(i)){
                    if(++misMatch > 1)
                        break;
                }
            }
            if(misMatch == 1) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dict = new String[]{"hello", "leetcode"};
        magicDictionary.buildDict(dict);
    }
}
