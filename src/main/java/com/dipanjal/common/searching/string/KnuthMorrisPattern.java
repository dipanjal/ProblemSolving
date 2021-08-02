package com.dipanjal.common.searching.string;

/**
 * @author dipanjal
 * @since 0.0.1
 * Difficulty: Medium
 */
public class KnuthMorrisPattern {

    private static int[] getLPS(String s){
        int walker = 0;
        int runner = 1;
        int [] lps = new int[s.length()];
        while (runner < s.length()){
            if(s.charAt(walker) == s.charAt(runner))
                lps[runner++] = ++walker;
            else if (walker > 0) //walker has started to walk, means we have found a prefix matched suffix
                walker = lps[walker - 1];
            else
                lps[runner++] = 0;
        }
        return lps;
    }

    public static int kmpSubstringSearch(String s, String pat){
        int[] lps = getLPS(pat);
        int sIndex = 0, patIndex = 0;
        while(sIndex < s.length()){
            if(s.charAt(sIndex) == pat.charAt(patIndex)){
                sIndex++;
                patIndex++;
            }
            else if(patIndex > 0)
                patIndex = lps[patIndex-1];
            else
                sIndex++;

            if(patIndex == pat.length()){
                return sIndex - patIndex;
            }
        }
        return -1;
    }



    public static void main(String[] args) {

        System.out.println(kmpSubstringSearch("banana", "ana"));
        System.out.println(kmpSubstringSearch("aquickbrownfoxjumpsoverthelazydog", "fox"));
        System.out.println(kmpSubstringSearch("aquickbrownfoxjumpsoverthelazydog", "bro"));

//        System.out.println(kmpSubstringSearch("banana", "ana"));
//        String s = "aabaaac";
//        int[] lps = getLPS(s);
//        String arrJoined = Arrays.stream(lps)
//                .mapToObj(String::valueOf)
//                .collect(Collectors.joining(","));
//        System.out.println(arrJoined);

    }
}
