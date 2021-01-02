package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student firstStudent = new Student();
        firstStudent.setFullName("Пупкин Василий Олегович");
        firstStudent.setGroup("1а");
        firstStudent.setEntranceDate(new Date());
        System.out.printf(
                "Студент %s из группы: %s, поступил: %tF",
                firstStudent.getFullName(),
                firstStudent.getGroup(),
                firstStudent.getEntranceDate());
    }
}
