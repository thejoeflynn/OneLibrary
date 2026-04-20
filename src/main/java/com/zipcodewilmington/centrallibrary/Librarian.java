package com.zipcodewilmington.centrallibrary;

public class Librarian extends Person {
    private String employeeId;
    private String department;
    private double salary;

    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void addItemToLibrary(Library library, LibraryItem item) {
        library.addItem(item);
    }

    public void removeItemFromLibrary(Library library, LibraryItem item) {
        library.removeItem(item);
    }
}
