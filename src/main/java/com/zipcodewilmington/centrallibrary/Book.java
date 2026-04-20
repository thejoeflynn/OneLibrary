package com.zipcodewilmington.OneLibrary;

public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private int pages;
    private String genre;

    public Book(String id, String title, String location,
            String author, String isbn, int pages, String genre) {

        setId(id);
        setTitle(title);
        setLocation(location);

        setAuthor(author);
        setIsbn(isbn);
        setPages(pages);
        setGenre(genre);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn != null && !isbn.isEmpty()) {
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN");
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if(pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Invalid Pages");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre != null && !genre.isEmpty()) {
            this.genre = genre;
        } else {
            System.out.println("Invalid Genre");
        }
    }
 
    @Override
    public String[] getSearchableFields() {
        return new String[] {
        getTitle(),
        author,
        genre,
        isbn
        };
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.5;
    }

    @Override
    public int getMaxBorrowDays() {
        return 14;
    }

    @Override
    public String getItemType() {
        return "book";
    }

}