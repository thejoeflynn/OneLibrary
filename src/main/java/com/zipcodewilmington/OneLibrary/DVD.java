package com.zipcodewilmington.OneLibrary;

public class DVD extends LibraryItem implements Reservable {

    private String director;
    private String rating;
    private String genre;
    private int duration;
    private boolean isReserved;

    public DVD(String id, String title, String location,
            String director, int duration, String rating, String genre) {

        super(id, title, location);
        //setId(id);
        //setTitle(title);
        //setLocation(location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
    }

    @Override
    public String[] getSearchableFields() {
        return new String[] {
                getTitle(),
                director,
                genre,
                rating
        };
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.0;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void reserve() {
        isReserved = true;
    }

    @Override
    public void cancelReserve() {
        isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }
}