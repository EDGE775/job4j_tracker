package ru.job4j.stream;

import java.util.Date;

public class Ticket {
    private String from;
    private String into;
    private Date leavingTime;
    private Date arriveTime;
    private double price;
    private String company;
    private boolean petAvailable;

    static class Builder {
        private String from;
        private String into;
        private Date leavingTime;
        private Date arriveTime;
        private double price;
        private String company;
        private boolean petAvailable;

        Ticket build() {
            Ticket ticket = new Ticket();
            ticket.from = from;
            ticket.into = into;
            ticket.leavingTime = leavingTime;
            ticket.arriveTime = arriveTime;
            ticket.price = price;
            ticket.company = company;
            ticket.petAvailable = petAvailable;
            return ticket;
        }

        Builder buildFrom(String from) {
            this.from = from;
            return this;
        }

        Builder buildInto(String into) {
            this.into = into;
            return this;
        }

        Builder buildLeavingTime(Date leavingTime) {
            this.leavingTime = leavingTime;
            return this;
        }

        Builder buildArriveTime(Date arriveTime) {
            this.arriveTime = arriveTime;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        Builder buildCompany(String company) {
            this.company = company;
            return this;
        }

        Builder buildPetAvailable(boolean petAvailable) {
            this.petAvailable = petAvailable;
            return this;
        }
    }
}
