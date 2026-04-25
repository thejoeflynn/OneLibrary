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

    static void booksScreen() {
        while (true) { 
            System.out.println("[BOOKS] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      _____________      ___________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout |    | 4. Help   |    | 5. Home |");
            System.out.println("    |___________|    |_____________|    |_____________|    |___________|    |_________|");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("[BOOKS] Search coming soon.");
                    break;
                case "2":
                    System.out.println("[BOOKS] View All coming soon."); 
                    break;
                case "3":
                    System.out.println("[BOOKS] Checkout coming soon.");
                    break;   
                case "4":
                    System.out.println("[BOOKS] Come on you got this.");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[ONELIBRARY] Unknown command.");
            }

        }
    }

    static void dvdsScreen() {
        while (true) { 
            System.out.println("[DVDs] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      _____________      __________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout |    | 4. Help  |    | 5. Home | ");
            System.out.println("    |___________|    |_____________|    |_____________|    |__________|    |_________| ");
            System.out.println(" ");
            System.out.println("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("[DVDs] Search coming soon.");
                    break;
                case "2":
                    System.out.println("[DVDs] View All coming soon."); 
                    break;
                case "3":
                    System.out.println("[DVDs] Checkout coming soon.");   
                    break;
                case "4":
                    System.out.println("[DVDs] FIGURE IT OUT!");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("[DVDs] Unknown command.");
            }

        }
    }

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
                    System.out.println("[PERIODICALS] Search coming soon.");
                    break;
                case "2":
                    System.out.println("[PERIODICALS] View All coming soon."); 
                    break;
                case "3":
                    System.out.println("[PERIODICALS] Checkout coming soon.");   
                    break;
                case "4":
                    System.out.println("[PERIODICALS] Return coming soon.");
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

    static void loadBooks() {
        try {
            java.io.File file = new java.io.File("//FILENAME");
            if (!file.exists()) return;
            
        } catch (Exception e) {
            System.out.println("[ONELIBRARY Error loading Books.");
        }
    }

}