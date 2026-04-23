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
            System.out.println("     __________    _________     _____________________     ____________      _________     ____________ ");
            System.out.println("    | 1. Books |  | 2. DVDs |   | 3. Checkout History |   | 4. Profile |    | 5. Help |   | 6. Log Out | ");
            System.out.println("    |__________|  |_________|   |_____________________|   |____________|    |_________|   |____________| ");
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
                    System.out.println("[ONELIBRARY] You can't checkout anything yet!");
                    break;
                case "4":
                    System.out.println("[ONELIBRARY] Profile coming soon.");
                    break;
                case "5" :
                    System.out.println("[ONELIBRARY] No help for you!");
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
            System.out.println("     ___________      _____________      ____________________      __________________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout a Book |    | 4. Return a Book |    | 5. Home |");
            System.out.println("    |___________|    |_____________|    |____________________|    |__________________|    |_________|");
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
                    System.out.println("[BOOKS] Return coming soon.");
                    break;
                case "5":
                    homeScreen();
            }

        }
    }

    static void dvdsScreen() {
        while (true) { 
            System.out.println("[DVDs] Type a number to select an option");
            System.out.println(" ");
            System.out.println("     ___________      _____________      ___________________      _________________      _________ ");
            System.out.println("    | 1. Search |    | 2. View All |    | 3. Checkout a DVD |    | 4. Return a DVD |    | 5. Home | ");
            System.out.println("    |___________|    |_____________|    |___________________|    |_________________|    |_________| ");
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
                    System.out.println("[DVDs] Return coming soon.");
                case "5":
                    return;
            }

        }
    }

    static void newAccountScreen() {
        System.out.println("[ONELIBRARY] Coming soon");
        welcomeScreen();
    }

}