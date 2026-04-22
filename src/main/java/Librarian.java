import com.zipcodewilmington.centrallibrary.LibraryItem;
import com.zipcodewilmington.centrallibrary.Person;

public class Librarian extends Person {

    private String employeeId;
    private String department;
    private double salary;

    public Librarian(String name, int age, String email, String phone,
            String employeeId, String department, double salary) {
        super(name, age, email, phone);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public void addItemToLibrary(Library library, LibraryItem item) {
        library.addItem(item);
    }

    public void removeItemFromLibrary(Library library, LibraryItem item) {
        library.removeItem(item);
    }
}
