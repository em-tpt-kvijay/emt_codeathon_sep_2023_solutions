package codeathon;

import java.util.*;

public class Codeathon06_vijay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of values for list1 and list2: ");
        int numValues = sc.nextInt();
        sc.nextLine();
        List<String> list1 = new ArrayList<>();
        System.out.println("give list1 values:");
        for (int i = 0; i < numValues; i++) {
            String input = sc.nextLine();
            list1.add(input);
        }

        List<String> list2 = new ArrayList<>();
        System.out.println("give list2 values:");
        for (int i = 0; i < numValues; i++) {
            String input = sc.nextLine();
            list2.add(input);
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            String str = list1.get(i);
            List<String> fruits = findTheListOfFruits(str, list2);
            resultMap.put(str, fruits);
        }

        for (int i = 0; i < list1.size(); i++) {
            String str = list1.get(i);
            List<String> findFruits = resultMap.get(str);//here we are getting list of fruits name with key string value
            System.out.print(str + ": ");
            if (findFruits.isEmpty()) {
                System.out.println("[no fruit]");
            } else {
                System.out.println(String.join(",", findFruits));
            }
        }
    }

    private static List<String> findTheListOfFruits(String str, List<String> fruitList) {
        char word = findTheLetter(str);
        List<String> findFruits = new ArrayList<>();

        for (int i = 0; i < fruitList.size(); i++) {
            String s = fruitList.get(i);
            if (s.length() == word - 'a' + 1) {
                findFruits.add(s);
            }
        }
        return findFruits;
    }

    private static char findTheLetter(String uniqueCode) {
        for (char ch : uniqueCode.toCharArray()) {
            if (Character.isLetter(ch)) {
                return Character.toLowerCase(ch);
            }
        }
        return ' ';
    }
}
