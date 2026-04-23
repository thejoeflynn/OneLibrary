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
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                // SAFETY CHECK
                if (parts.length < 4) {
                    System.out.println("Skipping invalid title row: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String publisher = parts[3].trim();

                Periodical periodical = new Periodical(
                        id,
                        title,
                        "Shelf-P",
                        publisher
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
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                // SAFETY CHECK
                if (parts.length < 7) {
                    System.out.println("Skipping invalid issue row: " + line);
                    continue;
                }

                // Column mapping (adjust if needed)
                String titleId = parts[1].trim();   // title_id
                String volumeStr = parts[4].trim();
                String issueStr = parts[5].trim();
                String date = parts[4].trim();

                try {
                    int volume = Integer.parseInt(volumeStr);
                    int issue = Integer.parseInt(issueStr);

                    Periodical base = titles.get(titleId);

                    if (base == null) {
                        System.out.println("Missing title for id: " + titleId);
                        continue;
                    }

                    Periodical p = new Periodical(
                            base.getId() + "-V" + volume + "I" + issue,
                            base.getTitle(),
                            base.getLocation(),
                            volume,
                            issue,
                            date
                    );

                    library.addItem(p);

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
}