package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            int karta = (int) (Math.random() * (12 - 2)) + 2;
            System.out.println("Ваша " + i + " карта " + karta + " очков");
            sum = sum + karta;
            System.out.println("Сумма ваших карт " + sum);
            if (sum > 21) {
                System.out.println("Вы проиграли");
                return;
            }
            System.out.println("Если будете брать еще карту, введите да");
            String a = scanner.next();
            if (a.equals("да")) {
            } else {
                break;
            }
        }
        int kartaKrupie = (int) (Math.random() * (26 - 16)) + 16;
        System.out.println("У крупье " + kartaKrupie + " очков");
        if (kartaKrupie > 21) {
            System.out.println("У крупье больше 21, вы выиграли");
            return;
        }

        if (sum > kartaKrupie) {
            System.out.println("Вы выиграли!!!!!!!!!");
        }
        if (sum < kartaKrupie) {
            System.out.println("Вы проиграли");
        } else {
            System.out.println("Ничья, попробуйте еще раз");
        }
    }
}
