package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**добавить искуственный интеллект двоим игрокам - 16 и 17
 * провести 1 000 000 игр и посчитать статистику, кто выигрывает
 * посчитать статистику зависимости выигрыша от удачи и от интеллекта
 * и написать игру угадай число с искуственным интеллектом, который перебирает числа от 1 до млн с бесконечным количеством
 * попыток. и считаем статистику, с какой попытки угадывает
 */

public class MainWithCards {
    public static void main(String[] args) {
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
        int countGames = 1_000_000;
        for (int p = 14; p < 18; p++) {
            for (int k = 14; k < 19; k++) {
                int countWinsKrupie = 0;
                int countWinsKrupieluck = 0;
                int countWinsPlayer = 0;
                int countWinsPlayerluck = 0;
                for (int a = 0; a < countGames; a++) {
                    Collections.shuffle(cardDeck);
//            System.out.println(cardDeck);
//            System.out.println("Ваша первая карта " + cardDeck.get(0) + " очков");
                    int sum = cardDeck.get(0);
                    int j = 0;
                    for (int i = 2; i < 11; i++) {
                        sum = sum + cardDeck.get(i - 1);
//                System.out.println("Ваша " + i + " карта равна " + cardDeck.get(i - 1) + ". Сумма Ваших карт равна " + sum);
                        j = i - 1;
                        if (sum > 21) {
//                    System.out.println("Игрок проиграл, победил крупье");
                            countWinsKrupie = countWinsKrupie + 1;
                            countWinsKrupieluck = countWinsKrupieluck + 1;
                            break;
                        }
                        if (sum >= p) {
//                    System.out.println("Сумма ваших очков больше или равна 16, не рекомендуем больше брать карты. Ход переходит к крупье");
                            break;
                        }
                    }
                    int sumKrupie = cardDeck.get(j + 1);
                    if (sum <= 21) {
//                System.out.println("Ваша первая карта " + cardDeck.get(j + 1) + " очков");
                        for (int i = j + 2; i < j + 2 + 9; i++) {
                            sumKrupie = sumKrupie + cardDeck.get(i);
//                    System.out.println("Ваша " + (i - j) + " карта равна " + cardDeck.get(i) + ". Сумма Ваших карт равна " + sumKrupie);
                            if (sumKrupie > 21) {
//                        System.out.println("Крупье проиграл, победил игрок");
                                countWinsPlayer = countWinsPlayer + 1;
                                countWinsPlayerluck = countWinsPlayerluck + 1;
                                break;
                            }
                            if (sumKrupie >= k) {
//                        System.out.println("Сумма ваших очков больше или равна 17, не рекомендуем больше брать карты");
                                break;
                            }
                        }
                    }
                    if ((sum > sumKrupie) && (sum <= 21) && (sumKrupie <= 21)) {
//                System.out.println("Победил игрок");
                        countWinsPlayer = countWinsPlayer + 1;
                    }
                    if ((sum == sumKrupie) && (sum <= 21) && (sumKrupie <= 21)) {
//                System.out.println("Ничья");
                    }
                    if ((sum < sumKrupie) && (sum <= 21) && (sumKrupie <= 21)) {
//                System.out.println("Победил крупье");
                        countWinsKrupie = countWinsKrupie + 1;
                    }
                }
                System.out.println("После " + countGames + " игр c остановкой на " + p + " очках у игрока и " +
                        k + " очках у крупье " + "количество побед игрока " + countWinsPlayer +
                        " Количество побед крупье " + countWinsKrupie + " в т. ч. переборов у игрока " + countWinsKrupieluck +
                        " и переборов у крупье " + countWinsPlayerluck);
            }
        }
    }
}