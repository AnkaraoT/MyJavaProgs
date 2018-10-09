package com.myjava.prog.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AnargamDiff {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());*/

    	List<String> a = new ArrayList<String>();
    	a.add("ab");
    	

    	List<String> b = new ArrayList<String>();
    	b.add("bc");
    	
        List<Integer> result = Result.getMinimumDifference(a, b);

        for(int i :result)
        System.out.println(i);
        /*bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

class Result {

    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
    // Write your code here
        List<Integer> resutList = new ArrayList<Integer>();
        if(a!=null && b!=null && a.size() == b.size()){
             for(int i=0; i<a.size();i++){
            resutList.add(findAnagram(a.get(i),b.get(i)));
            }
        }
        return resutList;
    } 
    
    public static int findAnagram(String s1, String s2) {

        int count = 0;
 
        // store the count of character
        int char_count[] = new int[26];
 
        // iterate though the first String and update 
        // count
        for (int i = 0; i < s1.length(); i++) 
            char_count[s1.charAt(i) - 'a']++;        
 
        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++) 
            if (char_count[s2.charAt(i) - 'a']-- <= 0)
                count++;
         
        return count;
    }

}

