
import org.example.TaxiService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateFareTest {
    @Test
    public void calculateFareBasicTest() {
        //Основний тест для обчислення вартості
        double distance = 10.0;
        double time = 15.0;
        double expectedFare = 30.0 + (10.0 * 10.0) + (15.0 * 2.0); //160
        double actualFare = TaxiService.calculateFare(distance, time);
        Assertions.assertEquals(expectedFare, actualFare);
    }

    @Test
    public void calculateFareZeroDistanceAndTimeTest() {
        //Тест для нульової відстані та часу
        double distance = 0.0;
        double time = 0.0;
        double expectedFare = 30.0; //Лише базова вартість
        double actualFare = TaxiService.calculateFare(distance, time);
        Assertions.assertEquals(expectedFare, actualFare);
    }

    @Test
    public void calculateFareNegativeValuesTest() {
        //Тест для негативних значень відстані та часу
        double distance = -5.0;
        double time = -10.0;

        //Метод повинен кидати IllegalArgumentException для негативних значень
        Assertions.assertThrows(IllegalArgumentException.class, () -> TaxiService.calculateFare(distance, time));
    }

    @Test
    public void calculateFareLargeValuesTest() {
        //Тест для великих значень
        double distance = 1000.0;
        double time = 600.0;
        double expectedFare = 30.0 + (1000.0 * 10.0) + (600.0 * 2.0); //11230
        double actualFare = TaxiService.calculateFare(distance, time);
        Assertions.assertEquals(expectedFare, actualFare);
    }

}
