package com.neelesh.enhanced_switch;

import java.util.Scanner;

public class EnhancedSwitchStatement {
    public static void main(String[] args) {
        System.out.print("Enter day: ");
        int day = new Scanner(System.in).nextInt();

        /*
         * Old-fashioned switch-case statement
         */
        switch (day % 7) {
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
         * Old-fashioned switch-case statement with reduced redundancy
         */
        switch (day % 7) {
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
         * Enhanced switch-case statement with reduced redundancy
         */
        switch (day % 7) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
            case 6, 0 -> System.out.println("Weekend");
        }



        /*
         * Enhanced switch-case statement
         * Introduced in Java 13 version, an extension to Java 12, allowing expressions to return a value using "yield" keyword
         * Rules:
         * 1. default case is mandatory even though the results are bounded inorder to prevent code crash
         * 2. yield should be enclosed with in code blocks or braces
         * 3. Return type of switch should match with the datatype of the variable
         * 4. If we don't save the yielding result in a variable, we get error saying "yield outside of switch Expression.
         * 5. If we use "var" then yielding values can be of any type as shown below because Compiler infers the type during compilation
         * 6. Switch expression with yielding results is used in variable initialization. So make sure to use semicolon ';' at the end of switch expression
         */
        var varDayName = switch (day % 7) {
            case 1 -> {
                System.out.println("Weekday");
                yield 1;
            }
            case 2 -> {
                System.out.println("Weekday");
                yield 2.0;
            }
            case 3 -> {
                System.out.println("Weekday");
                yield "Wednesday";
            }
            case 4 -> {
                System.out.println("Weekday");
                yield "Thursday";
            }
            case 5 -> {
                System.out.println("Weekday");
                yield "Friday";
            }
            case 6 -> {
                System.out.println("Weekend");
                yield 'S';
            }
            default -> {
                System.out.println("Weekend");
                yield true;
            }
        };

        System.out.println("Day = " + varDayName);

        /*
         * Enhanced switch-case statement with reduced redundancy
         */
        String dayName = switch (day % 7) {
            case 1, 2, 3, 4, 5 -> {
                yield "Weekday";
            }
            default -> {
                yield "Sunday";
            }
        };

        System.out.println("Day = " + dayName);
    }
}
