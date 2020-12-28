package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport jsonReport = new JSONReport();
        String text = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
