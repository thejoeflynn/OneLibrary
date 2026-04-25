package com.zipcodewilmington.OneLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalLoader {

    private Map<String, Periodical> titles = new HashMap<>();

    public void loadTitles(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",", -1);
                String[] parts = line.split(",", -1);

                if (parts.length < 4) {
                    System.out.println("Skipping invalid title row: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String publisher = parts[3].trim();

                Periodical periodical = new Periodical(
                        id,
                        title,
                        location,
                        publisher,
                        "",   
                        0,   
                        0,   
                        ""   
                        "",   
                        0,   
                        0,   
                        ""   
                );

                titles.put(id, periodical);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadIssues(String filePath, Library library) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",", -1);
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

                    Periodical base = titles.get(id);

                    if (base == null) {
                        System.out.println("Missing title for id: " + id);
                        continue;
                    }

                    // Full issue object
                    // Full issue object
                    Periodical periodical = new Periodical(
                            id + "-V" + volume + "I" + issue,
                            base.getTitle(),
                            base.getLocation(),
                            base.getPublisher(),
                            "",  
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
        return titles;
    }

    public static void main(String[] args) {
    public static void main(String[] args) {

    PeriodicalLoader loader = new PeriodicalLoader();
    Library library = new Library();
    PeriodicalLoader loader = new PeriodicalLoader();
    Library library = new Library();

    loader.loadTitles("src/main/java/com/zipcodewilmington/OneLibrary/periodical-titles.csv");
    loader.loadIssues("src/main/java/com/zipcodewilmington/OneLibrary/periodical-issues.csv", library);
    loader.loadTitles("src/main/java/com/zipcodewilmington/OneLibrary/periodical-titles.csv");
    loader.loadIssues("src/main/java/com/zipcodewilmington/OneLibrary/periodical-issues.csv", library);

    // =========================
    // PRINT TITLES
    // =========================
    System.out.println("=== TITLES LOADED ===");

    for (String key : loader.getTitles().keySet()) {
        Periodical p = loader.getTitles().get(key);

        System.out.println(
            p.getId() + " | " +
            p.getTitle() + " | " +
            p.getPublisher()
        );
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

}