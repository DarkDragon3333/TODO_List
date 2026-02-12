package todo_list.Model.TaskCreators.FirstMenu;

import todo_list.Model.Acrions.AbstractTask;
import todo_list.Model.Acrions.TaskInterface;
import todo_list.Model.Tasks.FirstMenu.GoToList;

public class GoToListCreator extends AbstractTask{

    @Override
    public TaskInterface createTaskObj() {
        return new GoToList();
    }
}
