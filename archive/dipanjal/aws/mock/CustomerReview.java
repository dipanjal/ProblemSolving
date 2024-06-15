package com.dipanjal.aws.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerReview {

    public static class Node {
        public boolean isWord;
        List<String> list;
        HashMap<Character, Node> children;

        public Node() {
            this.list = new ArrayList<>();
            this.children = new HashMap<>();
        }
    }

    /**
     *
     * @param repository {mobile, mouse, moneypot, monitor, mousepad}
     * @param customerQuery mouse
     * @return List of sugestions
     * result:
     *      - mo: mobile, moneypot, monitor
     *      - mou: mouse, mousepad
     *      - mous: mouse, mousepad
     *      - mouse: mouse, mousepad
     */
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery){
        if(repository == null || repository.isEmpty() || customerQuery == null || customerQuery.length() == 0)
            return new ArrayList<>();

        repository.sort(String.CASE_INSENSITIVE_ORDER);

        Node curr = buildTree(repository);
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<customerQuery.length(); i++){
            char key = customerQuery.charAt(i);
            curr = curr.children.get(key);
            if(curr == null)
                break;

            if(i > 0) {
                List<String> temp = new ArrayList<>();
                List<String> words = curr.list;
                for (int j = 0; (j < words.size() && j < 3 ); j++)
                    temp.add(words.get(j));
                result.add(temp);
            }
        }
        return result;
    }

    private static Node buildTree(List<String> repository) {
        Node root = new Node();
        for(String word: repository){
            Node curr = root;
            for(int i = 0; i < word.length(); i++){
                char key = word.charAt(i);
                if(!curr.children.containsKey(key)){
                    curr.children.put(key, new Node());
                }
                curr = curr.children.get(key);
                curr.list.add(word.toLowerCase());
            }
            curr.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        List<String> repo = new ArrayList<>();
        repo.add("mobile");
        repo.add("mouse");
        repo.add("moneypot");
        repo.add("monitor");
        repo.add("mousepad");
        repo.add("bird");
        List<List<String>> result = searchSuggestions(repo, "mouse");

        result.forEach(strings -> {
            strings.forEach(s -> System.out.printf("%s | ", s));
            System.out.println("\n-------------------------");
        });
    }
}
