package com.zipcodewilmington.OneLibrary;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * InheritanceTestClass.java
 *
 * JUnit 4 tests for the inheritance hierarchy of the Central Library system.
 *
 * Covers:
 * - Person -> Librarian and Member (IS-A, inherited fields)
 * - LibraryItem -> Book, DVD, Periodical (IS-A, inherited methods)
 * - Searchable interface on all LibraryItems
 * - Reservable interface on Book and DVD (NOT on Periodical)
 * - Polymorphic method overriding (getItemType, getMaxBorrowDays,
 * calculateLateFee)
 * - Member: borrowItem, returnItem, payFees
 * - Librarian: addItemToLibrary, removeItemFromLibrary
 */
public class InheritanceTestClass {

    private Book book;
    private DVD dvd;
    private Periodical periodical;
    private Librarian librarian;
    private Member alice;
    private Member bob;
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
                "McGraw-Hill, Inc.", "0360-5280", 6, 8, "08/01/1981");

        librarian = new Librarian(
                "Hypatia", 40, "hypatia@library.org", "555-0001",
                "L001", "General", 45000);

        address = new Address("456 Oak St", "Bookville", "MD", "12347");

        alice = new Member("Alice Johnson", 25, "alice@email.com", "555-1234",
                "M001", "2024-01-15", address);

        bob = new Member("Bob Wilson", 35, "bob@email.com", "555-4321",
                "M002", "2024-03-10",
                new Address("654 Maple St", "Media", "PA", "12346"));

        library = new Library("Central Library",
                new Address("123 Main St", "Alexandra", "DE", "12345"));
    }

    // ======================================================================
    // PERSON HIERARCHY
    // ======================================================================

    @Test
    public void testLibrarianIsALibrarian() {
        assertTrue(librarian instanceof Librarian);
    }

    @Test
    public void testLibrarianIsAPerson() {
        assertTrue(librarian instanceof Person);
    }

    @Test
    public void testMemberIsAPerson() {
        assertTrue(alice instanceof Person);
    }

    @Test
    public void testLibrarianInheritsName() {
        assertEquals("Hypatia", librarian.getName());
    }

    @Test
    public void testMemberInheritsName() {
        assertEquals("Alice Johnson", alice.getName());
    }

    @Test
    public void testLibrarianInheritsAge() {
        assertEquals(40, librarian.getAge());
    }

    @Test
    public void testMemberInheritsEmail() {
        assertEquals("alice@email.com", alice.getEmail());
    }

    @Test
    public void testLibrarianInheritsPhone() {
        assertEquals("555-0001", librarian.getPhoneNumber());
    }

    @Test
    public void testLibrarianOwnFields() {
        assertEquals("L001", librarian.getEmployeeId());
        assertEquals("General", librarian.getDepartment());
        assertEquals(45000.0, librarian.getSalary(), 0.01);
    }

    @Test
    public void testMemberOwnFields() {
        assertEquals("M001", alice.getMemberId());
        assertEquals(0.0, alice.getOutstandingFees(), 0.01);
        assertTrue(alice.getBorrowedItems().isEmpty());
    }

    // ======================================================================
    // LIBRARYITEM HIERARCHY — IS-A
    // ======================================================================

    @Test
    public void testBookIsALibraryItem() {
        assertTrue(book instanceof LibraryItem);
    }

    @Test
    public void testDvdIsALibraryItem() {
        assertTrue(dvd instanceof LibraryItem);
    }

    @Test
    public void testPeriodicalIsALibraryItem() {
        assertTrue(periodical instanceof LibraryItem);
    }

    // ======================================================================
    // INHERITED FIELDS FROM LibraryItem
    // ======================================================================

    @Test
    public void testBookInheritsId() {
        assertEquals("B001", book.getId());
    }

    @Test
    public void testBookInheritsTitle() {
        assertEquals("Java Programming", book.getTitle());
    }

    @Test
    public void testBookInheritsLocation() {
        assertEquals("A1", book.getLocation());
    }

    @Test
    public void testBookDefaultAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    public void testDvdInheritsId() {
        assertEquals("D001", dvd.getId());
    }

    // Periodical uses super(id,title,location) constructor
    @Test
    public void testPeriodicalInheritsId() {
        assertEquals("P001", periodical.getId());
    }

    @Test
    public void testPeriodicalInheritsTitle() {
        assertEquals("Byte", periodical.getTitle());
    }

    // ======================================================================
    // INHERITED checkOut / checkIn
    // ======================================================================

    @Test
    public void testBookCheckOut() {
        book.checkOut();
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBookCheckIn() {
        book.checkOut();
        book.checkIn();
        assertTrue(book.isAvailable());
    }

    @Test
    public void testDvdCheckOutAndIn() {
        dvd.checkOut();
        assertFalse(dvd.isAvailable());
        dvd.checkIn();
        assertTrue(dvd.isAvailable());
    }

    @Test
    public void testPeriodicalCheckOut() {
        periodical.checkOut();
        assertFalse(periodical.isAvailable());
    }

    // ======================================================================
    // POLYMORPHISM — getItemType()
    // ======================================================================

    @Test
    public void testBookGetItemType() {
        assertEquals("Book", book.getItemType());
    }

    @Test
    public void testDvdGetItemType() {
        assertEquals("DVD", dvd.getItemType());
    }

    @Test
    public void testPeriodicalGetItemType() {
        assertEquals("Periodical", periodical.getItemType());
    }

    // ======================================================================
    // POLYMORPHISM — getMaxBorrowDays()
    // ======================================================================

    @Test
    public void testBookMaxBorrowDays() {
        assertEquals(14, book.getMaxBorrowDays());
    }

    @Test
    public void testDvdMaxBorrowDays() {
        assertEquals(7, dvd.getMaxBorrowDays());
    }

    @Test
    public void testPeriodicalMaxBorrowDays() {
        assertEquals(7, periodical.getMaxBorrowDays());
    }

    // ======================================================================
    // POLYMORPHISM — calculateLateFee()
    // ======================================================================

    @Test
    public void testBookLateFeeSingleDay() {
        assertEquals(0.50, book.calculateLateFee(1), 0.001);
    }

    @Test
    public void testBookLateFeeMultiDay() {
        assertEquals(1.50, book.calculateLateFee(3), 0.001);
    }

    @Test
    public void testDvdLateFeeSingleDay() {
        assertEquals(1.00, dvd.calculateLateFee(1), 0.001);
    }

    @Test
    public void testDvdLateFeeMultiDay() {
        assertEquals(5.00, dvd.calculateLateFee(5), 0.001);
    }

    @Test
    public void testPeriodicalLateFeeSingleDay() {
        assertEquals(0.25, periodical.calculateLateFee(1), 0.001);
    }

    @Test
    public void testPeriodicalLateFeeMultiDay() {
        assertEquals(0.75, periodical.calculateLateFee(3), 0.001);
    }

    // ======================================================================
    // SEARCHABLE INTERFACE
    // ======================================================================

    @Test
    public void testBookIsSearchable() {
        assertTrue(book instanceof Searchable);
    }

    @Test
    public void testDvdIsSearchable() {
        assertTrue(dvd instanceof Searchable);
    }

    @Test
    public void testPeriodicalIsSearchable() {
        assertTrue(periodical instanceof Searchable);
    }

    @Test
    public void testBookMatchesByTitle() {
        assertTrue(book.matchesKeyword("Java"));
    }

    @Test
    public void testBookMatchesByAuthor() {
        assertTrue(book.matchesKeyword("John"));
    }

    @Test
    public void testBookMatchesByGenre() {
        assertTrue(book.matchesKeyword("Programming"));
    }

    @Test
    public void testBookMatchesByIsbn() {
        assertTrue(book.matchesKeyword("978-1234567890"));
    }

    @Test
    public void testBookCaseInsensitive() {
        assertTrue(book.matchesKeyword("java"));
    }

    @Test
    public void testBookNoMatch() {
        assertFalse(book.matchesKeyword("Wachowski"));
    }

    @Test
    public void testDvdMatchesByTitle() {
        assertTrue(dvd.matchesKeyword("Matrix"));
    }

    @Test
    public void testDvdMatchesByDirector() {
        assertTrue(dvd.matchesKeyword("Wachowski"));
    }

    @Test
    public void testDvdMatchesByGenre() {
        assertTrue(dvd.matchesKeyword("Sci-Fi"));
    }

    @Test
    public void testPeriodicalMatchesByTitle() {
        assertTrue(periodical.matchesKeyword("Byte"));
    }

    @Test
    public void testPeriodicalMatchesByPublisher() {
        assertTrue(periodical.matchesKeyword("McGraw"));
    }

    @Test
    public void testPeriodicalMatchesByIssn() {
        assertTrue(periodical.matchesKeyword("0360-5280"));
    }

    @Test
    public void testMatchesKeywordEmptyReturnsFalse() {
        assertFalse(book.matchesKeyword(""));
    }

    @Test
    public void testMatchesKeywordNullReturnsFalse() {
        assertFalse(book.matchesKeyword(null));
    }

    // ======================================================================
    // RESERVABLE INTERFACE
    // ======================================================================

    @Test
    public void testBookIsReservable() {
        assertTrue(book instanceof Reservable);
    }

    @Test
    public void testDvdIsReservable() {
        assertTrue(dvd instanceof Reservable);
    }

    @Test
    public void testPeriodicalIsNotReservable() {
        assertFalse(periodical instanceof Reservable);
    }

    @Test
    public void testDvdReserve() {
        dvd.reserve();
        assertTrue(dvd.isReserved());
    }

    @Test
    public void testDvdCancelReserve() {
        dvd.reserve();
        dvd.cancelReserve();
        assertFalse(dvd.isReserved());
    }

    @Test
    public void testBookReserveAndCancel() {
        book.reserve();
        assertTrue(book.isReserved());
        book.cancelReserve();
        assertFalse(book.isReserved());
    }

    // ======================================================================
    // LIBRARIAN — addItemToLibrary / removeItemFromLibrary
    // ======================================================================

    @Test
    public void testLibrarianAddsItem() {
        librarian.addItemToLibrary(library, book);
        List<LibraryItem> results = library.search("Java");
        assertFalse(results.isEmpty());
        assertEquals("Java Programming", results.get(0).getTitle());
    }

    @Test
    public void testLibrarianRemovesItem() {
        librarian.addItemToLibrary(library, book);
        librarian.removeItemFromLibrary(library, book);
        assertTrue(library.search("Java").isEmpty());
    }

    // ======================================================================
    // MEMBER — borrowItem / returnItem / payFees
    // ======================================================================

    @Test
    public void testBorrowChecksOutItem() {
        alice.borrowItem(book);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBorrowAddsToList() {
        alice.borrowItem(book);
        assertTrue(alice.getBorrowedItems().contains(book));
    }

    @Test
    public void testCannotBorrowUnavailableItem() {
        book.checkOut();
        alice.borrowItem(book);
        assertFalse(alice.getBorrowedItems().contains(book));
    }

    @Test
    public void testReturnChecksInItem() {
        alice.borrowItem(book);
        alice.returnItem(book, 0);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnRemovesFromList() {
        alice.borrowItem(book);
        alice.returnItem(book, 0);
        assertFalse(alice.getBorrowedItems().contains(book));
    }

    @Test
    public void testReturnAccumulatesLateFee() {
        alice.borrowItem(book);
        alice.returnItem(book, 4); // 4 * $0.50 = $2.00
        assertEquals(2.00, alice.getOutstandingFees(), 0.001);
    }

    @Test
    public void testPayFeesReducesBalance() {
        alice.borrowItem(book);
        alice.returnItem(book, 4); // $2.00
        alice.payFees(1.00);
        assertEquals(1.00, alice.getOutstandingFees(), 0.001);
    }

    @Test
    public void testPayFeesDoesNotGoBelowZero() {
        alice.borrowItem(book);
        alice.returnItem(book, 2); // $1.00
        alice.payFees(999.00);
        assertEquals(0.00, alice.getOutstandingFees(), 0.001);
    }

    // ======================================================================
    // POLYMORPHIC REFERENCE — subclasses treated as LibraryItem
    // ======================================================================

    @Test
    public void testPolymorphicGetItemType() {
        LibraryItem[] items = { book, dvd, periodical };
        String[] expected = { "Book", "DVD", "Periodical" };
        for (int i = 0; i < items.length; i++) {
            assertEquals(expected[i], items[i].getItemType());
        }
    }

    @Test
    public void testPolymorphicCalculateLateFee() {
        LibraryItem[] items = { book, dvd, periodical };
        double[] expected = { 0.50, 1.00, 0.25 };
        for (int i = 0; i < items.length; i++) {
            assertEquals(expected[i], items[i].calculateLateFee(1), 0.001);
        }
    }

    @Test
    public void testLibrarySearchReturnsCorrectItems() {
        library.addItem(book);
        library.addItem(dvd);
        library.addItem(periodical);
        List<LibraryItem> results = library.search("Matrix");
        assertEquals(1, results.size());
        assertEquals("The Matrix", results.get(0).getTitle());
    }
}