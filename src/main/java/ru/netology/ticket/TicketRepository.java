package ru.netology.ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket newTicket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];

        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newTicket;

        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
