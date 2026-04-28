import java.util.ArrayList;
import java.util.List;
import com.zipcodewilmington.OneLibrary.Book;
import com.zipcodewilmington.OneLibrary.DVD;
import com.zipcodewilmington.OneLibrary.Periodical;
import com.zipcodewilmington.OneLibrary.LibraryItem;

public class InheritanceTestClass {

    public static void main(String[] args) {

        // Create a list of parent type (polymorphism)
        List<LibraryItem> libraryItems = new ArrayList<>();

        // ------------------ BOOK ------------------
        Book book1 = new Book(
                "1",
                "A Secret Notebook 1",
                "Downtown Branch",
                "Jefferson, Thomas",
                "9780000000001",
                305,
                "Politics");

        // ------------------ DVD ------------------
        DVD dvd1 = new DVD(
                "1",
                "The Secret Promise 1",
                "Main Library - Floor 2",
                "Ethan Donovan",
                120,
                "3.9",
                "Romance");

        // ------------------ PERIODICAL ------------------
        Periodical periodical1 = new Periodical(
                "nla.obj-1001708",
                "Health Forum 1001708",
                "Stacks B",
                "Crown Press",
                "1000-1000",
                24,
                10,
                "1989-12-01");

        // Add all to list
        libraryItems.add(book1);
        libraryItems.add(dvd1);
        libraryItems.add(periodical1);

        // ------------------ TEST INHERITANCE ------------------
        for (LibraryItem item : libraryItems) {

            System.out.println("-------------");
            System.out.println("Title: " + item.getTitle());
            System.out.println("Type: " + item.getItemType());
            System.out.println("Max Borrow Days: " + item.getMaxBorrowDays());

            // Test late fee
            System.out.println("Late Fee (5 days): $" + item.calculateLateFee(5));

            // Test searchable fields
            System.out.println("Searchable Fields:");
            for (String field : item.getSearchableFields()) {
                System.out.println(" - " + field);
            }
        }

        // ------------------ TEST DVD RESERVATION ------------------
        System.out.println("-------------");
        System.out.println("Testing DVD Reservation");

        dvd1.reserve();
        System.out.println("Is Reserved: " + dvd1.isReserved());

        dvd1.cancelReserve();
        System.out.println("Is Reserved after cancel: " + dvd1.isReserved());
    }
}