package admin;

import util.PrintHandler;

import java.util.List;

public class AdminView {

    public AdminView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.showAppHeader();
        PrintHandler.showEmptyLine();
        System.out.println("The Menu options are ");
        PrintHandler.showMenuOptions(menuOptions);
        PrintHandler.showAskUserForInput();
    }

}
