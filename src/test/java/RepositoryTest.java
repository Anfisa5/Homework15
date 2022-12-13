import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Repository;
import ru.netology.Ticket;

public class RepositoryTest {
    Ticket t1 = new Ticket(1, 100, "MSC", "SPB");
    Ticket t2 = new Ticket(2, 600, "MSC", "SPB");
    Ticket t3 = new Ticket(3, 300, "LON", "SPB");
    Ticket t4 = new Ticket(4, 800, "MSC", "SPB");
    Ticket t5 = new Ticket(5, 500, "MSC", "SPB");
    Ticket t6 = new Ticket(6, 500, "MSC", "NSK");
    Ticket t7 = new Ticket(7, 400, "LON", "NSK");
    Ticket t8 = new Ticket(8, 200, "MSC", "SPB");

        @Test
        public void test1() {
            Repository repo = new Repository();

            repo.add(t1);
            repo.add(t2);
            repo.add(t3);
            repo.add(t4);
            repo.add(t5);
            repo.add(t6);
            repo.add(t7);
            repo.add(t8);

            repo.removeById(2);
            repo.removeById(6);

            Ticket[] expected = {t1, t3, t4, t5, t7, t8};
            Ticket[] actual = repo.findAll();
            Assertions.assertArrayEquals(expected, actual);
        }

    }

