package de.lv1871.dojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

// In dieser Klasse sollen die bestehenden Tests nicht geändert werden.
class MyClassTest {
    @Test
    void call_original_myMethod_withoutArgument() {
        assertEquals("my method!", new MyClass().myMethod());
    }

    @Test
    void call_original_myMethod_withArgument_true() {
        assertEquals("my method is true!", new MyClass().myMethodWithArguments(true));
    }

    @Test
    void call_original_myMethod_withArgument_false() {
        assertEquals("my method is false!", new MyClass().myMethodWithArguments(false));
    }

    @Test
    void call_mocked_myMethod_withoutArgument() {
        MyClass myClassMock = mock();
        when(myClassMock.myMethod()).thenReturn("mock!");

        assertEquals("mock!", myClassMock.myMethod());
    }

    @Test
    void call_ellfauhmocked_myMethod_withoutArgument() {
        // TODO dieser Test schlägt zu Beginn fehl --> Implementierung in EllFauhMock vervollständigen!
        MyClass myClassMock = EllFauhMock.mock(MyClass.class, "myMethod", "ellfauh mock!");

        assertEquals("ellfauh mock!", myClassMock.myMethod());
    }

    @Test
    void call_mocked_myMethod_withVaryingArguments() {
        MyClass myClassMock = mock();
        when(myClassMock.myMethodWithArguments(true)).thenReturn("true mock!");
        when(myClassMock.myMethodWithArguments(false)).thenReturn("false mock!");

        assertEquals("true mock!", myClassMock.myMethodWithArguments(true));
        assertEquals("false mock!", myClassMock.myMethodWithArguments(false));
    }

    // TODO obige Test-Methode duplizieren und mit EllFauhMock implementieren!

    @Test
    void call_mocked_myMethod_and_verify_calls() {
        MyClass myClassMock = mock();

        myClassMock.myMethod();
        myClassMock.myMethod();

        verify(myClassMock, times(2)).myMethod();
        verify(myClassMock, never()).myMethodWithArguments(anyBoolean());
    }

    // TODO obige Test-Methode duplizieren und mit EllFauhMock implementieren!

    @Test
    void call_original_myStaticMethod() {
        assertEquals("my static method!", MyClass.myStaticMethod());
    }

    // TODO obige Test-Methode duplizieren und mit EllFauhMock implementieren!

    @Test
    void call_mocked_myStaticMethod() {
        try (MockedStatic<MyClass> myClassStaticMock = mockStatic(MyClass.class)) {
            myClassStaticMock.when(MyClass::myStaticMethod).thenReturn("static mock!");
            assertEquals("static mock!", MyClass.myStaticMethod());
        }
    }

    // TODO obige Test-Methode duplizieren und mit EllFauhMock implementieren!

    // TODO weitere, beliebige Mockito-Features in EllFauhMock nachimplementieren!
}
