package com.zipcodewilmington.OneLibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items;
    private List<Member> members;
    private List<Librarian> librarians;

    public Library () {
        items = new ArrayList<>();
        members = new ArrayList<>();
        librarians = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public List<LibraryItem> search(String keyword) {
        List<LibraryItem> results = new ArrayList<>();
        for(LibraryItem item : items){
            if(item.matchesKeyword(keyword)){
            results.add(item);
            }
        }
        return results;
    }

    public void display() {
        for(LibraryItem item : items) {
            String type = item.getItemType();
            String title = item.getTitle();
            String availability = item.isAvailable() ? "Available" : "Unavailable";
            System.out.println(type + " " + title + " - " + availability);
        }
    }

    public void lateReport() {
        int daysLate = 3;
        
        for(Member member : members) {
            System.out.println(member.getName());
            for(LibraryItem item : member.getBorrowedItems()) {
                String type = item.getItemType();
<<<<<<< HEAD
                int maxDays = item.getMaxBorrowDays();
=======
                int axDays = item.getMaxBorrowDays();
>>>>>>> b4c948e (Updated Libary maxDays)
                double lateFees = item.calculateLateFee(daysLate);
                System.out.println(type + " | Max Days: " + maxDays + " | Fee: " + lateFees);
            }
        }
    }


}
