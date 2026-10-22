package app.geometry3d;

import app.geometry2d.Circle;
import app.geometry2d.Figure;
import app.exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    private static final double EPSILON = 1e-9;
    private static final double PI = Math.PI;

    @Test
    void shouldCalculateVolumeCorrectly() {
        Figure base = new Circle(2.0);
        double height = 5.0;
        Cylinder cylinder = new Cylinder(base, height);
        double expectedVolume = 20.0 * PI;
        assertEquals(expectedVolume, cylinder.volume(), EPSILON);
    }

    @Test
    void shouldReturnCorrectGetters() {
        Figure base = new Circle(3.0);
        double height = 7.0;
        Cylinder cylinder = new Cylinder(base, height);
        assertSame(base, cylinder.getBase());
        assertEquals(height, cylinder.getHeight(), EPSILON);
    }

    @Test
    void shouldReturnCorrectToString() {
        Figure base = new Circle(2.0);
        Cylinder cylinder = new Cylinder(base, 5.0);
        String expectedString = "Цилиндр: основание = " + base.toString() + ", высота = 5.0";
        assertEquals(expectedString, cylinder.toString());
    }

    @Test
    void shouldThrowExceptionWhenBaseIsNull() {
        InvalidParameterException exception = assertThrows(
                InvalidParameterException.class,
                () -> new Cylinder(null, 5.0)
        );
        assertTrue(exception.getMessage().contains("Основание не должно быть null"));
    }

    @Test
    void shouldThrowExceptionWhenHeightIsNegativeOrZero() {
        Figure base = new Circle(2.0);
        assertThrows(InvalidParameterException.class, () -> new Cylinder(base, -1.0));
        assertThrows(InvalidParameterException.class, () -> new Cylinder(base, 0.0));
        assertThrows(InvalidParameterException.class, () -> new Cylinder(base, Double.POSITIVE_INFINITY));
    }
}