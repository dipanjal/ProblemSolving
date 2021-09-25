package com.dipanjal.aws.mock;

import java.util.*;

public class Test1 {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here

        Map<String, Integer> posMap = new HashMap<>();
        for(int i=0; i<customerQuery.length() - 1; i++) {
            String subStr = customerQuery.substring(0, i+2);
            posMap.put(subStr, -1);
            repository.add(subStr);
        }

        repository.sort(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < repository.size(); i++ ) {
            if(posMap.containsKey(repository.get(i))){
                if(posMap.get(repository.get(i)).equals(-1)){
                    posMap.put(repository.get(i), i);
                }
            }
        }

        List<List<String>> suggestion = new ArrayList<>();

        for(int i=0; i<customerQuery.length() - 1; i++) {
            int counter = 0;
            String subStr = customerQuery.substring(0, i+2);
            Integer pos = posMap.get(subStr);
            Set<String> checkedSet = new HashSet<>();

            List<String> result = new ArrayList<>();
            for(int k=pos+1; k<repository.size(); k++) {

                if(counter >= 3)
                    break;

                String value = repository.get(k);
                if(posMap.containsKey(value) && !checkedSet.contains(value)) {
                    if(!(subStr.length() == customerQuery.length() && subStr.equalsIgnoreCase(value))){
                        checkedSet.add(value);
                        continue;
                    }
                }

                if(value.startsWith(subStr)) {
                    result.add(value);
                    counter++;
                }else{
                    break;
                }
            }
            suggestion.add(result);
        }

        return suggestion;
    }

    public static void main(String[] args) {
        List<String> repo = new ArrayList<>();
        repo.add("mobile");
        repo.add("mouse");
        repo.add("moneypot");
        repo.add("monitor");
        repo.add("mousepad");
        searchSuggestions(repo, "mouse");
    }
}
