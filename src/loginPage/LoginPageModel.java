package loginPage;

import java.util.List;

public class LoginPageModel extends UserValidation {
    private static final List<String> menuOptions = List.of("Login", "Exit");

    private static void exit() {
        System.out.println("Thanks for using Warehouse management system.");
        System.exit(1);
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> getUserDetails();
            case 2 -> exit();
        } new LoginPage();
    }
}
