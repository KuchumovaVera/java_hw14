package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket ticket1 = new Ticket(123, 5000, "MOW", "KUF", 100);
    Ticket ticket2 = new Ticket(234, 8000, "LED", "EGO", 300);
    Ticket ticket3 = new Ticket(345, 5000, "MOW", "KUF", 100);
    Ticket ticket4 = new Ticket(567, 6000, "LED", "FRU", 150);
    Ticket ticket5 = new Ticket(678, 7000, "GOJ", "MOW", 200);

    @Test
    void shouldAdd() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("", "");
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTo() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchByTo("KUF");
        Ticket[] expected = {ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFrom() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchByFrom("LED");
        Ticket[] expected = {ticket2, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("MOW", "KUF");
        Ticket[] expected = {ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        manager.removeById(123);
        manager.removeById(567);

        Ticket[] actual = manager.findAll("", "");
        Ticket[] expected = {ticket3, ticket5, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }


}


