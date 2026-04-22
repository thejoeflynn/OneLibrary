package com.zipcodewilmington.OneLibrary;

public class Periodical extends LibraryItem {

    private String publisher;
    private String issn;
    private int volume; // fields or details about the periodical class
    private int issueNumber;
    private String publicationDate;

    // need this, put have it commented out in LibraryItem class until we can get it
    // fixed correctly in LibraryItem class
    public Periodical(String id, String title, String location, String publisher, String issn, int volume,
            int issueNumber, String publicationDate) {
        super(id, title, location); // gets these fields from LibraryItem class
        this.publisher = publisher;
        this.issn = issn;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "Periodical";
    }

    @Override
    public String[] getSearchableFields() {
        return new String[] { getTitle(), publisher, issn };
    }

    @Override
    public boolean matchesKeyword(String keyword) {
        for (String field : getSearchableFields()) { // checks for the keywords ignoring case sensitivity
            if (field.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
