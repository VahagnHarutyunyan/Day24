package com.company;

import java.util.*;

/*
1. Write a method which will check if the given array of
integers contains duplicate elements.
2.Write a method which prints elements that occurred only
once in the array.
3.Write a method that counts duplicate characters from a
given string.
4.Write a method that returns the first non-repeated
character from a given string.
5.Write a method which will return the length of the longest
substring without repeating characters.
“abba” – 2, “abcdaefjh” – 8
 */
public class Main {

    public static void main(String[] args) {
//        Integer[] array = {1, 2, 3, 4, 2, 5};
//        List<Integer> list = new ArrayList<>(Arrays.asList(array));

//        System.out.println(isDuplicate(list));

//        printUnique(list);

//        String string = "12a3425aa";
//        System.out.println(countDuplicate(string));

//        String string = "hellho";
//        String string = "helleoho";
//        try{
//            System.out.println(firstNonRepeated(string));
//        } catch (Exception ex) {
//            System.out.println("All characters are repeated");
//        }


//        String string = "abba";
//        String string = "abcdaefjh";
//        System.out.println(exerciseFive(string));


    }

    static boolean isDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return !(set.size() == list.size());
    }

    static void printUnique(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), 2);
            } else {
                map.put(list.get(i), 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == Integer.valueOf(1)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    static int countDuplicate(String str) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 2);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == Integer.valueOf(2)) {
                count++;
            }
        }
        return count;
    }

    static char firstNonRepeated(String str) throws Exception {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 2);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == Integer.valueOf(1)) {
                return (Character) entry.getKey();
            }
        }
        throw new Exception();
    }

    static int exerciseFive(String str) {
        int max = 0;
        int temp;
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                temp = isNotRepeatedCount(str.substring(i, j));
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    static int isNotRepeatedCount(String str) {
        Set<Character> set = new HashSet<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            set.add(str.charAt(i));
        }
        if (set.size() == length) {
            return length;
        }
        return 0;
    }
}

