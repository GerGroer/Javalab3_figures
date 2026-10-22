package app.geometry2d;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    private static final double EPSILON = 1e-9;

    @Test
    void areaOfThreeByFourRectangleIsTwelve() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);

        double actual = rectangle.area();

        assertEquals(12.0, actual, EPSILON);
    }

    @Test
    void perimeterOfThreeByFourRectangleIsFourteen() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);

        double actual = rectangle.perimeter();

        assertEquals(15.0, actual, EPSILON);
    }
}