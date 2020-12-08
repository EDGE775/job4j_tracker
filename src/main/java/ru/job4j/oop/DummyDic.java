package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic dict = new DummyDic();
        String rsl = dict.engToRus("Hi!");
        System.out.println(rsl);
    }
}
