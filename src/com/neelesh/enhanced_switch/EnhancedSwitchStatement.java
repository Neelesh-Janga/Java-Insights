package com.neelesh.enhanced_switch;

import java.util.Scanner;

public class EnhancedSwitchStatement {
    public static void main(String[] args) {
        System.out.print("Enter day: ");
        int day = new Scanner(System.in).nextInt();

/*
        Old-fashioned switch-case statement
*/
        switch(day % 7){
            case 1:
                System.out.println("Weekday");
                break;
            case 2:
                System.out.println("Weekday");
                break;
            case 3:
                System.out.println("Weekday");
                break;
            case 4:
                System.out.println("Weekday");
                break;
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
                System.out.println("Weekend");
                break;
            case 0:
                System.out.println("Weekend");
                break;
        }

/*
        Old-fashioned switch-case statement with reduced redundancy
*/
        switch(day % 7){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
            case 0:
                System.out.println("Weekend");
                break;
        }

/*
    * Enhanced switch-case statement
    * Introduced in Java 12 version under the name "switch expressions"
*/
        switch (day % 7) {
            case 1 -> System.out.println("Weekday");
            case 2 -> System.out.println("Weekday");
            case 3 -> System.out.println("Weekday");
            case 4 -> System.out.println("Weekday");
            case 5 -> System.out.println("Weekday");
            case 6 -> System.out.println("Weekend");
            case 0 -> System.out.println("Weekend");
        }

/*
        Old-fashioned switch-case statement with reduced redundancy
*/
        switch(day % 7){
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
            case 6, 0 -> System.out.println("Weekend");
        }

    }
}
