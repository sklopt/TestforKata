package ru.gilmanov.TestCalcForCata;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите в одну строку только арабские или только римские числа " +
                "от 01 до 10 включительно и знак сложения, " +
                "вычитания, умножения или деления и узнай результат вычисления. " +
                "Сначала введи первое число, пробел, потом знак, снова пробел и второе число");
        String line = scanner.nextLine();
        scanner.close();
        System.out.println(Main.calc(line));
    }

    static class Main {
        static String[] numbers = {null, null};
        static String[] carabiners = {null, null};

        public static String calc(@NotNull String newline) throws Exception {

            String[] userinfo = newline.split(" ", 3);
            try {
                String first = userinfo[0];
                String second = userinfo[2];
                switch (first) {
                    case "I" -> carabiners[0] = String.valueOf(1);
                    case "1" -> numbers[0] = String.valueOf(1);
                    case "II" -> carabiners[0] = String.valueOf(2);
                    case "2" -> numbers[0] = String.valueOf(2);
                    case "III" -> carabiners[0] = String.valueOf(3);
                    case "3" -> numbers[0] = String.valueOf(3);
                    case "IV" -> carabiners[0] = String.valueOf(4);
                    case "4" -> numbers[0] = String.valueOf(4);
                    case "V" -> carabiners[0] = String.valueOf(5);
                    case "5" -> numbers[0] = String.valueOf(5);
                    case "VI" -> carabiners[0] = String.valueOf(6);
                    case "6" -> numbers[0] = String.valueOf(6);
                    case "VII" -> carabiners[0] = String.valueOf(7);
                    case "7" -> numbers[0] = String.valueOf(7);
                    case "VIII" -> carabiners[0] = String.valueOf(8);
                    case "8" -> numbers[0] = String.valueOf(8);
                    case "IX" -> carabiners[0] = String.valueOf(9);
                    case "9" -> numbers[0] = String.valueOf(9);
                    case "X" -> carabiners[0] = String.valueOf(10);
                    case "10" -> numbers[0] = String.valueOf(10);
                    default -> throw new Exception("Ошибка ввода данных: первое число не удовлетворяет заданию");
                }
                switch (second) {
                    case "I" -> carabiners[1] = String.valueOf(1);
                    case "1" -> numbers[1] = String.valueOf(1);
                    case "II" -> carabiners[1] = String.valueOf(2);
                    case "2" -> numbers[1] = String.valueOf(2);
                    case "III" -> carabiners[1] = String.valueOf(3);
                    case "3" -> numbers[1] = String.valueOf(3);
                    case "IV" -> carabiners[1] = String.valueOf(4);
                    case "4" -> numbers[1] = String.valueOf(4);
                    case "V" -> carabiners[1] = String.valueOf(5);
                    case "5" -> numbers[1] = String.valueOf(5);
                    case "VI" -> carabiners[1] = String.valueOf(6);
                    case "6" -> numbers[1] = String.valueOf(6);
                    case "VII" -> carabiners[1] = String.valueOf(7);
                    case "7" -> numbers[1] = String.valueOf(7);
                    case "VIII" -> carabiners[1] = String.valueOf(8);
                    case "8" -> numbers[1] = String.valueOf(8);
                    case "IX" -> carabiners[1] = String.valueOf(9);
                    case "9" -> numbers[1] = String.valueOf(9);
                    case "X" -> carabiners[1] = String.valueOf(10);
                    case "10" -> numbers[1] = String.valueOf(10);
                    default -> throw new Exception("Ошибка ввода данных: второе число не удовлетворяет заданию");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка ввода данных: введённые данные не удовлетворяют заданию");
            }
            String chemical = userinfo[1];
            if (carabiners[0] != null & carabiners[1] != null) {
                int x = Integer.parseInt(carabiners[0]);
                int y = Integer.parseInt(carabiners[1]);
                if (Objects.equals(chemical, "+")) {
                    int q = x + y;
                    for (Roman ar : Roman.values())
                        if (ar.ordinal() == q - 1) {
                            return String.valueOf(ar);
                        }
                }
                if (Objects.equals(chemical, "-")) {
                    int z = x - y;
                    if (z == 0 || z < 0) {
                        throw new Exception("Ошибка вычисления: в римской системе нет отрицательных чисел");
                    } else {
                        for (Roman ar : Roman.values())
                            if (ar.ordinal() == z - 1) {
                                return String.valueOf(ar);
                            }
                    }
                }
                if (Objects.equals(chemical, "*")) {
                    int p = x * y;
                    for (Roman ar : Roman.values())
                        if (ar.ordinal() == p - 1) {
                            return String.valueOf(ar);
                        }
                }
                if (Objects.equals(chemical, "/")) {
                    int n = x / y;
                    if (n == 0) {
                        throw new Exception("Ошибка вычисления: в римской системе могут быть только положительные числа");
                    } else {
                        for (Roman ar : Roman.values())
                            if (ar.ordinal() == n - 1) {
                                return String.valueOf(ar);
                            }
                    }
                }
            } else if (numbers[0] != null & numbers[1] != null) {
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                if (Objects.equals(chemical, "+")) {
                    return Integer.toString(x + y);
                }
                if (Objects.equals(chemical, "-")) {
                    return Integer.toString(x - y);
                }
                if (Objects.equals(chemical, "*")) {
                    return Integer.toString(x * y);
                }
                if (Objects.equals(chemical, "/")) {
                    return Integer.toString(x / y);
                } else {
                    throw new Exception("Ошибка ввода данных: знак не удовлетворяет заданию");
                }
            }
            throw new Exception("Ошибка ввода данных: используются одновременно разные системы счисления");
        }
    }
}
