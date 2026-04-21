<<<<<<< HEAD
package com.zipcodewilmington.OneLibrary;
    
=======
package com.zipcodewilmington.centrallibrary;

>>>>>>> 0505d0d (fixed searchable)
public abstract class LibraryItem {
    private String id;
    private String title;
    private String location;
    private boolean isAvailable;

<<<<<<< HEAD
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
=======

    public String getId(){
        return id;
    }
    
    public void setId(String id) {
        if(id != null && !id.isEmpty()) {
>>>>>>> 0505d0d (fixed searchable)
            this.id = id;
        } else {
            System.out.println("Invalid ID");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
<<<<<<< HEAD
        if (title != null && !title.isEmpty()) {
=======
        if(title != null && !title.isEmpty()) {
>>>>>>> 0505d0d (fixed searchable)
            this.title = title;
        } else {
            System.out.println("Invalid Title");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
<<<<<<< HEAD
        if (location != null && !location.isEmpty()) {
            this.location = location;
        } else {
            System.out.println("Invalid Location");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

=======
        if(location != null && !location.isEmpty()) {
            this.location = location;
        } else {
          System.out.println("Invalid Location");
        }
    }
>>>>>>> 0505d0d (fixed searchable)
    public void checkIn() {
        isAvailable = true;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public boolean matchesKeyword(String keyword) {
<<<<<<< HEAD
        if (keyword == null || keyword.isEmpty())
            return false;
        String[] fields = getSearchableFields();
        for (String field : fields) {
            if (field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
=======
        if(keyword == null || keyword.isEmpty()) return false;
        String [] fields = getSearchableFields();
        for(String field : fields) {
            if(field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
>>>>>>> 0505d0d (fixed searchable)
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
<<<<<<< HEAD


=======
>>>>>>> 0505d0d (fixed searchable)
