package com.zipcodewilmington.OneLibrary;

import java.util.Scanner;

public class MainApplication {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeScreen();
    }

    static void welcomeScreen() {
        System.out.println("[ONELIBRARY] Welcome to OneLibrary! Type a number to select an option.");
        System.out.println("    |1. Login|");
        System.out.println("    |2. New Account|");
        System.out.print("> ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                loginScreen();
            case "2":
                newAccountScreen();
            default:
                System.out.println("[ONELIBRARY] Come on there's two choices just pick one.");
        }

    }

    static void loginScreen(){
        System.out.println("[ONELIBRARY] Please type in your member ID.");
        System.out.println("> ");
        String memberID = scanner.nextLine();
        System.out.println("[ONELIBRARY] Welcome User!");
        homeScreen();
    }

    static void homeScreen(){
        System.out.println("[ONELIBRARY] What would you like to do? Type a number to select an option");
        System.out.println("    |1. BOOKS|  |2. DVDs|   |3. CHECKOUT HISTORY|   |4. PROFILE|    |5. HELP|   |6. LOGOUT|");
        System.out.print("> ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" :
                System.out.println("[ONELIBRARY] Books coming soon. Clay tablets available now!");
            case "2" :
                System.out.println("[ONELIBRARY] DVDs and nonsense coming soon.");
            case "3" :
                System.out.println("[ONELIBRARY] You can't checkout anything yet!");
            case "4":
                System.out.println("[ONELIBRARY] Profile coming soon.");
            case "5" :
                System.out.println("[ONELIBRARY] No help for you!");
            case "6" :
                welcomeScreen();
            default:
                System.out.println("[ONELIBRARY] Unknown command. Type '5' for help.");
        }

    }

    static void newAccountScreen() {
        System.out.println("[ONELIBRARY] Coming soon");
        welcomeScreen();
    }

}