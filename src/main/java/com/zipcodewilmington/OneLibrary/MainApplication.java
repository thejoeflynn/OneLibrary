package com.zipcodewilmington.OneLibrary;

import java.util.Scanner;

public class MainApplication {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        welcomeScreen();
    }

    static void welcomeScreen(){
        while(true){
            System.out.println("[ONELIBRARY] Welcome to the OneLibrary!");
            System.out.println("Press 'RETURN' to continue.");
            System.out.println("> ");
            String memberID = scanner.nextLine();
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
                    homeScreen();
                    break;
                case "6" :
                    System.out.println("[ONELIBRARY] Are you sure you want to logout? Type 'Y' to confirm.");
                    System.out.println("> ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")){
                        System.out.println("[ONELIBRARY] Goodbye!");
                        return;
                    }
                    break;
                case "67":
                    System.out.println("Grow up.");
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
                    homeScreen();
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
                    System.out.println("[MEMBERS] Search coming soon.");
                    break;
                case "2":
                    System.out.println("[MEMBERS] View All coming soon."); 
                    break;
                case "3":
                    System.out.println("[MEMBERS] There will be members to add soon. Hopefully...");   
                    break;
                case "4":
                    System.out.println("[MEMBERS] idk just read the prompt.");
                case "5":
                    return;
                default:
                    System.out.println("[MEMBERS] Unknown command.");
            }

        }
    }

    static void newAccountScreen() {
        System.out.println("[ONELIBRARY] Coming soon");
        welcomeScreen();
    }

}