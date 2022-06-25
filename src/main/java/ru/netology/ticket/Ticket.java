package ru.netology.ticket;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airFrom;
    private String airTo;
    private int time;

    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }
}
