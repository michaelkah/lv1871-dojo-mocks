package de.lv1871.dojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// In dieser Klasse soll nichts geändert werden, außer die Mock-API wird geändert.
class MainTest {

    @Test
    void myMethod() {
        assertEquals("my method!", new Main().myMethod(true));
    }

    @Test
    void myMethodMocked() {
        Main main = new Main();
        // TODO uncomment
        // EllFauhMock.when(main.myMethod(EllFauhMock.any())).thenReturn("mock!");

        assertEquals("mock!", main.myMethod(true));
    }

    @Test
    void myMethodMocked2() {
        assertEquals("false mock!", new Main().myMethod(false));
    }

    @Test
    void myStaticMethod() {
        assertEquals("my static method!", Main.myStaticMethod(true));
    }

    @Test
    void myStaticMethodMocked() {
        // TODO uncomment
        // EllFauhMock.mockStatic(Main.class).when(Main::myStaticMethod).thenReturn("static mock!");

        assertEquals("static mock!", new Main().myMethod(true));
    }

    @Test
    void myStaticMethodMocked2() {
        assertEquals("false static mock!", new Main().myMethod(false));
    }
}
