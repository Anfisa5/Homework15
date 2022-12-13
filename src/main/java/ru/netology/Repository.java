package ru.netology;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    //метод добавления билета
    public void add(Ticket ticket) {

        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    //метод удаления билета по его уникальному номеру id
    public void removeById(int id) {

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }


    //метод получения набора билетов
    public Ticket[] findAll() {
        return tickets;
    }


    //методы поиска билета по ID
    // public Ticket findById(int id) {
    // for (Ticket ticket : tickets) {
    // if (ticket.getId() == id) {
    //   return ticket;
    //}
    //   }
    //   return null;
    // }
}


