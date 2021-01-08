package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        int user = 1;
        int winner = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 11!");
        while (matches > 0) {
            System.out.printf("Игрок №%d, ваш ход! Возьмите от 1 до 3 спичек: ", user);
            int match = Integer.valueOf(in.nextLine());
            if (match < 4 && match >0) {
                matches -= match;
                System.out.printf("Осталось %d спичек" + System.lineSeparator(), matches);
                winner = user;
                user = user == 2 ? 1 : 2;
                System.out.println();
            } else {
                System.out.println("Количество спичек должно быть от 1 до 3! Повторите попытку!");
            }
        }
        System.out.printf("Победил игрок №%d!", winner);
    }
}
