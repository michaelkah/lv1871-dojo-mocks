package de.lv1871.dojo;

// In dieser Klasse soll nichts geändert werden.
public class MyClass {
    public String myMethod() {
        return "my method!";
    }

    public String myMethodWithArguments(boolean b) {
        return "my method is %s!".formatted(b);
    }

    public static String myStaticMethod() {
        return "my static method!";
    }
}
