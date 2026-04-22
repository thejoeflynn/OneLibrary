package com.zipcodewilmington.OneLibrary;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class InheritanceTestClass {

    private Book book;
    private DVD dvd;
    private Periodical periodical;
    private Librarian librarian;
    private Member member;
    private Library library;
    private Address address;

    @Before
    public void setUp() {

        book = new Book(
                "B001", "Java Programming", "A1",
                "John Doe", "978-1234567890", 500, "Programming");

        dvd = new DVD(
                "D001", "The Matrix", "D1",
                "Wachowski Sisters", 136, "R", "Sci-Fi");

        periodical = new Periodical(
                "P001", "Byte", "P1",
                "McGraw-Hill", "0360-5280", 6, 8, "08/01/1981");

        librarian = new Librarian(
                "Hypatia", 40,
                "hypatia@library.org", "555-0001",
                "L001", "General", 45000);

        address = new Address(
                "456 Oak St", "Bookville", "MD", "12347");

        member = new Member(
                "Alice Johnson", 25,
                "alice@email.com", "555-1234",
                "M001", "2024-01-15", address);

        library = new Library();
    }

    // ===============================
    // INHERITANCE CHECKS
    // ===============================

    @Test
    public void testBookIsLibraryItem() {
        assertTrue(book instanceof LibraryItem);
    }

    @Test
    public void testDvdIsLibraryItem() {
        assertTrue(dvd instanceof LibraryItem);
    }

    @Test
    public void testPeriodicalIsLibraryItem() {
        assertTrue(periodical instanceof LibraryItem);
    }

    @Test
    public void testMemberIsPerson() {
        assertTrue(member instanceof Person);
    }

    @Test
    public void testLibrarianIsPerson() {
        assertTrue(librarian instanceof Person);
    }

    // ===============================
    // POLYMORPHISM
    // ===============================

    @Test
    public void testItemTypes() {
        assertEquals("book", book.getItemType());
        assertEquals("DVD", dvd.getItemType());
        assertEquals("Periodical", periodical.getItemType());
    }

    @Test
    public void testMaxBorrowDays() {
        assertEquals(14, book.getMaxBorrowDays());
        assertEquals(7, dvd.getMaxBorrowDays());
        assertEquals(7, periodical.getMaxBorrowDays());
    }

    @Test
    public void testLateFees() {
        assertEquals(0.50, book.calculateLateFee(1), 0.001);
        assertEquals(1.00, dvd.calculateLateFee(1), 0.001);
        assertEquals(0.25, periodical.calculateLateFee(1), 0.001);
    }

    // ===============================
    // CHECK IN / OUT
    // ===============================

    @Test
    public void testCheckOutAndCheckIn() {
        book.checkOut();
        assertFalse(book.isAvailable());

        book.checkIn();
        assertTrue(book.isAvailable());
    }

    // ===============================
    // SEARCH
    // ===============================

    @Test
    public void testSearchBook() {
        assertTrue(book.matchesKeyword("Java"));
        assertTrue(book.matchesKeyword("John"));
        assertFalse(book.matchesKeyword("Matrix"));
    }

    @Test
    public void testSearchDvd() {
        assertTrue(dvd.matchesKeyword("Matrix"));
        assertTrue(dvd.matchesKeyword("Sci-Fi"));
    }

    // ===============================
    // MEMBER FUNCTIONS
    // ===============================

    @Test
    public void testBorrowAndReturn() {
        member.borrowItem(book);
        assertFalse(book.isAvailable());

        member.returnItem(book, 2);
        assertTrue(book.isAvailable());
        assertEquals(1.0, member.getOutstandingFees(), 0.001);
    }

    @Test
    public void testPayFees() {
        member.borrowItem(book);
        member.returnItem(book, 2);

        member.payFees(1.0);
        assertEquals(0.0, member.getOutstandingFees(), 0.001);
    }

    // ===============================
    // LIBRARY FUNCTIONS
    // ===============================

    @Test
    public void testAddAndSearchLibrary() {
        librarian.addItemToLibrary(library, book);

        List<LibraryItem> results = library.search("Java");
        assertFalse(results.isEmpty());
    }

    @Test
    public void testRemoveItemFromLibrary() {
        librarian.addItemToLibrary(library, book);
        librarian.removeItemFromLibrary(library, book);

        List<LibraryItem> results = library.search("Java");
        assertTrue(results.isEmpty());
    }
}