package com.zipcodewilmington.OneLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// import java.beans.Transient;

public class AddressTest {

    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St" , "Alexandria" , "DE" , "12345");

        assertEquals("123 Main St", address.getStreet());
        assertEquals("Alexandria", address.getCity());
        assertEquals("DE", address.getState());
        assertEquals("12345", address.getZipCode());
    }

    @Test
    public void testSetters(){
        Address address = new Address("Old St", "Old City", "MD", "11111");

        address.setStreet("456 Oak St");
        address.setCity("Bookville");
        address.setState("PA");
        address.setZipCode("22222");

        assertEquals("456 Oak St", address.getStreet());
        assertEquals("Bookville", address.getCity());
        assertEquals("PA", address.getState());
        assertEquals("22222", address.getZipCode());

    }

    @Test

public void testInvalidStreetDoesNotChangeValue() {
    Address address = new Address("123 Main St", "Alexandria", "DE", "12345");

    address.setStreet(""); //invalid

    assertEquals("123 Main St", address.getStreet());
}

    @Test
    public void testInvalidCityDoesNotChange() {
    Address address = new Address("123 Main St", "Alexandria", "DE", "12345");

    address.setCity(null); //invalid

    assertEquals("Alexandria", address.getCity());
    }
}