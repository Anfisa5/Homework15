package ru.netology;

import java.util.Arrays;

public class Manager {

    private Repository repo;


    public Manager(Repository repo) {

        this.repo = repo;
    }


    //метод добавления билетов в репозиторий
    public void add(Ticket ticket) {

        repo.add(ticket);
    }


    //методе удаления removeById
    public void removeById(int id) {

        repo.removeById(id);
    }

    //метод findAll: должен принимать два параметра: from — аэропорта вылета, to — аэропорт прилёта
    //В результате поиска возвращается массив только с теми билетами, что соответствуют условиям поиска.
    //метод searchBy(String from, String to), который возвращает массив найденных товаров
    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getTo().equals(to)) {
            if (ticket.getFrom().equals(from)) {
                return true;
            }
        }
        return false;
    }
}

