package todo_list.Model.TaskCreators.SecondMenu;

import todo_list.Model.Acrions.AbstractTask;
import todo_list.Model.Acrions.TaskInterface;
import todo_list.Model.Tasks.SecondMenu.GoToMainMenu;

public class GoToMainMenuCreator extends AbstractTask{
    @Override
    public TaskInterface createTaskObj() {
        return new GoToMainMenu();
    }
}
