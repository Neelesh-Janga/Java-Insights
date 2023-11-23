package com.neelesh.enhanced_switch;

import com.neelesh.enhanced_switch.Classes.*;

import java.util.Scanner;

public class EnhancedSwitchStatement {
    public static void main(String[] args) {
        System.out.print("Enter day: ");
//        int day = new Scanner(System.in).nextInt();
        int day = 1;

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
         * Still here we must make sure the type of case must be same in order for the swtich statement to fall-through the cases
         * else compile time error comes.
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

        /*
        * In Java 21 version, Pattern matching in Switch-Case statement is introduced allowing Objects to pass in to switch args
        * The cases that we are looking must be base class of the the Obejct/class that we pass inside switch parameter
        * */

        Vehicle vehicle = new Car();
        switch (vehicle){
            case Car c -> c.drive();
            case Bike b -> b.drive();
            default -> System.out.println("Unexpected value: " + vehicle);
        }

        /*
        * Notes:
        * 1. The below code throws error because the object pulsar is more dominating than ninja. So first we need to check ninja and then pulsar
        * 2. We need to follow a way of writing cases that conditioned things need to be checked rather condition less things
        * 3. This concept is also called as Guarded and UnGuarded Patterns
        * 4. In Java, pattern matching was introduced as a preview feature in JDK 16 and further refined in subsequent releases.
        * 5. In an unguarded pattern, the pattern directly checks the type or structure of the expression without any additional conditions.
        *    It is the simplest form of pattern matching.
        * 6. A guarded pattern combines a pattern with a boolean expression (the guard).
        *    It allows for more complex conditions beyond just checking the type or structure.
        * 7. An unguarded pattern case label dominates a guarded pattern case label that has the same pattern.
        * 8. A guarded pattern case label dominates another pattern case label (guarded or unguarded) only when both the
        *    former's pattern dominates the latter's pattern and when its guard is a constant expression of value true
        * 9. Order of labeling: "Constant" followed by the case "null" label then the guarded pattern labels, and the un-guarded type pattern labels.
        *    The default case label can be combined with the case null label, or placed separately as the last case label
        * 10. At this moment, a pattern switch does not support the primitive types
        */
        vehicle = new Bike();
        switch (vehicle){
            case Car car -> car.drive();
//            case Bike pulsar -> pulsar.drive();
//            case Bike ninja
//                    when ninja.getColor().equals("blue") || ninja.getColor().equals("green") ->
//                    System.out.println("Bike color is " + ninja.getColor());
            case Bike ninja
                    when ninja.getColor().equals("blue") || ninja.getColor().equals("green") ->
                    System.out.println("Bike color is " + ninja.getColor());
            case Bike pulsar -> pulsar.drive();
            default -> System.out.println("Unexpected value was passed");
        }

        Object object = new Aeroplane();
        switch (object){
            case Car car -> car.drive();
            case Bike bike when bike.getColor().equals("blue") -> bike.drive();
            case Aeroplane aeroplane -> aeroplane.drive();
            default -> System.out.println("Unexpected value was passed");
        }
    }
}
