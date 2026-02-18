package todo_list.dataBased.model.factoryTask.taskCreators.FirstMenu;

import todo_list.dataBased.model.factoryTask.actions.AbstractTask;
import todo_list.dataBased.model.factoryTask.actions.TaskInterface;
import todo_list.dataBased.model.factoryTask.tasks.FirstMenu.RefactorNameList;

public class RefactorNameListCreator extends AbstractTask{

    @Override
    public TaskInterface createTaskObj() {
        return new RefactorNameList();
    }
}
