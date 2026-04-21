package com.zipcodewilmington.centrallibrary;

public abstract class LibraryItem {
    private String id;
    private String title;
    private String location;
    private boolean isAvailable;


    public String getId(){
        return id;
    }
    
    public void setId(String id) {
        if(id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Invalid ID");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid Title");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if(location != null && !location.isEmpty()) {
            this.location = location;
        } else {
          System.out.println("Invalid Location");
        }
    }
    public void checkIn() {
        isAvailable = true;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public boolean matchesKeyword(String keyword) {
        if(keyword == null || keyword.isEmpty()) return false;
        String [] fields = getSearchableFields();
        for(String field : fields) {
            if(field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public abstract String[] getSearchableFields();

    public abstract double calculateLateFee(int daysLate);

    public abstract int getMaxBorrowDays();

    public abstract String getItemType();

}
