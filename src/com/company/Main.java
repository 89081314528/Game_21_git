package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            int karta = (int) (Math.random() * (11 - 2)) + 2;
            System.out.println("Ваша " + i + " карта " + karta + " очков");
            sum = sum + karta;
            System.out.println("Сумма ваших карт " + sum);
            if (sum > 21) {
                System.out.println("Вы проиграли");
                return;
            }
            System.out.println("Если будете брать еще карту, введите да, если нет, введите нет");
            String a = scanner.next();
            if (a.equals("да")) {
            } else {
                break;
            }
        }
//        int kartaKrupie = (int) (Math.random() * (25 - 16)) + 16;
        //работает быстрее
            int kartaKrupie = (int) (ThreadLocalRandom.current().nextInt(16,25));
            System.out.println("У крупье " + kartaKrupie + " очков");
        if (kartaKrupie > 21) {
            System.out.println("У крупье больше 21, перебор, вы выиграли");
            return;
        }
        if (sum > kartaKrupie) {
            System.out.println("У вас больше очков, чем у крупье, Вы выиграли!!!!!!!!!");
            return;
        }
        if (sum < kartaKrupie) {
            System.out.println("У вас меньше очков, чем у крупте, Вы проиграли");
            return;
        } else {
            System.out.println("У вас одинаковое количество очков с крупье, Ничья, попробуйте еще раз");
        }
    }
}
