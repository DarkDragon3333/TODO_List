package todo_list.Model.TaskCreators.FirstMenu;

import todo_list.Model.Acrions.AbstractTask;
import todo_list.Model.Acrions.TaskInterface;
import todo_list.Model.Tasks.FirstMenu.CheckHistory;

public class CheckHistoryCreator extends AbstractTask{

    @Override
    public TaskInterface createTaskObj() {
        return new CheckHistory();
    }

}
