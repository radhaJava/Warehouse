package manager;
/*
Manager can view order and update the order by approving
 */
public class Manager {
    public Manager() {
        ManagerModel model = new ManagerModel();
        ManagerView view = new ManagerView(model.getMenuOptions());
        ManagerController controller = new ManagerController(model, view);
        controller.requestUserInput();
    }
}
