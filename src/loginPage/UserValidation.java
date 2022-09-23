package loginPage;

import admin.Admin;
import cashier.Cashier;
import manager.Manager;
import util.PrintHandler;
import util.Table;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    static List<User> userList = List.of(new User(1, "arun", "arun", "Cashier"),
            new User(2, "arun2", "arun2", "Cashier"),
            new User(3, "abi", "abi", "Manager"),
            new User(4, "radha", "radha", "Admin"));

    public static void showData() {
        generateTable(getUserList());
        PrintHandler.showGoBackToMainMenu();
    }

    private static List<User> getUserList() {
        return userList;
    }

    private static void generateTable(List<User> userList) {
        List<Integer> columnWidths = List.of(5, 15, 15, 15);
        List<String> headers = List.of("Index", "UserName", "User Password", "User Role");
        List<List<String>> body = parseInventory(userList);
        Table table = new Table(columnWidths, headers, body);
        table.showData();
    }

    private static List<List<String>> parseInventory(List<User> userList) {
        List<List<String>> result = new ArrayList<>();

        for (User item : userList) {
            String index = String.valueOf(item.getIndex());
            String name = item.getUserName();
            String password = item.getPassword();
            String role = item.getUserRole();
            List<String> data = List.of(index, name, password, role);
            result.add(data);
        }

        return result;
    }

    public void getUserDetails() {

        String userName, password;
        PrintHandler.showLoginHeader();
        PrintHandler.showEmptyLine();
        userName = getUserName();


        // for IDE uncomment the below
        //password = getUserPassword();
        //validateCustomerDetails(userName, password);

        // switch to terminal while working this code
        Console console = System.console();
        System.out.print("Enter password :");
        char[] password1 = console.readPassword();
        String password2 = String.valueOf(password1);
        validateCustomerDetails(userName, password2);

    }

    public String getUserPassword() {

        System.out.print("Enter password : ");
        String enteredPassword = PrintHandler.scanUserInputString();
        return enteredPassword;

    }

    private String getUserName() {
        System.out.print("Enter user name : ");
        String enteredName = PrintHandler.scanUserInputString();
        return enteredName;
    }

    private void validateCustomerDetails(String userName, String password) {

        for (User item : userList) {
            String getUserName = item.getUserName();
            String getPassword = item.getPassword();
            String getUserRole = item.getUserRole();
            if ((userName.equals(getUserName) && password.equals(getPassword))) {
                callUserRoleMethods(getUserName, getUserRole);
                break;
            }
        }getUserDetails();

    }


    private void callUserRoleMethods(String getUserName, String getUserRole) {
        System.out.println("Welcome to Mr/Miss : " + getUserName);
        System.out.println("You are logged in as " + getUserRole);
        switch (getUserRole) {
            case "Cashier" -> new Cashier();
            case "Manager" -> new Manager();
            case "Admin" -> new Admin();
        }

    }

}
