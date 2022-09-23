package loginPage;

import util.PrintHandler;

import java.util.List;

public class LoginPageView {
    public LoginPageView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.showAppHeader();
        PrintHandler.showEmptyLine();
        System.out.println("The Menu options are ");
        PrintHandler.showMenuOptions(menuOptions);
        PrintHandler.showAskUserForInput();
    }

}
