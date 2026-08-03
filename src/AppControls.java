

public class AppControls {
    private ToDoListApp appView;
    


    
    public AppControls(ToDoListApp appView){
        this.appView = appView;
        
    }

    public void processNewTask(String taskText){
        appView.addTask(taskText);
    }

    
    
}
