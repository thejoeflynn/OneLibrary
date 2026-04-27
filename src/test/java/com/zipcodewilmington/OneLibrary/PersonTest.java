package com.zipcodewilmington.OneLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PersonTest {

class TestPerson extends Person {

    public TestPerson(String name, int age, String email, String phoneNumber) {
        super(name, age, email, phoneNumber);
    }
}

    @Test
    public void testConstructorAndGetters() {
    TestPerson person = new TestPerson("Alice Johnson", 25, "alice@email.com", "555-1234");

    assertEquals("Alice Johnson", person.getName());
    assertEquals(25, person.getAge());
    assertEquals("alice@email.com", person.getEmail());
    assertEquals("555-1234", person.getPhoneNumber());
    }



    @Test
    public void testSetters() {
        TestPerson person = new TestPerson("Old Name", 20, "old@email.com", "000-0000");

        person.setName("Bob Wilson");
        person.setAge(35);
        person.setEmail("bob@email.com");
        person.setPhoneNumber("555-4321");

        assertEquals("Bob Wilson", person.getName());
        assertEquals(35, person.getAge());
        assertEquals("bob@email.com", person.getEmail());
        assertEquals("555-4321", person.getPhoneNumber());
    }
    @Test
    public void testInvalidName() {
        TestPerson person = new TestPerson("Alice Johnson", 25, "alice@email.com", "555-1234");

        person.setName("");

        assertEquals("Alice Johnson", person.getName());
    }

    @Test
    public void testInvalidEmailDoesNotChangeValue() {
        TestPerson person = new TestPerson("Alice Johnson", 25, "alice@email.com", "555-1234");

        person.setEmail(null);

        assertEquals("alice@email.com", person.getEmail());
    }

    @Test
    public void testInvalidAgeDoesNotChangeValue() {
        TestPerson person = new TestPerson("Alice Johnson", 25, "alice@email.com", "555-1234");

        person.setAge(-1);

        assertEquals(25, person.getAge());
    }
}