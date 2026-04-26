package com.zipcodewilmington.OneLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();
    static List<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        loadMembers();
        new DataLoader().loadAll(library);

        // TEMPORARY DEBUG
        System.out.println("Items loaded: " + library.getItems().size());

        welcomeScreen();
    }

    static void welcomeScreen(){
        while(true){
            System.out.println("[ONELIBRARY] Welcome to the OneLibrary!");
            System.out.println("Press 'RETURN' to continue.");
            System.out.println("> ");
            String input = scanner.nextLine();
            homeScreen();
        }
    }

    static void homeScreen(){
        while(true){
            System.out.println("[HOME] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     __________    _________     ________________     ____________      _________     ____________ ");
            System.out.println("    | 1. Books |  | 2. DVDs |   | 3. Periodicals |   | 4. Members |    | 5. Help |   | 6. Log Out | ");
            System.out.println("    |__________|  |_________|   |________________|   |____________|    |_________|   |____________| ");
            System.out.println(" ");
            System.out.print("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" :
                    booksScreen();
                    break;
                case "2" :
                    dvdsScreen();
                    break;
                case "3" :
                    periodicalsScreen();
                    break;
                case "4":
                    membersScreen();
                    break;
                case "5" :
                    System.out.println("[ONELIBRARY] No help for you!");
                    System.out.println("[ONELIBRARY] Ok maybe some help. To access any of the menus, type in a number.");
                    System.out.println("[ONELIBRARY] For example, if you type in '1' it will take you to the books page.");
                    System.out.println("[ONELIBRARY] You can figure it out.");
                    System.out.println("Press 'RETURN' to continue.");
                    System.out.println("> ");
                    String memberID = scanner.nextLine();
                    break;
                case "6" :
                    System.out.println("[ONELIBRARY] Are you sure you want to logout? Type 'Y' to confirm.");
                    System.out.println("> ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")){
                        System.out.println("[ONELIBRARY] Goodbye!");
                        System.exit(0);
                    }
                    break;
                case "67":
                    System.out.println("[ONELIBRARY] Grow up.");
                    System.out.println("Press 'RETURN' to grow up and continue.");
                    System.out.println("> ");
                    String input = scanner.nextLine();
                    break;
                default:
                    System.out.println("[ONELIBRARY] Unknown command. Type '5' for help.");
                break;
            }
        }
        
    }

//===============
// BOOKS SCREEN
//===============

    static void booksScreen() {
        while (true) { 
            System.out.println("[BOOKS] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      _____________      _____________      _________     ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout |    | 4. Return   |    | 5. Home |    ");
            System.out.println("    |___________|    |_____________|    |_____________|    |_____________|    |_________|    ");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchFlow("Book");
                    break;
                case "2":
                    System.out.println("[BOOKS] Showing all books:");
                    for (LibraryItem item : library.getItems()) {
                        if (item.getItemType().equalsIgnoreCase("Book")) {
                            String avail = item.isAvailable() ? "Available" : "Out";
                            String reserved = item.isReserved() ? " [RESERVED]" : "";
                            System.out.println("    " + item.getTitle() + " [" + item.getId() + "] - " + avail + reserved);
                        }
                    }
                    System.out.println("Press 'RETURN' to continue.");
                    System.out.println("> ");
                    String input = scanner.nextLine();
                    break;
                case "3":
                    checkoutFlow("Book");
                    break; 
                case "4":
                    returnFlow("Book");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[ONELIBRARY] Unknown command.");
            }

        }
    }

//===============
// DVDs SCREEN
//===============
 
    static void dvdsScreen() {
        while (true) { 
            System.out.println("[DVDs] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      _____________      ____________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout |    | 4. Return  |    | 5. Home | ");
            System.out.println("    |___________|    |_____________|    |_____________|    |____________|    |_________| ");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchFlow("DVD");
                    break;
                case "2":
                    System.out.println("[DVDs] Showing all DVDs:");
                    for (LibraryItem item : library.getItems()) {
                        if (item.getItemType().equalsIgnoreCase("DVD")) {
                            String avail = item.isAvailable() ? "Available" : "Out";
                            String reserved = item.isReserved() ? " [RESERVED]" : "";
                            System.out.println("    " + item.getTitle() + " [" + item.getId() + "] - " + avail + reserved);
                        }
                    }
                    System.out.println("Press 'RETURN' to continue.");
                    System.out.println("> ");
                    String input = scanner.nextLine();
                    break;
                case "3":
                    checkoutFlow("DVD");
                    break;
                case "4":
                    returnFlow("DVD");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[DVDs] Unknown command.");
            }

        }
    }

//======================
// PERIODICALS SCREEN
//======================

    static void periodicalsScreen() {
        while (true) { 
            System.out.println("[PERIODICALS] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      _____________      ___________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout |    | 4. Return |    | 5. Home | ");
            System.out.println("    |___________|    |_____________|    |_____________|    |___________|    |_________| ");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchFlow("Periodical");
                    break;
                case "2":
                    System.out.println("[PERIODICALS] Showing all periodicals:"); 
                    for (LibraryItem item : library.getItems()) {
                        if (item.getItemType().equalsIgnoreCase("Periodical")){
                            String avail = item.isAvailable() ? "Available" : "Out";
                            String reserved = item.isReserved() ? " [RESERVED" : "";
                            System.out.println("    " + item.getTitle() + " [" + item.getId() + "] - " + avail + reserved);
                        }
                    }
                    break;
                case "3":
                    checkoutFlow("Periodical");
                    break;
                case "4":
                    returnFlow("Periodical");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[PERIODICALS] Unknown command.");
            }

        }
    }

    static void membersScreen() {
        while (true) { 
            System.out.println("[MEMBERS] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      ____________________      __________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Add New Member. |    | 4. Help  |    | 5. Home | ");
            System.out.println("    |___________|    |_____________|    |____________________|    |__________|    |_________| ");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("[MEMBERS] Enter member ID: ");
                    String searchId = scanner.nextLine();
                    boolean found = false;
                    for (Member m : members) {
                        if (m.getMemberId().equalsIgnoreCase(searchId)) {
                        System.out.println("    ID: " + m.getMemberId());
                        System.out.println("    Name: " + m.getName());
                        System.out.println("    Email: " + m.getEmail());
                        System.out.println("    Phone: " + m.getPhoneNumber());
                        System.out.println("    Address: " + m.getAddress());
                        System.out.println("    Membership Date: " + m.getMembershipDate());
                        System.out.println("    Outstanding Fees: $" + m.getOutstandingFees());
                        found = true;
                        break;
                        }
                    }
                    if (!found) {
                        System.out.println("[MEMBERS] Member not found.");
                    }
                    break;
                case "2":
                    if (members.isEmpty()) {
                        System.out.println("[MEMBERS] No members found.");
                    } else {
                        System.out.println("[MEMBERS] All Members:");
                    for (Member m : members) {
                        System.out.println("    " + m.getMemberId() + " | " + m.getName() + " | " + m.getEmail());
                        }
                    }
                    System.out.println("Press 'RETURN' to continue.");
                    System.out.println("> ");
                    String memberID = scanner.nextLine();
                    break;
                case "3":
                    addNewMemberScreen();  
                    break;
                case "4":
                    System.out.println("[MEMBERS] idk just read the prompt.");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[MEMBERS] Unknown command.");
            }

        }
    }

    static void addNewMemberScreen() {
        System.out.println("[MEMBERS] New Member Registration");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Member ID: ");
        String memberID = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("Zip Code: ");
        String zip = scanner.nextLine();

        Address address = new Address(street, city, state, zip);
        String membershipDate = LocalDate.now().toString();
        Member member = new Member(name, age, email, phone, memberID, membershipDate, address);
        members.add(member);
        saveMember(member);
        System.out.println("[MEMBERS] Member " + name + " added successfully! ID: " + memberID);
    }

    static void saveMember(Member member) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("members.csv", true);
            fw.write(member.getMemberId() + "," +
                     member.getName() + "," +
                     member.getAge() + "," +
                     member.getEmail() + "," +
                     member.getPhoneNumber() + "," +
                     member.getMembershipDate() + "," +
                     member.getAddress().getStreet() + "," +
                     member.getAddress().getCity() + "," +
                     member.getAddress().getState() + "," +
                     member.getAddress().getZipCode() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("[ONELIBRARY] Error saving member.");
        }
    }

    static void loadMembers() {
        try {
            java.io.File file = new java.io.File("members.csv");
            if (!file.exists()) return;
            java.util.Scanner fileScanner = new java.util.Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String memberId = parts[0].trim();
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String email = parts[3].trim();
                String phone = parts[4].trim();
                String membershipDate = parts[5].trim();
                Address address = new Address(parts[6].trim(), parts[7].trim(), parts[8].trim(), parts[9].trim());
            members.add(new Member(name, age, email, phone, memberId, membershipDate, address));
        }
        fileScanner.close();
        } catch (Exception e) {
            System.out.println("[ONELIBRARY] Error loading members.");
        }
    }

    // Finds a member by ID. Returns null if not found.
    static Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equalsIgnoreCase(id)) {
            return m;
            }
        }
        return null;
    }

    // Checkout flow going with the flow yeah. Pass "Book", "DVD", or "Periodical" to scope it.
    static void checkoutFlow(String itemType) {
        String tag = "[" + itemType.toUpperCase() + "]";

        System.out.print(tag + " Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println(tag + " Member not found.");
            return;
        }

        System.out.print("Enter search keyword (or press RETURN for all " + itemType + "s): ");
        String keyword = scanner.nextLine();

        List<LibraryItem> candidates = new ArrayList<>();
            for (LibraryItem item : library.getItems()) {
            if (!item.getItemType().equalsIgnoreCase(itemType)) continue;
            if (keyword.isEmpty() || item.matchesKeyword(keyword)) {
            candidates.add(item);
            }
        }

        if (candidates.isEmpty()) {
            System.out.println(tag + " No matching " + itemType.toLowerCase() + "s found.");
            return;
        }

        System.out.println("Results:");
        for (int i = 0; i < candidates.size(); i++) {
            LibraryItem item = candidates.get(i);
            String status = item.isAvailable() ? "Available" : "Unavailable";
            System.out.println("    " + (i + 1) + ". " + item.getTitle() + " [" + item.getId() + "] - " + status);
        }

        System.out.print("Select a number (or 0 to cancel): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(tag + " Invalid number.");
            return;
        }
        if (choice == 0) return;
        if (choice < 1 || choice > candidates.size()) {
            System.out.println(tag + " Number out of range.");
            return;
        }

        LibraryItem selected = candidates.get(choice - 1);
        if (!selected.isAvailable()) {
            System.out.println(tag + " That item is already checked out.");
            return;
        }

        member.borrowItem(selected);
        System.out.println(tag + " " + selected.getTitle() + " checked out to " + member.getName() + ".");
    }

    // Generic return flow. Prompts for daysLate since Library doesn't track due dates.
    static void returnFlow(String itemType) {
        String tag = "[" + itemType.toUpperCase() + "]";

        System.out.print(tag + " Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println(tag + " Member not found.");
            return;
        }

        List<LibraryItem> borrowed = new ArrayList<>();
        for (LibraryItem item : member.getBorrowedItems()) {
            if (item.getItemType().equalsIgnoreCase(itemType)) {
                borrowed.add(item);
            }
        }

        if (borrowed.isEmpty()) {
            System.out.println(tag + " " + member.getName() + " has no " + itemType.toLowerCase() + "s checked out.");
            return;
        }

        System.out.println("Borrowed " + itemType.toLowerCase() + "s:");
        for (int i = 0; i < borrowed.size(); i++) {
            LibraryItem item = borrowed.get(i);
            System.out.println("    " + (i + 1) + ". " + item.getTitle() + " [" + item.getId() + "]");
        }

        System.out.print("Select a number to return (or 0 to cancel): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(tag + " Invalid number.");
            return;
        }
        if (choice == 0) return;
        if (choice < 1 || choice > borrowed.size()) {
            System.out.println(tag + " Number out of range.");
            return;
        }

        System.out.print("Days late (0 if on time): ");
        int daysLate;
        try {
            daysLate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(tag + " Invalid number. Assuming 0.");
            daysLate = 0;
        }
        if (daysLate < 0) daysLate = 0;

        LibraryItem selected = borrowed.get(choice - 1);

        double before = member.getOutstandingFees();
        member.returnItem(selected, daysLate);
        double charged = member.getOutstandingFees() - before;

        if (charged > 0) {
            System.out.println(tag + " Returned. Late fee: $" + charged + ". Outstanding: $" + member.getOutstandingFees());
        } else {
            System.out.println(tag + " Returned on time. Thanks!");
        }
    }

    // Generic search/view-all flow. Empty keyword = view all.
    static void searchFlow(String itemType) {
        String tag = "[" + itemType.toUpperCase() + "]";

        System.out.print("Enter search keyword (or press RETURN for all " + itemType + "s): ");
        String keyword = scanner.nextLine();

        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : library.getItems()) {
            if (!item.getItemType().equalsIgnoreCase(itemType)) continue;
            if (keyword.isEmpty() || item.matchesKeyword(keyword)) {
            results.add(item);
            }
        }

        if (results.isEmpty()) {
            System.out.println(tag + " No matching " + itemType.toLowerCase() + "s found.");
            return;
        }

        System.out.println("Results (" + results.size() + "):");
        for (LibraryItem item : results) {
            String avail = item.isAvailable() ? "Available" : "Out";
            String reserved = item.isReserved() ? " [RESERVED]" : "";
            System.out.println("    " + item.getTitle() + " [" + item.getId() + "] - " + avail + reserved);
        }
    }

    // Toggles reservation. If item is reserved, asks to cancel; if not, asks to reserve.
    static void reserveFlow(String itemType) {
        String tag = "[" + itemType.toUpperCase() + "]";

        System.out.print("Enter search keyword to find item: ");
        String keyword = scanner.nextLine();

        List<LibraryItem> candidates = new ArrayList<>();
        for (LibraryItem item : library.getItems()) {
            if (!item.getItemType().equalsIgnoreCase(itemType)) continue;
            if (keyword.isEmpty() || item.matchesKeyword(keyword)) {
                candidates.add(item);
            }
        }

        if (candidates.isEmpty()) {
            System.out.println(tag + " No matching " + itemType.toLowerCase() + "s found.");
            return;
        }

        System.out.println("Results:");
        for (int i = 0; i < candidates.size(); i++) {
            LibraryItem item = candidates.get(i);
            String reserved = item.isReserved() ? " [RESERVED]" : "";
            System.out.println("    " + (i + 1) + ". " + item.getTitle() + " [" + item.getId() + "]" + reserved);
        }

        System.out.print("Select a number (or 0 to cancel): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(tag + " Invalid number.");
            return;
        }
        if (choice == 0) return;
        if (choice < 1 || choice > candidates.size()) {
            System.out.println(tag + " Number out of range.");
            return;
        }

        LibraryItem selected = candidates.get(choice - 1);
        if (selected.isReserved()) {
            System.out.print("This item is currently reserved. Cancel reservation? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                selected.cancelReserve();
                System.out.println(tag + " Reservation cancelled for " + selected.getTitle() + ".");
            }
        } else {
            System.out.print("Reserve " + selected.getTitle() + "? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                selected.reserve();
                System.out.println(tag + " " + selected.getTitle() + " reserved.");
            }
        }
    }

}