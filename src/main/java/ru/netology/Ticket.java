package ru.netology;

public class Ticket implements Comparable<Ticket> {

    //Класс для информации о билете

    private int id; //ID билета
    private int price; //стоимость билета
    private String from;  //Аэропорт вылета
    private String to;   //Аэропорт прилёта
    //private int time; //Время в пути в минутах

    public Ticket(int id, int price, String from, String to) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {
    // this.id = id;
    // }

    public int getPrice() {
        return price;
    }

    // public void setPrice(int price) {
    // this.price = price;
    // }

    public String getFrom() {
        return from;
    }

    //public void setFrom(String from) {
    // this.from = from;
    // }

    public String getTo() {
        return to;
    }

    //public void setTo(String to) {
    //this.to = to;
    // }


    //Идея сама сгенерирует заглушку для нужного метода из этого интерфейса, которая всегда возвращает 0.
    //надо переписать тело сгенерированного метода:
    //чтобы если билет, у которого вызвали метод compareTo, стоит дешевле, чем тот,
    //который передали через параметр, то возвращалось бы число меньше нуля.
    //Если же билет, наоборот, дороже, то число больше нуля, а если стоимость одинакова, то 0.

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
