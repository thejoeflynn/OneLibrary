package com.zipcodewilmington.OneLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataLoader {

    // =========================
    // LOAD ALL
    // =========================
    public void loadAll(Library library) {
        loadBooks("books.csv", library);
        loadDVDs("dvds.csv", library);

        // Periodicals use two files
        loadPeriodicalTitles("periodical-titles.csv");
        loadPeriodicalIssues("periodical-issues.csv", library);
    }
 
    // =========================
    // LOAD BOOKS
    // =========================
    
    private void loadBooks(String filePath, Library library) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 7) {
                    System.out.println("Skipping invalid book row: " + line);
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

    // =========================
    // LOAD DVDS
    // =========================            
                 
     private void loadDVDs(String filePath, Library library) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();  // Skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",", -1);

                if (parts.length < 7) {
                    System.out.println("Skipping invalid DVD row: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String director = parts[3].trim();
                String durationStr = parts[4].trim();
                String rating = parts[5].trim();
                String genre = parts[6].trim();

                try {
                    int duration = Integer.parseInt(durationStr);

                    DVD dvd = new DVD(
                            id,
                            title,
                            location,
                            director,
                            duration,
                            rating,
                            genre
                    );

                    library.addItem(dvd);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration in row: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    
    // =========================
    // PERIODICAL TITLES
    // =========================
    
    private Map<String, Periodical> periodicalTitles = new HashMap<>();

    private void loadPeriodicalTitles(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

        String line;
        br.readLine();

        while ((line = br.readLine()) != null) {

            String[] parts = line.split(",", -1);

            if (parts.length < 4) {
                System.out.println("Skipping invalid title row: " + line);
                continue;
            }

            String id = parts[0].trim();
            String title = parts[1].trim();
            String location = parts[2].trim();
            String publisher = parts[3].trim();

            Periodical p = new Periodical(
                    id,
                    title,
                    location,
                    publisher,
                    "",
                    0,
                    0,
                    ""
            );

            periodicalTitles.put(id, p);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    // =========================
    // LOAD PERIODICAL ISSUES
    // =========================
    private void loadPeriodicalIssues(String filePath, Library library) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();  // Skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",", -1);

                if (parts.length < 6) {
                    System.out.println("Skipping invalid issue row: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String volumeStr = parts[3].trim();
                String issueStr = parts[4].trim();
                String date = parts[5].trim();

                try {
                    int volume = Integer.parseInt(volumeStr);
                    int issue = Integer.parseInt(issueStr);

                    Periodical base = periodicalTitles.get(id);

                    if (base == null) {
                        System.out.println("Missing title for id: " + id);
                        continue;
                    }

                    // Full issue object
                    Periodical periodical = new Periodical(
                            id + "-V" + volume + "I" + issue,
                            base.getTitle(),
                            base.getLocation(),
                            base.getPublisher(),
                            "",  
                            volume,
                            issue,
                            date
                    );

                    library.addItem(periodical);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in row: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Periodical> getTitles() {
    return new HashMap<>(periodicalTitles);
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