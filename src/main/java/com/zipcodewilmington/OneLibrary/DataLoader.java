package com.zipcodewilmington.OneLibrary;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class DataLoader {

    // =========================
    // LOAD ALL
    // =========================
    public void loadAll(Library library) {
    String basePath = "src/main/java/com/zipcodewilmington/OneLibrary/DATA/";
    loadBooks(basePath + "Book.csv", library);
    loadDVDs(basePath + "DVD.csv", library);
    loadPeriodicals(basePath + "Periodical.csv", library);
    loadMusic(basePath + "Music.csv", library);

        // Periodical Temporarily disabled to get the thing working
        //loadPeriodicalTitles("periodical-titles.csv");
        //loadPeriodicalIssues("periodical-issues.csv", library);
    }
 
    // =========================
    // LOAD BOOKS
    // =========================
    
    private void loadBooks(String filePath, Library library) {
        
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            
            String[] parts;
            reader.readNext(); 

            while ((parts = reader.readNext()) != null) {
                if (parts.length < 7) {
                    System.out.println("Skipping invalid book row");
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
                    System.out.println("Invalid number in row: ");
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // LOAD DVDS
    // =========================            
                 
     private void loadDVDs(String filePath, Library library) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] parts;
            reader.readNext(); 

            while ((parts = reader.readNext()) != null) {

                if (parts.length < 6) {
                    System.out.println("Skipping invalid DVD row: ");
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String director = parts[3].trim();
                //String durationStr = parts[4].trim();
                String rating = parts[4].trim();
                String genre = parts[5].trim();

                try {
                    //int duration = Integer.parseInt(durationStr);

                    DVD dvd = new DVD(
                            id,
                            title,
                            location,
                            director,
                            0,
                            rating,
                            genre
                    );

                    library.addItem(dvd);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration in row: ");
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }  
    
    // =========================
    // PERIODICAL COMBINED
    // =========================

    private void loadPeriodicals(String filePath, Library library) {
    try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] parts;
            reader.readNext(); 

            while ((parts = reader.readNext()) != null) {
            if (parts.length < 8) {
                System.out.println("Skipping invalid periodical row: ");
                continue;
            }

            String id = parts[0].trim();
            String title = parts[1].trim();
            String location = parts[2].trim();
            String publisher = parts[3].trim();
            String issn = parts[4].trim();
            String volumeStr = parts[5].trim();
            String issueStr = parts[6].trim();
            String publicationDate = parts[7].trim();

            try {
                int volume = Integer.parseInt(volumeStr);
                int issueNumber = Integer.parseInt(issueStr);

                Periodical p = new Periodical(
                        id,
                        title,
                        location,
                        publisher,
                        issn,
                        volume,
                        issueNumber,
                        publicationDate
                );

                library.addItem(p);
            } catch (NumberFormatException e) {
                //System.out.println("Invalid number in periodical row: " + line);
            }
        }
    } catch (IOException | CsvValidationException e) {
        e.printStackTrace();
    }
}

private void loadMusic(String filePath, Library library) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] parts;
            reader.readNext(); 

            while ((parts = reader.readNext()) != null) {

                if (parts.length < 8) {
                    System.out.println("Skipping invalid Music row: ");
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String artist = parts[3].trim();
                String date = parts[4].trim();
                String genre = parts[5].trim();
                String lyrics = parts[6].trim();
                String lengthA = parts[7].trim();

                try {
                    int length = Integer.parseInt(lengthA);
                    Music music = new Music(
                            id,
                            title,
                            location,
                            artist,
                            date,
                            genre,
                            lyrics,
                            length
                    );

                    library.addItem(music);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration in row: ");
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }  

    public static void main(String[] args) {
        DataLoader loader = new DataLoader();
        Library library = new Library();

        loader.loadAll(library);
    
        System.out.println("=== ITEMS LOADED ===");
        for (LibraryItem item : library.getItems()) {
        System.out.println(item.getItemType() + " | " + item.getTitle());
        }
}

    // // =========================
    // // PRINT ISSUES
    // // =========================
    // System.out.println("\n=== ISSUES LOADED ===");

    // for (LibraryItem item : library.getItems()) {
    //     Periodical p = (Periodical) item;

    //     System.out.println(
    //         p.getId() + " | " +
    //         p.getTitle() + " | " +
    //         p.getVolume() + " | " +
    //         p.getIssueNumber() + " | " +
    //         p.getPublicationDate()
    //     );
    //     }
    // }


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