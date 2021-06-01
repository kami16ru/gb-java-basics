package geekbrains.java_basics.lesson_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваша задача угадать число.");

        int range = 30;
        int randomNumber = (int) (Math.random() * range);

        while (true) {
            System.out.println("Угадайте число от 0 до " + range);

            int inputNumber = scanner.nextInt();
            if (inputNumber == randomNumber) {
                System.out.println("Вы угадали.");
                break;
            } else if (inputNumber > randomNumber) {
                System.out.println("Загаданное число меньше.");
            } else {
                System.out.println("Загаданное число больше.");
            }
        }

        scanner.close();
    }
}
