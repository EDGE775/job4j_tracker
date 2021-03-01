package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("Clean code", 464);
        Book bookTwo = new Book("Идеальный программист", 214);
        Book bookThree = new Book("Грокаем алгоритмы", 242);
        Book bookFour = new Book("Самоучитель по Java", 1213);
        Book[] books = {bookOne, bookTwo, bookThree, bookFour};
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.printf("%s - %d" + System.lineSeparator(), book.getName(), book.getPages());
        }

        System.out.println(System.lineSeparator() + "Переставьте местами книги с индексом 0 и 3:");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.printf("%s - %d" + System.lineSeparator(), book.getName(), book.getPages());
        }

        System.out.println(System.lineSeparator() + "Цикл с выводом книг с именем \"Clean code\":");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean code")) {
                System.out.printf("%s - %d" + System.lineSeparator(),
                        book.getName(),
                        book.getPages());
            }
        }
    }
}
