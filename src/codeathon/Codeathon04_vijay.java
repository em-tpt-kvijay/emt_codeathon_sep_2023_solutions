package codeathon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
interface  Operation{
    boolean check(int a);
}

class FindTheValue {
    public static boolean checker(Operation p, int num) {
        return p.check(num);
    }

    public static Operation is_odd() {
        return n -> (n & 1) == 1;
    }

    public static Operation is_prime() {
        return n -> {
            if (n < 2) {
                return false;
            }
            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public static Operation is_palindrome() {
        return n -> {
            String original = Integer.toString(n);
            String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
            return original.equals(reversed);
        };
    }
}

public class Codeathon04_vijay {
    public static void main(String[] args) {
        FindTheValue ob = new FindTheValue();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        Operation op;
        String ans = null;
        scanner.nextLine();

        List<String> results = new ArrayList<>();

        while (T-- > 0) {
            String s = scanner.nextLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            switch(ch)
            {
                case 1:
                    op = ob.is_odd();
                    ans = ob.checker(op, num) ? "ODD" : "EVEN";
                    results.add(ans);
                    break;

                case 2:
                    op = ob.is_prime();
                    ans = ob.checker(op, num) ? "PRIME" : "COMPOSITE";
                    results.add(ans);
                    break;
                case 3:
                    op = ob.is_palindrome();
                    ans = ob.checker(op, num) ? "PALINDROME" : "NOT PALINDROME";
                    results.add(ans);
                    break;
                default :
                    System.out.println("Enter vaild option for input "+ch+":"+num);
            }

        }
        scanner.close();

        for (String result : results) {
            System.out.println(result);
        }
    }
}
