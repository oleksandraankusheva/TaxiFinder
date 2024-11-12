import org.example.Taxi;
import org.example.Point;
import org.example.Order;
import org.example.TaxiFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaxiFinderTest {
    @Test
    public void calculateDistanceTest() {
        //Тест на правильність обчислення дистанції
        Point order = new Point(2, 3);
        Point taxi = new Point(5, 1);
        double value = TaxiFinder.calculateDistance(order, taxi);
        Assertions.assertEquals(3.606, value, 0.001);
    }

    @Test
    public void negativeValuesTest() {
        //Перевірка класу Point на виняток IllegalArgumentException, коли координати мають від'ємні значення
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Point(-1, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Point(5, -1));
    }

    @Test
    public void findNearestTaxiTest() {
        //Тест чи правильно вираховується найближче таксі
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(0, 0)));
        taxis.add(new Taxi(2, new Point(3, 4)));
        taxis.add(new Taxi(3, new Point(5, 1)));

        Order order = new Order(new Point(1, 1));

        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);

        // Перевірка, що найближче таксі — це таксі 1
        Assertions.assertEquals(1, nearestTaxi.id);
    }

    @Test
    public void findNearestTaxiEmptyListTest() {
        //Тест на порожній список таксі
        List<Taxi> taxis = new ArrayList<>();
        Order order = new Order(new Point(1, 1));
        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);
        Assertions.assertNull(nearestTaxi, "Очікується, що не знайдеться таксі, коли список порожній.");
    }

    @Test
    public void findNearestTaxiTieTest() {
        //Тест з нульовою відстанню від замовлення
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(0, 0))); // Відстань до (1, 1) = √2
        taxis.add(new Taxi(2, new Point(1, 1))); // Відстань до (1, 1) = 0

        Order order = new Order(new Point(1, 1));
        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);

        //Очікується, що таксі 2 буде найближчим, оскільки воно знаходиться на місці замовлення
        Assertions.assertEquals(2, nearestTaxi.id);
    }

    @Test
    public void findNearestTaxiSameDistanceTest() {
        //Тест на ситуацію, коли кілька таксі на однаковій відстані від замовлення
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(2, 2))); // Відстань до (1, 1) ≈ 1.414
        taxis.add(new Taxi(3, new Point(2, 2))); // Відстань до (1, 1) ≈ 1.414

        Order order = new Order(new Point(1, 1));
        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);

        //Очікується, що таксі 1 буде найближчим, оскільки воно знаходиться першим у списку з однаковою відстанню
        Assertions.assertEquals(1, nearestTaxi.id);
    }


}
