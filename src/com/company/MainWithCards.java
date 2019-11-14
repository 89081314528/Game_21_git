package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainWithCards {
    public static void main (String[] args) {
        List<Integer> cardDeck = new ArrayList<>();
        for (int i = 2; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck.add(i);
            }
        }
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck.add(i);
            }
        }
        Collections.shuffle(cardDeck);
        System.out.println(cardDeck);
        System.out.println("Ваша первая карта " + cardDeck.get(0) + " очков");
        int sum = cardDeck.get(0);
        int j = 0;
        for (int i = 2; i < 11; i++) {
            System.out.println("Если будете брать еще карту, введите да");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if(answer.equals("да")) {
                sum = sum + cardDeck.get(i - 1);
                System.out.println("Ваша " + i + " карта равна " + cardDeck.get(i - 1) + ". Сумма Ваших карт равна " + sum);
                j = i - 1;
                if (sum > 21) {
                    System.out.println("Вы проиграли");
                    return;
                }
            } else {
                System.out.println("Ход переходит к крупье");
                break;
            }
        }
        System.out.println("Ваша первая карта " + cardDeck.get(j + 1) + " очков");
        int sumKrupie = cardDeck.get(j + 1);
        for (int i = j + 2; i < j + 2 + 9; i++) {
            System.out.println("Если будете брать еще карту, введите да");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equals("да")) {
                sumKrupie = sumKrupie + cardDeck.get(i);
                System.out.println("Ваша " + (i - j) + " карта равна " + cardDeck.get(i) + ". Сумма Ваших карт равна " + sumKrupie);
                if (sum > 21) {
                    System.out.println("Вы проиграли");
                    return;
                }
            } else {
                System.out.println("Сравниваем очки игрока и очки крупье. У игрока " + sum + " очков. У крупье " + sumKrupie);
                break;
            }
        }
        if (sum > sumKrupie) {
            System.out.println("Победил игрок");
            return;
        }
        if (sum == sumKrupie) {
            System.out.println("Ничья");
            return;
        }
            System.out.println("Победил крупье");
    }
}
