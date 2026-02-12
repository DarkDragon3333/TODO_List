package todo_list.Model.Acrions;

public abstract class AbstractTask {
    public abstract TaskInterface createTaskObj();

    public void complite(){
        TaskInterface compliteTask = createTaskObj();
        compliteTask.compliteThisTask();
    }
}
