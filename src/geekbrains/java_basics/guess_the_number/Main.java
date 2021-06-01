package geekbrains.java_basics.guess_the_number;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число.");

        int range = 30;
        for(int i = 10; i <= range; i += 10) {
            playLevel(i);
        }

        System.out.println("Вы выйграли!!!.");

        scanner.close();
    }

    private static void playLevel(int range) {
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
    }
}
