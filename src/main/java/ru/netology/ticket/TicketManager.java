package ru.netology.ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository = new TicketRepository();

    public void add(Ticket newTicket) {

        repository.save(newTicket);
    }

    public Ticket[] searchByFrom(String from) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, "")) {

                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;

                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] searchByTo(String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, "", to)) {

                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;

                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getAirFrom().contains(from) && ticket.getAirTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }
    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
