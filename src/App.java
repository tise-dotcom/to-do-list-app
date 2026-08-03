


public class App {
    public static void main(String[] args) throws Exception {

         
        ToDoListApp appView = new ToDoListApp();
        AppControls controls = new AppControls(appView);
        appView.setController(controls);
        appView.displayWindow();

            

         
        

    }
}
