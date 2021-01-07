package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = in.nextLine();
        int answer = new Random().nextInt(3);
        String rsl;
        switch (answer) {
            case (0):
                rsl = "Да";
                break;
            case (1):
                rsl = "Нет";
                break;
            default:
                rsl = "Может быть";
                break;
        }
        System.out.println(rsl);
    }
}
