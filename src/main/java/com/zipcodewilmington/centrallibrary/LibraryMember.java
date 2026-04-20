package com.zipcodewilmington.centrallibrary;

import java.util.*;

public class LibraryMember extends Person {
    private String memberId;
    private String membershipDate;
    private List<LibraryItem> borrowedItems;
    private double outstandingFees;
    private String address;

    public LibraryMember(String name, int age, String email, String phoneNumber,
                         String memberId, String membershipDate, String address) {
        super(name, age, email, phoneNumber);
        this.memberId = memberId;
        this.membershipDate = membershipDate;
        this.address = address;
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
    }

    public String getMemberId() { return memberId; }
    public double getOutstandingFees() { return outstandingFees; }

    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems); // protect internal list
    }

    // Borrow item
    public void borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            item.checkOut();
            borrowedItems.add(item);
        }
    }

    // Return item
    public void returnItem(LibraryItem item, int daysLate) {
        if (borrowedItems.contains(item)) {
            item.checkIn();
            borrowedItems.remove(item);

            double fee = calculateLateFee(item, daysLate);
            outstandingFees += fee;
        }
    }

    // Late fee logic (simple version)
    private double calculateLateFee(LibraryItem item, int daysLate) {
        double rate = 0.5; // example: $0.50 per day
        return daysLate > 0 ? daysLate * rate : 0;
    }

    // Pay fees
    public void payFees(double amount) {
        if (amount > 0) {
            outstandingFees -= amount;
            if (outstandingFees < 0) {
                outstandingFees = 0;
            }
        }
    }
}