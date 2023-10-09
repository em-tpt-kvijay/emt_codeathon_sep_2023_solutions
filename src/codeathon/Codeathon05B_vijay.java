package codeathon;

import java.util.Scanner;

public class Codeathon05B_vijay {
    public static void main(String[] args) {
        System.out.println("Enter the value of x and y");
        Scanner sc = new Scanner(System.in);
        int variable1 = sc.nextInt();
        int variable2 = sc.nextInt();
        variable1 = variable1 + variable2;
        variable2 = (variable1 -  variable2);
        variable1 = (variable1 - variable2);

        System.out.println("variable1 = " + ((int)(0.10*variable1)));//10% of variable1
        System.out.println("variable2 = " + ((int)(0.20*variable2)));//20% of variable2
    }
}
