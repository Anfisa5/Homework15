import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import ru.netology.Manager;
import ru.netology.Repository;
import ru.netology.Ticket;

import javax.management.MBeanServerConnection;

public class ManagerTest {

    @Test
    public void testWhenFewticketsFound() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1, 100, "MSC", "SPB");
        Ticket t2 = new Ticket(2, 600, "MSC", "SPB");
        Ticket t3 = new Ticket(3, 300, "LON", "SPB");
        Ticket t4 = new Ticket(4, 800, "MSC", "SPB");
        Ticket t5 = new Ticket(5, 100, "MSC", "SPB");
        Ticket t6 = new Ticket(6, 500, "MSC", "NSK");
        Ticket t7 = new Ticket(7, 400, "LON", "NSK");
        Ticket t8 = new Ticket(8, 200, "MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
        manager.removeById(t8.getId());

        Ticket[] expected = {t1, t5, t2, t4};
        Ticket[] actual = manager.searchBy("MSC", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenZeroticketsFound() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1, 100, "MSC", "SPB");
        Ticket t2 = new Ticket(2, 600, "MSC", "SPB");
        Ticket t3 = new Ticket(3, 300, "LON", "SPB");
        Ticket t4 = new Ticket(4, 800, "MSC", "SPB");
        Ticket t5 = new Ticket(5, 500, "MSC", "SPB");
        Ticket t6 = new Ticket(6, 500, "MSC", "NSK");
        Ticket t7 = new Ticket(7, 400, "LON", "NSK");
        Ticket t8 = new Ticket(8, 200, "MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("MSC", "LON");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOneticketFound() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket t1 = new Ticket(1, 100, "MSC", "SPB");
        Ticket t2 = new Ticket(2, 600, "MSC", "SPB");
        Ticket t3 = new Ticket(3, 300, "LON", "SPB");
        Ticket t4 = new Ticket(4, 800, "MSC", "SPB");
        Ticket t5 = new Ticket(5, 500, "MSC", "SPB");
        Ticket t6 = new Ticket(6, 500, "MSC", "NSK");
        Ticket t7 = new Ticket(7, 400, "LON", "NSK");
        Ticket t8 = new Ticket(8, 200, "MSC", "SPB");

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t3};
        Ticket[] actual = manager.searchBy("LON", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }
}