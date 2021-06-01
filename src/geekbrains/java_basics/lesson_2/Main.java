package geekbrains.java_basics.lesson_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    System.out.println("Введите число: ");
//
//        Scanner scanner = new Scanner(System.in);
//
//        int a = 0;
//
//        try {
//            a = scanner.nextInt();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
//        System.out.println("a = " + a);

        System.out.println("Введите операцию: ");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычетание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Деление");

        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();

        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();

        int sum = 0;

        switch (operation) {
            case 1: {
                sum = a + b;
                break;
            }
            case 2: {
                sum = Math.abs(a - b);
                break;
            }
            case 3: {
                sum = a * b;
                break;
            }
            case 4: {
                if (a == 0 || b == 0) {
                    System.out.println("Деление на ноль невозможно!");
                    break;
                }
                if (a > b) sum = a / b;
                else sum = b / a;
                break;
            }
            default: System.out.println("Вы ввели неверную операцию!");
        }

        System.out.println(sum);
    }
}
