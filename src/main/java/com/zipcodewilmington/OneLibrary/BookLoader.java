package com.zipcodewilmington.OneLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookLoader {

    public void loadBooks(String filePath, Library library) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                // Safety check
                if (parts.length < 7) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String author = parts[3].trim();
                String isbn = parts[4].trim();
                String pagesStr = parts[5].trim();
                String genre = parts[6].trim();

                try {
                    int pages = Integer.parseInt(pagesStr);

                    Book book = new Book(
                            id,
                            title,
                            location,
                            author,
                            isbn,
                            pages,
                            genre
                    );

                    library.addItem(book);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in row: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // // =========================
    // // TEMP RUNNER (for debugging)
    // // =========================
    // public static void main(String[] args) {

    //     BookLoader loader = new BookLoader();
    //     Library library = new Library();

    //     loader.loadBooks("src/main/java/com/zipcodewilmington/OneLibrary/book.csv", library);

    //     System.out.println("=== BOOKS LOADED ===");

    //     for (LibraryItem item : library.getItems()) {
    //         Book book = (Book) item;

    //         System.out.println(
    //             book.getId() + " | " +
    //             book.getTitle() + " | " +
    //             book.getAuthor() + " | " +
    //             book.getGenre()
    //         );
    //     }
    // }
}