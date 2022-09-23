package util;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PrintHandler {
    public static void clearScreen() {
        String OperatingSystem = System.getProperty("os.name");

        if (OperatingSystem.toLowerCase().contains("windows")) {
            clearScreenWindows();
        } else {
            clearScreenUnix();
        }
    }

    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException error) {
            System.out.println();
        }
    }

    public static void showLoginHeader() {
        System.out.println("*** Welcome to WHS LoginPage *** ");
    }

    public static void showAskUserForInput() {
        System.out.print("Choose an option and press enter: ");
    }

    public static void showEmptyLine() {
        System.out.println();
    }

    public static void showInvalidInputOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void showInvalidInput() {
        System.out.print("⚠️ Invalid input,Enter a valid Input:  ");
    }

    public static void showAppHeader() {
        System.out.println("The Warehouse Management System - WMS ");
        System.out.println();
    }

    public static void exit() {
        System.out.println("Thanks for using Warehouse management system.");
        System.exit(1);
    }


    public static void showGoBackToMainMenu() {
        System.out.print("Press enter to go back to menu");
        try {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        } catch(Exception e) {

        }


    }

    public static void onInvalidInput() {
        showInvalidInputOption();
        showAskUserForInput();
    }

    public static void showMenuOptions(List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }

    public static String scanUserInputString() {
        String userInput="";
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            if (!(userInput.trim().isEmpty())) {
                return userInput;
            } else {
                showInvalidInput();
                scanUserInputString();
            }
        } catch (Exception e) {
            System.out.println("Scanner is not working");
        }

        return userInput;
    }


    public static boolean scanUserInputBoolean() {
        boolean value = false;
        String userInput;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            if (!(userInput.trim().isEmpty())) {
                if (userInput.equalsIgnoreCase("True")) {
                    value = true;
                    return true;
                } else if (userInput.equalsIgnoreCase("False")) {
                    value = false;
                    return value;
                }
            } else {
                showInvalidInput();
                scanUserInputString();
            }
        } catch (Exception e) {
            System.out.println("Scanner is not working");
        }
        return value;

    }


}