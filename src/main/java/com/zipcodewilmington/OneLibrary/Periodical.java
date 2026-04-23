package com.zipcodewilmington.OneLibrary;


public class Periodical extends LibraryItem {

    private String publisher; 
    private String issn; 
    private int volume;                  
    private int issueNumber; 
    private String publicationDate; 


    public Periodical(String id, String title, String location, String publisher, String issn, int volume, int issueNumber, String publicationDate) {
        super(id, title, location);       
        this.publisher = publisher; 
        this.issn = issn; 
        this.volume = volume; 
        this.issueNumber = issueNumber; 
        this.publicationDate = publicationDate; 
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        if(issn != null && !issn.isEmpty()) {
            this.issn = issn;
        } else {
            System.out.println("Invalid ISSN");
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume > 0) {
            this.volume = volume;
        } else {
            System.out.println("Invalid Volume");
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if(issueNumber > 0) {
            this.issueNumber = issueNumber;
        } else {
            System.out.println("Invalid IssueNumber");
        }
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        if(publicationDate != null && !publicationDate.isEmpty()) {
            this.publicationDate = publicationDate;
        } else {
            System.out.println("Invalid Publication Date");
        }
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
    return new String[] {
        getTitle(),
        publisher != null ? publisher : "",
        issn != null ? issn : "",
        String.valueOf(volume),
        String.valueOf(issueNumber),
        publicationDate != null ? publicationDate : ""
        }; 
    }

    
   // @Override 
    // public boolean matchesKeyword(String keyword) {
        //for (String field : getSearchableFields()) {                        // checks for the keywords ignoring case sensitivity but 
            //if (field.toLowerCase().contains(keyword.toLowerCase())) {      // LibraryItem class already does this (repetitive) 
                //return true;
            //}
       // }
        //return false; 
    //}
}
