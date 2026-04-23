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
            System.out.println("     ________    _______     ____________     __________      _______     _________ ");
            System.out.println("    |1. BOOKS|  |2. DVDs|   |3. CHECKOUTS|   |4. PROFILE|    |5. HELP|   |6. LOGOUT|");
            System.out.println("    |________|  |_______|   |____________|   |__________|    |_______|   |_________| ");
            System.out.print("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" :
                    booksScreen();
                    break;
                case "2" :
                    System.out.println("[ONELIBRARY] DVDs and nonsense coming soon.");
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
            System.out.println("     _________      ___________      __________________      ________________      _______ ");
            System.out.println("    |1. Search|    |2. View All|    |3. Checkout a Book|    |4. Return a Book|    |5. Home|");
            System.out.println("    |_________|    |___________|    |__________________|    |________________|    |_______|");
        }
    }

    static void newAccountScreen() {
        System.out.println("[ONELIBRARY] Coming soon");
        welcomeScreen();
    }

}